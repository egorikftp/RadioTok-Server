package com.egoriku.radiotokserver

import com.egoriku.radiotokserver.plugins.configureRouting
import com.egoriku.radiotokserver.util.Properties.port
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.serialization.json.Json

fun main() {
    embeddedServer(factory = Netty, port = port) {
        install(CallLogging)
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                }
            )
        }
        configureRouting()
    }.start(wait = true)
}
