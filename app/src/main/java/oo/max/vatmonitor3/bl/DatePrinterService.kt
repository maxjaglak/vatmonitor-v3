package oo.max.vatmonitor3.bl

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatePrinterService @Inject constructor() {

    private val dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd")
    private val dateTimeFormat = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")

    fun printDate(timestamp: Long): String {
        val dateTime = DateTime(timestamp)
        return dateFormat.print(dateTime)
    }

}