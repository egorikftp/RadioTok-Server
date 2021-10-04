package com.egoriku.radiotokserver.di

import com.egoriku.radiotokserver.db.DatabaseManager
import com.egoriku.radiotokserver.repository.DbRadioStationRepository
import com.egoriku.radiotokserver.repository.RadioStationRepository
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.dsl.single

val radioTokModule = module {
    single<DatabaseManager>()

    single<DbRadioStationRepository>() bind RadioStationRepository::class
}