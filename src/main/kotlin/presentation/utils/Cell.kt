package presentation.utils

fun getCellIndex(row: Int, column: Int, columns: Int): Int {
    return row * columns + column
}