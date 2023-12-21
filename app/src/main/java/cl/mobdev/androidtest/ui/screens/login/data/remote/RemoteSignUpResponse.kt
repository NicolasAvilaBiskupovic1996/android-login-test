package cl.mobdev.androidtest.ui.screens.login.data.remote

import com.google.gson.annotations.SerializedName

data class RemoteSignUpResponse(
    @SerializedName("code") val statusCode: Int,
    @SerializedName("message") val message: String
)