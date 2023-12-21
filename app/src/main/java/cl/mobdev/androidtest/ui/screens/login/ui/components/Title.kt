package cl.mobdev.androidtest.ui.screens.login.ui.components

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.mobdev.androidtest.R

@Composable
fun Title(){
    Text(
        text = stringResource(id = R.string.title_start_session), fontWeight = FontWeight.W800,
        modifier = Modifier
            .padding(start = 22.dp)
            .padding(top = 30.dp),
        fontSize = 24.dp.value.sp,
    )
}