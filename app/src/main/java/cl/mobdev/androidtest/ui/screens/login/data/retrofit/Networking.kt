package cl.mobdev.androidtest.ui.screens.login.data.retrofit

import android.util.Log
import cl.mobdev.androidtest.ui.screens.login.data.sources.APIService
import cl.mobdev.androidtest.ui.screens.login.data.remote.RemoteSignUpParams
import cl.mobdev.androidtest.ui.screens.login.data.remote.RemoteSignUpResponse
import cl.mobdev.androidtest.ui.screens.login.data.models.Constants.url_prod
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Networking {
    fun getRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(url_prod)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    suspend fun postLoginStatus(token: RemoteSignUpParams): RemoteSignUpResponse {
        runCatching {
            withContext(Dispatchers.IO){
                getRetrofit().create(APIService::class.java).signUP("/signUp", token)
            }
        }.fold(
            onSuccess = {response ->
                Log.d("Endpoint Info", response.code().toString())
                Log.d("Endpoint Info", response.body()?.messageResponse.orEmpty())

                return RemoteSignUpResponse(
                    statusCode = response.code(),
                    message = response.body()?.messageResponse.orEmpty()
                )
            },
            onFailure = { error ->
                Log.e("Endpoint", error.toString())
                return RemoteSignUpResponse(
                    statusCode = 400,
                    message = error.message.toString()
                )
            }
        )
    }
}