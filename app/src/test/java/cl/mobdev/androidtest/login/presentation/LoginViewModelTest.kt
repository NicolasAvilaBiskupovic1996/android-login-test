package cl.mobdev.androidtest.login.presentation

import androidx.navigation.NavController
import cl.mobdev.androidtest.ui.screens.login.domain.LoginResult
import cl.mobdev.androidtest.ui.screens.login.domain.LoginUseCase
import cl.mobdev.androidtest.ui.screens.login.presentarion.LoginViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

internal class LoginViewModelTest {

    private val useCase = mockk<LoginUseCase>()

    private val viewModel = LoginViewModel(
        loginUseCase = useCase
    )

    @Before
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @Test
    fun `given enterEmail when LoginUser then emit isLoading`() =
        runBlocking {
            val email = "nicolas@gmail.com"
            val password = "1234"
            val navController = mockk<NavController>()
            val trimmedEmail = "nicolas@gmail.com"

            coEvery { useCase.invoke(email, password) } returns LoginResult.Success(true)
            viewModel.loginUser(email, password, trimmedEmail, navController)

            val loadingViewState = viewModel.viewState.value
            assertEquals(loadingViewState.isLoading, true)
        }

    @Test
    fun `given useCase when LoginResult then emit Success`() =
        runBlocking {
            val email = "nicolas@gmail.com"
            val password = "1234"
            val navController = mockk<NavController>()
            val trimmedEmail = "nicolas@gmail.com"

            coEvery { useCase.invoke(email, password) } returns LoginResult.Success(true)
            viewModel.loginUser(email, password, trimmedEmail, navController)

            val result = useCase.invoke(email,password)
            assertEquals(result, LoginResult.Success(true))
        }

}