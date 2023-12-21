package cl.mobdev.androidtest.login.domain

import cl.mobdev.androidtest.ui.screens.login.data.sources.AuthenticationService
import cl.mobdev.androidtest.ui.screens.login.domain.LoginResult
import cl.mobdev.androidtest.ui.screens.login.domain.LoginUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertTrue

internal class LoginUseCaseTest {
    private val authServices = mockk<AuthenticationService>()

    private val useCase = LoginUseCase(
        authenticationService = authServices
    )

    @Test
    fun `given called when enterEmail then emit Succcess`() =
        runBlocking {
            val email = "nicolas@gmail.com"
            val password = "1234"

            coEvery { authServices.login(email, password) } returns
                    LoginResult.Success(
                        true
                    )

            val result = useCase(email, password)

            assertTrue(result is LoginResult.Success)
        }

    @Test
    fun `given called when enterEmail then emit ErrorException`() =
        runBlocking {
            val email = ""
            val password = ""

            coEvery { authServices.login(email, password) } returns
                    LoginResult.ErrorException(
                        exception = Exception()
                    )

            val result = useCase(email, password)

            assertTrue(result is LoginResult.ErrorException)
        }

    @Test
    fun `given called when enterEmail then emit Error`() =
        runBlocking {
            val email = ""
            val password = ""

            coEvery { authServices.login(email, password) } returns LoginResult.Error

            val result = useCase(email, password)

            assertTrue(result is LoginResult.Error)
        }

    @Test
    fun `given called when enterEmail then emit UserNotFound`() =
        runBlocking {
            val email = ""
            val password = ""

            coEvery { authServices.login(email, password) } returns LoginResult.UserNotFound(
                exception = Exception()
            )

            val result = useCase(email, password)

            assertTrue(result is LoginResult.UserNotFound)
        }
}