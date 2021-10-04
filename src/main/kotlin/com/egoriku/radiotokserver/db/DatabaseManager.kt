package com.egoriku.radiotokserver.db

import com.egoriku.radiotokserver.db.credentials.DbCredentials
import com.egoriku.radiotokserver.db.dao.RadioStationDao
import com.egoriku.radiotokserver.entity.StationEntity
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

class DatabaseManager {

    init {
        Database.connect(
            url = DbCredentials.url,
            user = DbCredentials.user,
            password = DbCredentials.password
        )
    }

    fun getAllRadioStations(): List<StationEntity> {
        return transaction {
            RadioStationDao.all().map {
                StationEntity(
                    stationUuid = it.stationUuid,
                    name = it.name,
                    streamUrl = "",
                    homepageUrl = "",
                    stationLogo = "",
                    countryCode = "",
                    lastChangeTime = "",
                    bitrate = "",
                    genres = emptyList(),
                    languageCodes = emptyList()
                )
            }
        }
    }
}