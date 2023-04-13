package com.example.digikalacomposeproject.util

object Constants {
    const val ENGLISH_LANG = "en"
    const val PERSIAN_LANG = "fa"
    const val DATASTORE_NAME = "DIGIKALA_DATA_STORE"
    const val TIMEOUT_IN_SECOND: Long = 60
    const val BASE_URL = "https://dig-za0p.onrender.com/api/"

    var USER_LANGUAGE = "USER_LANGUAGE"
}

/** USER_LANGUAGE --> we don't want to use const for this variable because it is not a constant and may user change it. */