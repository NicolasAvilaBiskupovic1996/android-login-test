package cl.mobdev.androidtest.ui.screens.login.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import cl.mobdev.androidtest.ui.screens.login.presentarion.states.LoginViewState

@SuppressLint("UnrememberedMutableState")
@Composable
fun PasswordField(
    textValue: TextFieldValue,
    loginViewState: LoginViewState,
    onValueChange: (TextFieldValue) -> Unit,
) {
    Text(
        text = "password",
        Modifier
            .padding(start = 22.dp)
            .padding(top = 10.dp),
        fontWeight = FontWeight.Bold
    )
    val passwordVisible = mutableStateOf(false)
    val visualTransformation = if (passwordVisible.value)
        VisualTransformation.None
    else PasswordVisualTransformation()

    TextField(
        value = textValue,
        onValueChange = {
            onValueChange
        },
        modifier = Modifier
            .padding(start = 22.dp)
            .padding(end = 22.dp)
            .height((45.dp))
            .fillMaxWidth(),
        visualTransformation = visualTransformation,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Black,
            unfocusedIndicatorColor = Color.Gray,
            disabledIndicatorColor = Color.Transparent,
            backgroundColor = Color.White
        ),
        placeholder = {
        }
    )

    when {
        loginViewState?.isValidEmail == false -> {
            Text(
                text = "email",
                modifier = Modifier.padding(start = 22.dp)
            )
        }

        loginViewState?.isValidPassword == false -> {
            Text(
                text = "password valid",
                modifier = Modifier.padding
                    (start = 22.dp)
            )
        }

        loginViewState.userNotExist -> {
            Text(
                text = "usuario no existe",
                modifier = Modifier.padding
                    (start = 22.dp)
            )
        }
    }
}