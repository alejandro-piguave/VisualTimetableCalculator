package presentation.utils

fun getCellIndex(hour: Int, day: Int, days: Int): Int {
    return hour * days + day
}