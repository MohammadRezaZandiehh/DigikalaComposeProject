package com.example.digikalacomposeproject.util

object Constants {
    const val ENGLISH_LANG = "en"
    const val PERSIAN_LANG = "fa"
    const val DATASTORE_NAME = "DIGIKALA_DATA_STORE"

    var USER_LANGUAGE = "USER_LANGUAGE"
}

/** USER_LANGUAGE --> we don't want to use const for this variable because it is not a constant and may user change it. */