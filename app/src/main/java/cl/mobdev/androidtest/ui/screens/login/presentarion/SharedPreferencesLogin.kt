package cl.mobdev.androidtest.ui.screens.login.presentarion

object SharedPreferencesLogin {

    private var tokenShared = ""

    fun saveAuthToken(token: String) {
        tokenShared = token;
    }

    fun fetchAuthToken(): String? {
        return tokenShared
    }

}