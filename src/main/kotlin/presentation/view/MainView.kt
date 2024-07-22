package presentation.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.Course
import presentation.composables.*

@Composable
fun MainView(
    modifier: Modifier = Modifier,
    courses: List<Course>,
    selectedIndex: Int,
    rowsSubtitle: String,
    columnsSubtitle: String,
    onEditRowsClicked: () -> Unit,
    onEditColumnsClicked: () -> Unit,
    onAddSubjectClicked: () -> Unit,
    onSubjectSelected: (Int) -> Unit,
) {
    Column(modifier.padding(8.dp)) {
        Title("Table format")
        ClickableCard(title = "Edit rows", subtitle = rowsSubtitle, onClick = onEditRowsClicked)
        ClickableCard(title = "Edit columns", subtitle = columnsSubtitle, onClick = onEditColumnsClicked)


        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Title("Subjects")
            IconButton(onClick = onAddSubjectClicked) {
                Icon(Icons.Default.Add, contentDescription = "Add subject")
            }
        }

        LazyColumn(Modifier.fillMaxWidth()) {
            items(courses.size) { index ->
                ClickableCard(
                    title = courses[index].name,
                    subtitle = "${courses[index].courseSchedule.size} schedules",
                    onClick = { onSubjectSelected(index) },
                    isSelected = index == selectedIndex
                )
            }
        }
    }

}