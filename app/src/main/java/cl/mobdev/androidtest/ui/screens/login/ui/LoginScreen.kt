package cl.mobdev.androidtest.ui.screens.login.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.mobdev.androidtest.R
import cl.mobdev.androidtest.ui.navigation.AppScreens
import cl.mobdev.androidtest.ui.screens.login.presentarion.LoginViewModel
import cl.mobdev.androidtest.ui.screens.login.ui.components.BackButton
import cl.mobdev.androidtest.ui.screens.login.ui.components.ButtonLogin
import cl.mobdev.androidtest.ui.screens.login.ui.components.EmailField
import cl.mobdev.androidtest.ui.screens.login.ui.components.Footer
import cl.mobdev.androidtest.ui.screens.login.ui.components.PasswordField
import cl.mobdev.androidtest.ui.screens.login.ui.components.Title

@SuppressLint("UnrememberedMutableState", "SuspiciousIndentation")
@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    onClick: () -> Unit,
    navController: NavController
) {
    val loginViewState by loginViewModel.viewState.collectAsState()
    val navigateLoginUser by loginViewModel.navigateToDetails.collectAsState()
    var navigate by remember { mutableStateOf(false) }
    val context = LocalContext.current

    if (navigateLoginUser && !navigate) {
        navController.navigate(AppScreens.OnBoardingPaymentsReceipts.route)
        navigate = true
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
    ) {
        var email = remember { mutableStateOf("") }
        var password = remember { mutableStateOf("") }
        BackButton(navController = navController)
        Title()
        EmailField(
            textValue = email
        )

        PasswordField(
            textValue = password,
            loginViewState = loginViewState
        )

        Row(
            modifier = Modifier
                .padding(top = 30.dp)
                .padding(start = 125.dp)
                .background(Color.White)
        ) {
            ButtonLogin(
                text = stringResource(id = R.string.start_session),
                email.value.length > 2 &&
                        password.value.length > 2
            ) {
                loginViewModel.onLoginSelected(
                    email = email.value,
                    password = password.value,
                    navController, trimmedEmail = ""
                )
            }
        }
        Footer(onClick)
    }
}
