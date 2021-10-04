package com.egoriku.radiotokserver.repository

import com.egoriku.radiotokserver.db.DatabaseManager
import com.egoriku.radiotokserver.entity.StationEntity
import com.egoriku.radiotokserver.entity.StationEntityDraft

class DbRadioStationRepository(
    private val databaseManager: DatabaseManager
) : RadioStationRepository {

    override fun getAllStations(): List<StationEntity> {
        return databaseManager.getAllRadioStations()
    }

    override fun getStation(id: String): StationEntity? {
        TODO("Not yet implemented")
    }

    override fun addRadioStation(draft: StationEntityDraft): StationEntity {
        TODO("Not yet implemented")
    }

    override fun removeRadioStation(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun updateRadioStation(id: String, draft: StationEntityDraft): Boolean {
        TODO("Not yet implemented")
    }
}