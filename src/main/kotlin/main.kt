const  val TIME_ONLINE = 86_500
const val MINUTES = TIME_ONLINE / 60
const val HOURS = TIME_ONLINE / 3600
const val HOUR_ENDING1 = "час"
const val HOUR_ENDING2 = "часа"
const val HOUR_ENDING3 = "часов"
const val MINUTE_ENDING1 = "минуту"
const val MINUTE_ENDING2 = "минуты"
const val MINUTE_ENDING3 = "минут"

fun main() {
    agoToText(TIME_ONLINE)
}

fun agoToText (TIME_ONLINE : Int) {
    when (TIME_ONLINE) {
        in 0..60 -> println("был(а) только что")
        in 61..3_600 -> {
            println("был(а) $MINUTES $timeMinute назад ")
        }
        in 3_601..86_400 -> {
            println("был(а) $HOURS $timeHour назад")
        }
        in 86_400..172_800 -> println("был(а) сегодня")
        in 172_801..259_200 -> println("был(а) вчера")
        else -> println("был(а) давно")
    }
}

val timeMinute = when {
     ((MINUTES % 10 == 1) && (MINUTES % 10 != 11)) -> MINUTE_ENDING1
     ((MINUTES % 10 == 2) || (MINUTES % 10 == 3) || (MINUTES % 10 == 4)) -> MINUTE_ENDING2
     else -> MINUTE_ENDING3
}

val timeHour = when {
    ((HOURS % 10 == 1) && (HOURS % 10 != 11)) -> HOUR_ENDING1
    ((HOURS % 10 == 2) || (HOURS % 10 == 3) || (HOURS % 10 == 4)) -> HOUR_ENDING2
    else -> HOUR_ENDING3
}