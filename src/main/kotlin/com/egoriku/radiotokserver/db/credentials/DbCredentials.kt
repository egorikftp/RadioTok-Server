package com.egoriku.radiotokserver.db.credentials

import com.egoriku.radiotokserver.util.Properties
import java.net.URI

object DbCredentials {

    private val uri = URI(Properties.databaseUri)
    private val userAndPassword = uri.userInfo.split(":")
    private val host: String = uri.host
    private val port = uri.port
    private val databaseName = uri.path

    val user = userAndPassword[0]
    val password = userAndPassword[1]
    val url = "jdbc:postgresql://$host:$port$databaseName"
}