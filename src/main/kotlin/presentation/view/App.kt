package presentation.view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.composables.EditItemsListWindow
import presentation.composables.TextInputDialog
import presentation.state.CourseState
import presentation.state.ScheduleState
import presentation.utils.getCellIndex

val defaultColumns = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")
val defaultRows = listOf("9:00-11:00", "11:00-13:00", "13:00-15:00", "15:00-17:00", "17:00-19:00", "19:00-21:00")

@Composable
@Preview
fun App() {
    MaterialTheme {
        val rows = remember { mutableStateListOf<String>().apply { addAll(defaultRows) } }
        val columns = remember { mutableStateListOf<String>().apply { addAll(defaultColumns) } }

        val courses = remember { mutableStateListOf<CourseState>() }

        var openAddSubjectDialog by remember { mutableStateOf(false) }
        var openEditRowsDialog by remember { mutableStateOf(false) }
        var openEditColumnsDialog by remember { mutableStateOf(false) }
        var openEditCourseNameDialog by remember { mutableStateOf(false) }
        var openAddScheduleDialog by remember { mutableStateOf(false) }

        var selectedCourseIndex by remember { mutableStateOf(-1) }
        var selectedScheduleIndex by remember { mutableStateOf(-1) }

        Row {
            MainView(Modifier.width(300.dp).fillMaxHeight().background(Color.White),
                courses = courses,
                selectedIndex = selectedCourseIndex,
                rowsSubtitle = rows.joinToString(", "),
                columnsSubtitle = columns.joinToString(", "),
                onEditRowsClicked = { openEditRowsDialog = true },
                onEditColumnsClicked = { openEditColumnsDialog = true},
                onAddSubjectClicked = { openAddSubjectDialog = true },
                onSubjectSelected = { selectedCourseIndex = it }
            )

            Column {
                courses.getOrNull(selectedCourseIndex)?.let { selectedCourse ->
                    DetailView(selectedCourse,
                        selectedScheduleIndex,
                        onEditCourseNameClicked = { openEditCourseNameDialog = true },
                        onAddScheduleClicked = { openAddScheduleDialog = true },
                        onScheduleClicked = { selectedScheduleIndex = it }
                    )

                    selectedCourse.scheduleStates.getOrNull(selectedScheduleIndex)?.let { selectedSchedule ->
                        TimetableView(selectedSchedule, selectedCourse.name, rows, columns, onCellClicked = { row, column ->
                            val cellIndex = getCellIndex(row, column, columns.size)
                            val cellValue = selectedSchedule.cells[cellIndex] ?: false
                            selectedSchedule.cells[cellIndex] = !cellValue
                        }, modifier = Modifier.weight(1f))
                    }
                } ?: run {
                    EmptyDetailView()
                }
            }
        }

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
                courses.add(CourseState(it))
                openAddSubjectDialog = false
            })
        }

        if(openEditCourseNameDialog) {
            TextInputDialog(onCloseRequest = { openEditCourseNameDialog = false }, title = "Edit course name", labelText = "Course name", initialInput = courses[selectedCourseIndex].name, buttonText = "Edit", onInputReceived = {
                courses[selectedCourseIndex] = courses[selectedCourseIndex].copy(name = it)
                openEditCourseNameDialog = false
            })
        }

        if(openAddScheduleDialog) {
            TextInputDialog(onCloseRequest = { openAddScheduleDialog = false }, title = "Add course schedule", labelText = "Classroom name", buttonText = "Add", onInputReceived = {
                courses[selectedCourseIndex].scheduleStates.add(ScheduleState(classroomName = it))
                openAddScheduleDialog = false
            })
        }
    }
}

@Composable
fun EmptyDetailView() {
    Text(
        modifier = Modifier.fillMaxSize().wrapContentHeight(),
        text = "No course selected",
        textAlign = TextAlign.Center,
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium,
    )
}