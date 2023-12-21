package cl.mobdev.androidtest.ui.di

internal object Constants {
    const val DEV = "dev"
    const val SUCCESS_CODE = 200
    const val THIRTY = 30
    const val AUTH_TOKEN_NAME = "Authorization"
    const val CONTENT_TYPE = "application/json"
    const val DUMMY_MOCK_ERROR = "Error: Don't recognize Json File or URL."

    // HOME-INTERCEPTOR
    const val DEV_URL = "https://padok-bff.herokuapp.com/"
    const val HOME_URL = "my/home"
    const val HOME_MOCK_JSON = "mock.api/my/home_get.json"

    // GET_EVENT-INTERCEPTOR
    const val CREATE_EVENT_URL ="/my/events"
    const val CREATE_EVENT_MOCK_JSON = "mock.api/events/events_post.json"
}
