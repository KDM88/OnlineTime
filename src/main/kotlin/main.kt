const  val TIME_ONLINE = 86_500
const val MINUTES = TIME_ONLINE / 60
const val HOURS = TIME_ONLINE / 3600
const val hourEnding1 = "час"
const val hourEnding2 = "часа"
const val hourEnding3 = "часов"
const val minuteEnding1 = "минуту"
const val minuteEnding2 = "минуты"
const val minuteEnding3 = "минут"

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
     ((MINUTES % 10 == 1) && (MINUTES % 10 != 11)) -> minuteEnding1
     ((MINUTES % 10 == 2) || (MINUTES % 10 == 3) || (MINUTES % 10 == 4)) -> minuteEnding2
     else -> minuteEnding3
}

val timeHour = when {
    ((HOURS % 10 == 1) && (HOURS % 10 != 11)) -> hourEnding1
    ((HOURS % 10 == 2) || (HOURS % 10 == 3) || (HOURS % 10 == 4)) -> hourEnding2
    else -> hourEnding3
}