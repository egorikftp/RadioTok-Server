package com.egoriku.radiotokserver.plugins

import com.egoriku.radiotokserver.entity.StationEntityDraft
import com.egoriku.radiotokserver.repository.InMemoryRadioStationRepository
import com.egoriku.radiotokserver.repository.RadioStationRepository
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import kotlinx.serialization.json.Json

fun Application.configureRouting() {
    val repository: RadioStationRepository = InMemoryRadioStationRepository()

    routing {
        get("/") {
            call.respondText("RadioTok collection, stay tune!")
        }

        get("/stations") {
            call.respond(repository.getAllStations())
        }

        get("/station") {
            val id = call.request.queryParameters["id"]

            if (id.isNullOrEmpty()) {
                call.respond(
                    status = HttpStatusCode.BadRequest,
                    message = "id parameter is null or empty"
                )

                return@get
            }

            val radioStation = repository.getStation(id = id)

            if (radioStation == null) {
                call.respond(
                    status = HttpStatusCode.NotFound,
                    message = "radio station with id \"$id\" not found"
                )
            } else {
                call.respond(radioStation)
            }
        }

        post("/stations") {
            val stationEntityDraft = call.receive<StationEntityDraft>()
            val station = repository.addRadioStation(stationEntityDraft)
            call.respond(station)

            call.respond(station)
        }

        put("/stations") {
            val stationId = call.request.queryParameters["id"]
            val stationEntityDraft = call.receive<StationEntityDraft>()

            if (stationId.isNullOrEmpty()) {
                call.respond(
                    status = HttpStatusCode.BadRequest,
                    message = "id parameter is null or empty"
                )
                return@put
            }

            when (repository.updateRadioStation(id = stationId, draft = stationEntityDraft)) {
                true -> call.respond(HttpStatusCode.OK)
                false -> call.respond(
                    status = HttpStatusCode.NotFound,
                    message = "radio station with id \"$stationId\" not found"
                )
            }
        }

        delete("/stations") {
            val stationId = call.request.queryParameters["id"]

            if (stationId.isNullOrEmpty()) {
                call.respond(
                    status = HttpStatusCode.BadRequest,
                    message = "id parameter is null or empty"
                )
                return@delete
            }

            when (repository.removeRadioStation(stationId)) {
                true -> call.respond(HttpStatusCode.OK)
                false -> call.respond(
                    status = HttpStatusCode.NotFound,
                    message = "radio station with id \"$stationId\" not found"
                )
            }
        }
    }
}
