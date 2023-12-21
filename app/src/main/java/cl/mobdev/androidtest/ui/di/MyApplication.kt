package cl.mobdev.androidtest.ui.di

import android.app.Application
import kotlinx.coroutines.FlowPreview

internal class MyApplication : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }


}
