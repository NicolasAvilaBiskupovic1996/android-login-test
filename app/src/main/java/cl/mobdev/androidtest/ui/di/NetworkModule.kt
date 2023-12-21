package cl.mobdev.androidtest.ui.di

import android.util.Log
import cl.mobdev.androidtest.BuildConfig
import cl.mobdev.androidtest.ui.di.Constants.AUTH_TOKEN_NAME
import cl.mobdev.androidtest.ui.di.Constants.DEV
import cl.mobdev.androidtest.ui.di.Constants.DEV_URL
import cl.mobdev.androidtest.ui.di.Constants.THIRTY
import cl.mobdev.androidtest.ui.screens.login.data.retrofit.FirebaseClient
import cl.mobdev.androidtest.ui.screens.login.data.sources.AuthenticationService
import cl.mobdev.androidtest.ui.screens.login.presentarion.SharedPreferencesLogin
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit.SECONDS

@Module
internal class NetworkModule {
    @Provides
    fun url(): String {
        return DEV_URL
    }

    @Provides
    fun provideRetrofit(
        url: String,
        client: OkHttpClient
    ): Retrofit {
        if (BuildConfig.FLAVOR == DEV) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val authInterceptor = AuthInterceptor()

            val okHttpClient =
                OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .addInterceptor(authInterceptor)
                    .connectTimeout(THIRTY.toLong(), SECONDS)
                    .readTimeout(THIRTY.toLong(), SECONDS)
                    .build()

            return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        } else {
            return Retrofit.Builder()
                .client(client)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

    @Provides
    fun provideOkHttpClient(authInterceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .connectTimeout(THIRTY.toLong(), SECONDS)
            .readTimeout(THIRTY.toLong(), SECONDS)
            .build()
    @Provides
    fun provideAuthentication(): AuthenticationService {
        return AuthenticationService(FirebaseClient())
    }
}

internal class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = SharedPreferencesLogin.fetchAuthToken()
        val originalRequest = chain.request()
        //val token = runBlocking { getFirebaseToken() ?: "" }
        val modifiedRequest = originalRequest.newBuilder()
            .addHeader(
                AUTH_TOKEN_NAME,
                "Bearer $token"
            )
            .build()
        val response = chain.proceed(modifiedRequest)
        response.headers.names().forEach { name ->
            Log.d("HEADER", "$name: ${response.headers[name]}")
        }
        return response
    }
}
