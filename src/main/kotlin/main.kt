const val HOUR_ENDING1 = "час"
const val HOUR_ENDING2 = "часа"
const val HOUR_ENDING3 = "часов"
const val MINUTE_ENDING1 = "минуту"
const val MINUTE_ENDING2 = "минуты"
const val MINUTE_ENDING3 = "минут"
const val MINUTE = 60
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun main() {
    val timeOnline = 16_500
    val minutes = timeOnline / MINUTE
    val hours = timeOnline / HOUR
    agoToText(timeOnline, minutes, hours, MINUTE, HOUR, DAY)
}

fun agoToText(timeOnline: Int, minutes: Int, hours: Int, MINUTE: Int, HOUR: Int, DAY: Int) {
    return when (timeOnline) {
        in 0..60 -> println("был(а) только что")
        in MINUTE + 1..HOUR -> {
            val timeMinute = time(minutes, hours, timeOnline, MINUTE, HOUR, DAY)
            println("был(а) $minutes $timeMinute назад ")
        }
        in HOUR + 1..DAY -> {
            val timeHour = time(minutes, hours, timeOnline, MINUTE, HOUR, DAY)
            println("был(а) $hours $timeHour назад")
        }
        in DAY + 1..DAY * 2 -> println("был(а) сегодня")
        in DAY * 2 + 1..DAY * 3 -> println("был(а) вчера")
        else -> println("был(а) давно")
    }
}

fun time(minutes: Int, hours: Int, timeOnline: Int, MINUTE: Int, HOUR: Int, DAY: Int): String {
    val timeResult = when (timeOnline) {
        in MINUTE + 1..HOUR -> minutes
        in HOUR + 1..DAY -> hours
        else -> error("ошибка")
    }
    return when {
        ((timeResult % 10 == 1) && (timeResult % 10 != 11)) ->
            if (timeResult == minutes) MINUTE_ENDING1 else HOUR_ENDING1
        ((timeResult % 10 in 2..4) && (timeResult !in 12..14)) ->
            if (timeResult == minutes) MINUTE_ENDING2 else HOUR_ENDING2
        else ->
            if (timeResult == minutes) MINUTE_ENDING3 else HOUR_ENDING3
    }
}