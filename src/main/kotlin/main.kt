const val HOUR_ENDING1 = "час"
const val HOUR_ENDING2 = "часа"
const val HOUR_ENDING3 = "часов"
const val MINUTE_ENDING1 = "минуту"
const val MINUTE_ENDING2 = "минуты"
const val MINUTE_ENDING3 = "минут"

fun main() {
    agoToText(timeOnline, minutes, hours)
}

val timeOnline = 1_500
val minutes = timeOnline / 60
val hours = timeOnline / 3600

fun agoToText(timeOnline: Int, minutes: Int, hours: Int) {
    when (timeOnline) {
        in 0..60 -> println("был(а) только что")
        in 61..3_600 -> {
            println("был(а) $minutes $timeMinute назад ")
        }
        in 3_601..86_400 -> {
            println("был(а) $hours $timeHour назад")
        }
        in 86_400..172_800 -> println("был(а) сегодня")
        in 172_801..259_200 -> println("был(а) вчера")
        else -> println("был(а) давно")
    }
}

val timeMinute = when {
    ((minutes % 10 == 1) && (minutes % 10 != 11)) -> MINUTE_ENDING1
    ((minutes % 10 == 2) || (minutes % 10 == 3) || (minutes % 10 == 4)) -> MINUTE_ENDING2
    else -> MINUTE_ENDING3
}

val timeHour = when {
    ((hours % 10 == 1) && (hours % 10 != 11)) -> HOUR_ENDING1
    ((hours % 10 == 2) || (hours % 10 == 3) || (hours % 10 == 4)) -> HOUR_ENDING2
    else -> HOUR_ENDING3
}