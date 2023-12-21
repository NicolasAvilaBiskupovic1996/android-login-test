package cl.mobdev.androidtest

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface APIService {
    @POST
    suspend fun signUP(
        @Url url: String,
        @Body token: RemoteSignUpParams
    ): Response<LoginStatusResponse>
}