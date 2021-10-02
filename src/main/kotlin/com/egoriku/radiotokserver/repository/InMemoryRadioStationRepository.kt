package com.egoriku.radiotokserver.repository

import com.egoriku.radiotokserver.entity.StationEntity
import com.egoriku.radiotokserver.entity.StationEntityDraft
import com.egoriku.radiotokserver.util.TimestampUtils.iSO8601StringForCurrentDate
import java.util.*

class InMemoryRadioStationRepository : RadioStationRepository {

    private val stations = mutableListOf(
        StationEntity(
            stationUuid = "fkwer23gs",
            name = "Test station name",
            streamUrl = "https://kek.com",
            homepageUrl = "https://kekosina.com",
            stationLogo = "https://cheburek.com/j.jpeg",
            countryCode = "BY",
            lastChangeTime = "2021",
            bitrate = "320kbps",
            genres = emptyList(),
            languageCodes = emptyList()
        ),
        StationEntity(
            stationUuid = "eeererere",
            name = "Test station name",
            streamUrl = "https://kek.com",
            homepageUrl = "https://kekosina.com",
            stationLogo = "https://cheburek.com/j.jpeg",
            countryCode = "BY",
            lastChangeTime = "2022",
            bitrate = "320kbps",
            genres = emptyList(),
            languageCodes = emptyList()
        )
    )

    override fun getAllStations(): List<StationEntity> {
        return stations
    }

    override fun getStation(id: String): StationEntity? {
        return stations.firstOrNull { it.stationUuid == id }
    }

    override fun addRadioStation(draft: StationEntityDraft): StationEntity {
        val radioStation = StationEntity(
            stationUuid = UUID.randomUUID().toString(),
            name = draft.name,
            streamUrl = draft.streamUrl,
            homepageUrl = draft.homepageUrl,
            stationLogo = draft.stationLogo,
            countryCode = draft.countryCode,
            lastChangeTime = iSO8601StringForCurrentDate,
            bitrate = draft.bitrate,
            genres = draft.genres,
            languageCodes = draft.languageCodes
        )

        stations.add(radioStation)

        return radioStation
    }

    override fun removeRadioStation(id: String): Boolean {
        return stations.removeIf { it.stationUuid == id }
    }

    override fun updateRadioStation(id: String, draft: StationEntityDraft): Boolean {
        val station = stations.firstOrNull { it.stationUuid == id } ?: return false

        stations.remove(station)

        val updatedStation = station.copy(
            name = draft.name,
            streamUrl = draft.streamUrl,
            homepageUrl = draft.homepageUrl,
            stationLogo = draft.stationLogo,
            countryCode = draft.countryCode,
            lastChangeTime = iSO8601StringForCurrentDate,
            bitrate = draft.bitrate,
            genres = draft.genres,
            languageCodes = draft.languageCodes
        )

        stations.add(updatedStation)

        return true
    }
}