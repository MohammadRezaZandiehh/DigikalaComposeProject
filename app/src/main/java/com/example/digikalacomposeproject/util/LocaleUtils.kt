package com.example.digikalacomposeproject.util

import android.content.Context
import android.content.res.Configuration
import java.util.Locale

object LocaleUtils {

    fun setLocale(context: Context, language: String) = updateResource(context, language)

    private fun updateResource(context: Context, language: String) {
        context.resources.apply {
            val locale = Locale(language)
            val config = Configuration(configuration)

            context.createConfigurationContext(configuration)
            //pass default locale:
            Locale.setDefault(locale)
            //pass new locale:
            config.setLocale(locale)
            //set new configuration to previous one:
            context.resources.updateConfiguration(config, displayMetrics)
        }
    }
}

/**
 * According to the Android documentation, a Locale is:

* An object that represents a specific geographical, political, or cultural region.
An operation that requires a Locale to perform its task is called locale-sensitive and uses the Locale
to tailor information for the user.

* If you are dealing with dates and time zones, currencies or multiple language support,
you probably faced some challenges to make everything work as intended and finally you should work with Locale.

 * updateResource() --> this fun reset the previous font and set the new one*/