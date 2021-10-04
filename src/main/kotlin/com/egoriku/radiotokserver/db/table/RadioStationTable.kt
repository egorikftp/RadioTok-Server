package com.egoriku.radiotokserver.db.table

import org.jetbrains.exposed.dao.id.IntIdTable

object RadioStationTable : IntIdTable(name = "station", columnName = "id") {

    val stationUuid = char(name = "stationuuid", length = 127)
    val name = varchar(name = "name", length = 127)
}