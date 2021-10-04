package com.egoriku.radiotokserver.db.dao

import com.egoriku.radiotokserver.db.table.RadioStationTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class RadioStationDao(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<RadioStationDao>(RadioStationTable)

    var name by RadioStationTable.name
    var stationUuid by RadioStationTable.stationUuid
}