package com.egoriku.radiotokserver.plugins

import com.egoriku.radiotokserver.di.radioTokModule
import io.ktor.application.*
import org.koin.ktor.ext.Koin
import org.koin.logger.slf4jLogger

fun Application.installKoin() {
    install(Koin) {
        slf4jLogger()
        modules(radioTokModule)
    }
}