package cl.mobdev.androidtest.ui.screens.login.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import cl.mobdev.androidtest.R

@Composable
fun Footer(onClick: () -> Unit) {
    Row(modifier = Modifier.padding(start = 80.dp)) {
        TextButton(onClick = { onClick.invoke() }) {
            Text(
                text = stringResource(id = R.string.forget_password), modifier = Modifier
                    .padding(start = 22.dp)
                    .padding(top = 22.dp),
                Color.Black, textDecoration = TextDecoration.Underline
            )
        }
    }
}