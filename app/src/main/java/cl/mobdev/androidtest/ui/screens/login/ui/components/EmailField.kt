package cl.mobdev.androidtest.ui.screens.login.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun EmailField(
    textValue: MutableState<String>,
) {
    Text(
        text = "email",
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 22.dp, top = 50.dp)
    )
    TextField(
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        modifier = Modifier
            .height((50.dp))
            .padding(start = 22.dp)
            .padding(end = 22.dp)
            .fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Black,
            unfocusedIndicatorColor = Color.Gray,
            disabledIndicatorColor = Color.Black,
            backgroundColor = Color.White
        ),
        placeholder = {
        }
    )
}