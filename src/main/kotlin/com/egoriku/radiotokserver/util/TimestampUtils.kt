package com.egoriku.radiotokserver.util

import java.text.SimpleDateFormat
import java.util.*

object TimestampUtils {
    /**
     * Return an ISO 8601 combined date and time string for current date/time
     *
     * @return String with format "yyyy-MM-dd'T'HH:mm:ss'Z'"
     */
    val iSO8601StringForCurrentDate: String
        get() = getISO8601StringForDate(Date())

    /**
     * Return an ISO 8601 combined date and time string for specified date/time
     *
     * @param date
     * Date
     * @return String with format "yyyy-MM-dd'T'HH:mm:ss'Z'"
     */
    private fun getISO8601StringForDate(date: Date): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US).apply {
            timeZone = TimeZone.getTimeZone("UTC")
        }

        return dateFormat.format(date)
    }
}