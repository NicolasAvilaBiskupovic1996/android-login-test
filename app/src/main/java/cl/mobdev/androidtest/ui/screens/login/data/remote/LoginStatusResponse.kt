package cl.mobdev.androidtest.ui.screens.login.data.remote

import com.google.gson.annotations.SerializedName

data class LoginStatusResponse(@SerializedName("message") val messageResponse: String)
