package cl.mobdev.androidtest.ui.screens.login.domain

import cl.mobdev.androidtest.ui.screens.login.data.sources.AuthenticationService
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authenticationService: AuthenticationService) {
    suspend operator fun invoke(email: String, password: String) =
        authenticationService.login(email, password)
}