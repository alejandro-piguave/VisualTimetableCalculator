package window

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import data.CourseClassRoom
import presentation.composables.Timetable

@Composable
fun ResultWindow(onCloseRequest: () -> Unit, rows: List<String>, columns: List<String>, schedules: List<List<List<CourseClassRoom?>>>) {
    Window(onCloseRequest = onCloseRequest, title = "Result") {
        LazyColumn {
            items(schedules.size) { index ->
                val item = schedules[index]
                Timetable(rows, columns, item)
            }
        }
    }
}