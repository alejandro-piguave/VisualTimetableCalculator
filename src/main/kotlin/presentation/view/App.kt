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
import data.Course
import data.CourseSchedule
import presentation.composables.EditItemsListWindow
import presentation.composables.TextInputDialog

val defaultColumns = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")
val defaultRows = listOf("9:00-11:00", "11:00-13:00", "13:00-15:00", "15:00-17:00", "17:00-19:00", "19:00-21:00")

@Composable
@Preview
fun App() {
    MaterialTheme {
        val rows = remember { mutableStateListOf<String>().apply { addAll(defaultRows) } }
        val columns = remember { mutableStateListOf<String>().apply { addAll(defaultColumns) } }

        val list = remember { mutableStateListOf<Course>() }

        var openAddSubjectDialog by remember { mutableStateOf(false) }
        var openEditRowsDialog by remember { mutableStateOf(false) }
        var openEditColumnsDialog by remember { mutableStateOf(false) }
        var openEditCourseNameDialog by remember { mutableStateOf(false) }
        var openAddScheduleDialog by remember { mutableStateOf(false) }

        var selectedCourseIndex by remember { mutableStateOf(-1) }
        var selectedScheduleIndex by remember { mutableStateOf(-1) }

        Row {
            MainView(Modifier.width(300.dp).fillMaxHeight().background(Color.White),
                courses = list,
                selectedIndex = selectedCourseIndex,
                rowsSubtitle = rows.joinToString(", "),
                columnsSubtitle = columns.joinToString(", "),
                onEditRowsClicked = { openEditRowsDialog = true },
                onEditColumnsClicked = { openEditColumnsDialog = true},
                onAddSubjectClicked = { openAddSubjectDialog = true },
                onSubjectSelected = { selectedCourseIndex = it }
            )

            Column {
                list.getOrNull(selectedCourseIndex)?.let { selectedCourse ->
                    DetailView(selectedCourse,
                        selectedScheduleIndex,
                        onEditCourseNameClicked = { openEditCourseNameDialog = true },
                        onAddScheduleClicked = { openAddScheduleDialog = true },
                        onScheduleClicked = { selectedScheduleIndex = it }
                    )

                    selectedCourse.courseSchedules.getOrNull(selectedScheduleIndex)?.let { selectedSchedule ->
                        TimetableView(selectedSchedule.classroomName, rows, columns, modifier = Modifier.weight(1f))
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
                list.add(Course(it, emptyList()))
                openAddSubjectDialog = false
            })
        }

        if(openEditCourseNameDialog) {
            TextInputDialog(onCloseRequest = { openEditCourseNameDialog = false }, title = "Edit course name", labelText = "Course name", initialInput = list[selectedCourseIndex].name, buttonText = "Edit", onInputReceived = {
                list[selectedCourseIndex] = list[selectedCourseIndex].copy(name = it)
                openEditCourseNameDialog = false
            })
        }

        if(openAddScheduleDialog) {
            TextInputDialog(onCloseRequest = { openAddScheduleDialog = false }, title = "Add course schedule", labelText = "Classroom name", buttonText = "Add", onInputReceived = {
                val currentCourse = list[selectedCourseIndex]
                list[selectedCourseIndex] = currentCourse.copy(courseSchedules = currentCourse.courseSchedules + CourseSchedule(classroomName = it, emptyList()))
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