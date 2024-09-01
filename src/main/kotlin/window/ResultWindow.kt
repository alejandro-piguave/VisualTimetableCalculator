package window

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import data.Timetable
import presentation.composables.TimetableEditView

@Composable
fun ResultWindow(onCloseRequest: () -> Unit, rows: List<String>, columns: List<String>, schedules: List<Timetable>) {
    Window(onCloseRequest = onCloseRequest, title = "Result") {
        LazyColumn {
            items(schedules.size) { index ->
                val item = schedules[index]
                TimetableEditView(rows, columns, item)
            }
        }
    }
}