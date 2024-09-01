import androidx.compose.runtime.*
import androidx.compose.ui.window.application
import data.CourseClassRoom
import window.MainWindow
import window.ResultWindow

val defaultColumns = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")
val defaultRows = listOf("9:00-11:00", "11:00-13:00", "13:00-15:00", "15:00-17:00", "17:00-19:00", "19:00-21:00")

fun main() = application {
    var showResult by remember { mutableStateOf(false) }
    var result by remember { mutableStateOf<List<List<List<CourseClassRoom?>>>>(emptyList()) }

    val rows = remember { mutableStateListOf<String>().apply { addAll(defaultRows) } }
    val columns = remember { mutableStateListOf<String>().apply { addAll(defaultColumns) } }
    MainWindow(
        onCloseRequest = ::exitApplication,
        onShowResult = { showResult = true },
        rows = rows,
        columns = columns,
        onAddColumn = { columns.add(it) },
        onAddRow = { rows.add(it) },
        onRemoveColumnAt = { columns.removeAt(it) },
        onRemoveRowAt = { rows.removeAt(it) },
    )
    if(showResult) {
        ResultWindow(onCloseRequest = { showResult = false }, rows, columns, result)
    }
}
