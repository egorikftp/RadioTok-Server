package com.egoriku.radiotokserver.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StationEntity(
    @SerialName("station_uuid")
    val stationUuid: String,

    @SerialName("name")
    val name: String,

    @SerialName("stream_url")
    val streamUrl: String,

    @SerialName("homepage_url")
    val homepageUrl: String,

    @SerialName("station_logo")
    val stationLogo: String,

    @SerialName("country_code")
    val countryCode: String,

    @SerialName("last_change_time")
    val lastChangeTime: String,

    @SerialName("bitrate")
    val bitrate: String,

    @SerialName("genres")
    val genres: List<String>,

    @SerialName("language_codes")
    val languageCodes: List<String>
)
