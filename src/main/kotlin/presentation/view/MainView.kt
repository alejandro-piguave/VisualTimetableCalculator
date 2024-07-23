package presentation.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import presentation.composables.ArrowCard
import presentation.composables.Title
import presentation.selectedItemColor
import presentation.state.CourseState

@Composable
fun SideBarView(
    modifier: Modifier = Modifier,
    courses: List<CourseState>,
    selectedIndex: Int,
    rowsSubtitle: String,
    columnsSubtitle: String,
    onEditRowsClicked: () -> Unit,
    onEditColumnsClicked: () -> Unit,
    onAddSubjectClicked: () -> Unit,
    onSubjectSelected: (Int) -> Unit,
    onCalculateTimetablesClicked: () -> Unit
) {
    Column(modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Title("Table format", modifier = Modifier.fillMaxWidth())
        ArrowCard(title = "Edit rows", subtitle = rowsSubtitle, onClick = onEditRowsClicked)
        ArrowCard(title = "Edit columns", subtitle = columnsSubtitle, onClick = onEditColumnsClicked)


        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Title("Subjects")
            IconButton(onClick = onAddSubjectClicked) {
                Icon(Icons.Default.Add, contentDescription = "Add subject")
            }
        }

        LazyColumn(Modifier.fillMaxWidth().weight(1f)) {
            items(courses.size) { index ->
                CourseItem(
                    title = courses[index].name,
                    subtitle = "${courses[index].scheduleStates.size} schedules",
                    onClick = { onSubjectSelected(index) },
                    isSelected = index == selectedIndex
                )
            }
        }

        Button(onClick = onCalculateTimetablesClicked, enabled = courses.isNotEmpty()) {
            Text("Calculate timetables", modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun CourseItem(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    onClick: () -> Unit,
    isSelected: Boolean = false
) {
    Card(
        modifier.padding(8.dp).fillMaxWidth().then(if(isSelected) Modifier else Modifier.clickable(onClick = onClick)),
        backgroundColor = if (isSelected) selectedItemColor else MaterialTheme.colors.surface,
        elevation = 8.dp
    ) {
        Row(
            Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(Modifier.weight(1f)) {
                Text(title, fontWeight = FontWeight.Bold)
                Text(subtitle, maxLines = 1, overflow = TextOverflow.Ellipsis)
            }
        }
    }
}