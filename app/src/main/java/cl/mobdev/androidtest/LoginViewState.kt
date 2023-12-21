package cl.mobdev.androidtest

data class LoginViewState(
    val isLoading: Boolean = false,
    val isValidEmail: Boolean = true,
    val isValidPassword: Boolean = true,
    val userNotExist: Boolean = false,
    val isValidMail: Boolean = true
)