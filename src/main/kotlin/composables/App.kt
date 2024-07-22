package composables

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.Course

val defaultColumns = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")
val defaultRows = listOf("9:00-11:00", "11:00-13:00", "13:00-15:00", "15:00-17:00", "17:00-19:00", "19:00-21:00")

@Composable
@Preview
fun App() {
    MaterialTheme{
        Column(Modifier.padding(8.dp)) {

            val rows = remember { mutableStateListOf<String>().apply { addAll(defaultRows) } }
            val columns = remember { mutableStateListOf<String>().apply { addAll(defaultColumns) } }

            var openAddSubjectDialog by remember { mutableStateOf(false) }
            var openEditRowsDialog by remember { mutableStateOf(false) }
            var openEditColumnsDialog by remember { mutableStateOf(false) }
            var openAddTimetableDialog by remember { mutableStateOf(false) }
            var openEditSubjectDialog by remember { mutableStateOf(false) }

            var selectedSubjectName by remember { mutableStateOf("") }

            Title("Table format")
            Row {
                ClickableCard(Modifier.weight(1f), "Edit rows", rows.joinToString(", ")) {
                    openEditRowsDialog = true
                }
                ClickableCard(Modifier.weight(1f), "Edit columns", columns.joinToString(", ")) {
                    openEditColumnsDialog = true
                }
            }

            val list = remember { mutableStateListOf<Course>() }

            Title("Subjects")
            LazyRow(Modifier.fillMaxWidth()) {
                items(list.size) { index ->
                    ClickableCard(modifier = Modifier.width(200.dp), title = list[index].name, subtitle = "${list[index].courseSchedule.size} schedules", onClick = {
                        openEditSubjectDialog = true
                        selectedSubjectName = list[index].name
                    })
                }
            }

            AddButton(onClick = { openAddSubjectDialog = true }, modifier = Modifier.align(Alignment.CenterHorizontally), text = "Add Subject")

            if(openEditRowsDialog){
                EditItemsListWindow(onCloseRequest = { openEditRowsDialog = false }, title = "Edit rows", items = rows, onAddNewItem = {
                    rows.add(it)
                }, onDeleteAt = {
                    rows.removeAt(it)
                })
            }
            if(openEditColumnsDialog){
                EditItemsListWindow(onCloseRequest = { openEditColumnsDialog = false }, title = "Edit columns", items = columns, onAddNewItem = {
                    columns.add(it)
                }, onDeleteAt = {
                    columns.removeAt(it)
                })
            }
            if(openAddSubjectDialog) {
                TextInputDialog(onCloseRequest = { openAddSubjectDialog = false }, title = "Add a new subject", labelText = "Subject name", buttonText = "Add", onInputReceived = {
                    list.add(Course(it, emptyList()))
                    openAddSubjectDialog = false
                })
            }

            if(openAddTimetableDialog) {
                EditTimetableWindow(onCloseRequest = { openAddTimetableDialog = false }, "Subject", rows, columns)
            }

            if(openEditSubjectDialog) {
                EditSubjectDialog(onCloseRequest = { openEditSubjectDialog = false }, onNewSubjectName = {}, onNewSchedule = {}, title = selectedSubjectName)
            }
        }

    }
}
