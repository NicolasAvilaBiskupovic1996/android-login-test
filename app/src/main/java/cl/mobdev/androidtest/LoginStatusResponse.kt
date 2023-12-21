package cl.mobdev.androidtest

import com.google.gson.annotations.SerializedName

data class LoginStatusResponse(@SerializedName("message") val messageResponse: String)
