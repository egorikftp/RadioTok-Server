package com.egoriku.radiotokserver.util

object Properties {

    private const val debug = false

    val port: Int
        get() = when {
            debug -> 8080
            else -> System.getenv("PORT").toInt()
        }

    val databaseUri: String
        get() = when {
            debug -> ""
            else -> System.getenv("DATABASE_URL")
        }
}