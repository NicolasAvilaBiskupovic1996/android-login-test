package cl.mobdev.androidtest.ui.screens.login.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonLogin(
    text: String,
    enabled: Boolean,
    onClick: () -> Unit
) {
    val textColor = if (enabled) {
        Color.Black
    } else {
        Color.White
    }
    Button(
        onClick = {
            onClick.invoke()
        },
        modifier = Modifier
            .clip(shape = RoundedCornerShape(30.dp))
            .size(
                width = (150.dp),
                height = (38.dp)
            ), colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Yellow,
            disabledBackgroundColor = Color.Blue
        ), enabled = enabled
    ) {
        Text(
            text = text,
            fontSize = 14.dp.value.sp,
            color = textColor,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.W800,
            textAlign = TextAlign.Center
        )
    }
}