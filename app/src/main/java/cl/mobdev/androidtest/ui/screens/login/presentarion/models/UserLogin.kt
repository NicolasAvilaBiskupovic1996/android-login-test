package cl.mobdev.androidtest.ui.screens.login.presentarion.models

data class UserLogin(
    val email: String = "",
    val password: String = "",
    val showErrorDialog: Boolean = false
)