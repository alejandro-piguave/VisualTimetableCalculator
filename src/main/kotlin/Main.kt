import androidx.compose.runtime.*
import androidx.compose.ui.window.application
import window.MainViewModel
import window.MainWindow
import window.ResultWindow

val defaultColumns = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")
val defaultRows = listOf("9:00-11:00", "11:00-13:00", "13:00-15:00", "15:00-17:00", "17:00-19:00", "19:00-21:00")

fun main() = application {
    var showResult by remember { mutableStateOf(false) }

    val rows = remember { mutableStateListOf<String>().apply { addAll(defaultRows) } }
    val columns = remember { mutableStateListOf<String>().apply { addAll(defaultColumns) } }

    val coroutineScope = rememberCoroutineScope()
    val mainViewModel = remember { MainViewModel(coroutineScope) }
    val result by mainViewModel.timetables.collectAsState()

    LaunchedEffect(result) {
        println("launchedEffect ${result}")
        if (result.isNotEmpty()) {
            showResult = true
        }
    }
    MainWindow(
        onCloseRequest = ::exitApplication,
        hours = rows,
        days = columns,
        onAddColumn = { columns.add(it) },
        onAddRow = { rows.add(it) },
        onRemoveColumnAt = { columns.removeAt(it) },
        onRemoveRowAt = { rows.removeAt(it) },
        onCalculate = { hours, days, courses ->
            mainViewModel.calculate(hours, days, courses)
        }
    )
    if(showResult && result.isNotEmpty()) {
        ResultWindow(onCloseRequest = { showResult = false }, rows, columns, result)
    }
}
