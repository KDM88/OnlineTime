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
    val timeOnline = 15_000
    val result = agoToText(timeOnline)
    println("был(а) в сети $result")
}

fun agoToText(timeOnline: Int): String {
    return when (timeOnline) {
        in 0..MINUTE -> "только что"
        in MINUTE + 1..HOUR -> {
            val minutes = timeOnline / MINUTE
            val timeMinute = time(minutes, MINUTE_ENDING1, MINUTE_ENDING2, MINUTE_ENDING3)
            "$minutes $timeMinute назад"
        }
        in HOUR + 1..DAY -> {
            val hours = timeOnline / HOUR
            val timeHour = time(hours, HOUR_ENDING1, HOUR_ENDING2, HOUR_ENDING3)
            "$hours $timeHour назад"
        }
        in DAY + 1..DAY * 2 -> "сегодня"
        in DAY * 2 + 1..DAY * 3 -> "вчера"
        else -> "давно"
    }
}

fun time(timeResult: Int, ending1: String, ending2: String, ending3: String): String {
    return when {
        ((timeResult % 10 == 1) && (timeResult % 10 != 11)) -> ending1
        ((timeResult % 10 in 2..4) && (timeResult !in 12..14)) -> ending2
        else -> ending3
    }
}