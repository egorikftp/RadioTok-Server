package com.egoriku.radiotokserver.repository

import com.egoriku.radiotokserver.entity.StationEntity
import com.egoriku.radiotokserver.entity.StationEntityDraft

interface RadioStationRepository {

    fun getAllStations(): List<StationEntity>

    fun getStation(id: String): StationEntity?

    fun addRadioStation(draft: StationEntityDraft): StationEntity

    fun removeRadioStation(id: String): Boolean

    fun updateRadioStation(id: String, draft: StationEntityDraft): Boolean
}