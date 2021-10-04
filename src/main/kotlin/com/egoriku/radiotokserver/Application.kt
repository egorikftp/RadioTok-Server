package com.egoriku.radiotokserver

import com.egoriku.radiotokserver.plugins.installJson
import com.egoriku.radiotokserver.plugins.installKoin
import com.egoriku.radiotokserver.plugins.installRouting
import com.egoriku.radiotokserver.util.Properties.port
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(factory = Netty, port = port) {
        install(CallLogging)
        installJson()
        installKoin()
        installRouting()
    }.start(wait = true)
}