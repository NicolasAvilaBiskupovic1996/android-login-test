package cl.mobdev.androidtest.ui.screens.login.domain

import com.google.firebase.auth.AuthResult

sealed class SignInResult {
    object Error : SignInResult()
    object EmailUse : SignInResult()
    data class Success(val authResult: AuthResult) : SignInResult()
    data class UserNotFound(val exception: Exception) : SignInResult()
    data class ErrorException(val exception: Exception) : SignInResult()
}