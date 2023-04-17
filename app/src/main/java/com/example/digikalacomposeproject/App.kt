package com.example.digikalacomposeproject

import android.app.Application
import com.bugfender.sdk.Bugfender
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    override fun onCreate() {
        super.onCreate()
    Bugfender.init(this, "hABGCWQbGK2ZPlGlWzYY1FhIGuwiuaTx", BuildConfig.DEBUG)
    Bugfender.enableCrashReporting()
    Bugfender.enableUIEventLogging(this)
    Bugfender.enableLogcatLogging() // optional, if you want logs automatically collected from logcat
    }
}