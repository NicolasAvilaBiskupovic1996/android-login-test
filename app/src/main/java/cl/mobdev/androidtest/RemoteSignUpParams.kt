package cl.mobdev.androidtest

import com.google.gson.annotations.SerializedName

data class RemoteSignUpParams(@SerializedName("token") val token: String)