package cl.mobdev.androidtest.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cl.mobdev.androidtest.ui.di.MyApplication
import cl.mobdev.androidtest.ui.screens.login.presentarion.LoginViewModel
import cl.mobdev.androidtest.ui.screens.login.ui.LoginScreen
import cl.mobdev.androidtest.ui.theme.AndroidlogintestTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    internal lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidlogintestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    injectDependencies()
                    val navController: NavHostController = rememberNavController()
                    LoginScreen(
                        loginViewModel = loginViewModel,
                        onClick = { /*TODO*/ },
                        navController = navController
                    )

                }
            }
        }
    }

    private fun injectDependencies() {
        (application as MyApplication).appComponent.inject(this)
    }
}

private const val INTERVAL_SECONDS = 3600L