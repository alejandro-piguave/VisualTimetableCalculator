package presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.composables.TableCell
import presentation.composables.Title
import presentation.selectedItemColor
import presentation.state.CourseState
import presentation.state.ScheduleState

@Composable
fun DetailView(
    course: CourseState,
    selectedScheduleIndex: Int,
    onEditCourseNameClicked: () -> Unit,
    onAddScheduleClicked: () -> Unit,
    onScheduleClicked: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        DetailTopBar(course.name, onEditCourseNameClicked, onAddScheduleClicked)
        Spacer(Modifier.height(8.dp))
        Title("Schedules", modifier = Modifier.padding(horizontal = 8.dp))
        ScheduleList(course.scheduleStates.toList(), selectedScheduleIndex, onScheduleClicked)
    }
}

@Composable
fun DetailTopBar(title: String, onEditCourseNameClicked: () -> Unit, onAddScheduleClicked: () -> Unit) {
    TopAppBar(
        title = { Text(title) },
        backgroundColor = MaterialTheme.colors.surface, actions = {
            IconButton(onClick = onEditCourseNameClicked) {
                Icon(Icons.Filled.Edit, contentDescription = "Edit course name")
            }
            IconButton(onClick = onAddScheduleClicked) {
                Icon(Icons.Filled.Add, contentDescription = "Add new schedule")
            }
        })
}

@Composable
fun ScheduleList(schedules: List<ScheduleState>, selectedScheduleIndex: Int, onScheduleClicked: (Int) -> Unit) {
    if (schedules.isEmpty()) {
        Text(
            "No schedules created",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )
    } else {
        LazyRow(
            modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.Center
        ) {
            items(schedules.size) { index ->
                TimetableItem(schedules[index].classroomName, 6, 5, onClick = { onScheduleClicked(index) }, isSelected = index == selectedScheduleIndex)
            }
        }
    }
}

@Composable
fun TimetableItem(name: String, rows: Int, columns: Int, onClick: () -> Unit, isSelected: Boolean = false) {
    Card(
        Modifier.padding(4.dp).clickable(onClick = onClick),
        backgroundColor = if (isSelected) selectedItemColor else MaterialTheme.colors.surface,
        elevation = 4.dp
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(12.dp)) {
            Text(name, textAlign = TextAlign.Center)
            Spacer(Modifier.height(2.dp))
            Column(Modifier.width(150.dp).aspectRatio(1.75f)) {
                Row(Modifier.background(Color.Gray).weight(1f)) {
                    TableCell("", weight = 1f)
                    repeat(columns) {
                        TableCell(text = "", weight = 1f)
                    }
                }

                repeat(rows) {
                    Row(Modifier.weight(1f)) {
                        TableCell("", weight = 1f)
                        repeat(columns) {
                            TableCell(text = "", weight = 1f)
                        }
                    }
                }
            }
        }

    }
}