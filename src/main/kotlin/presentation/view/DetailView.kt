package presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.Course
import presentation.composables.AddButton
import presentation.composables.TableCell

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DetailView(modifier: Modifier = Modifier, course: Course?, onEditCourseNameClicked: () -> Unit) {
    Column(modifier.padding(horizontal = 8.dp)) {
        course?.let {
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                AddButton(onClick = {}, text = "Add schedule")
                Spacer(Modifier.width(8.dp))
                EditButton(onClick = onEditCourseNameClicked, text = "Edit name")
            }
            FlowRow(modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState()), horizontalArrangement = Arrangement.Center) {
                repeat(5) {
                    TimetableItem(6, 5)
                }
            }
        }
            ?: run {
                Text(
                    modifier = Modifier.fillMaxSize().wrapContentHeight(),
                    text = "No course selected",
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
    }
}

@Composable
fun EditButton(onClick: () -> Unit, text: String, modifier: Modifier = Modifier) {
    Button(onClick = onClick, modifier = modifier) {
        Icon(Icons.Default.Edit, null)
        Spacer(Modifier.width(4.dp))
        Text(text)
    }
}

@Composable
fun TimetableItem(rows: Int, columns: Int) {
    Column(Modifier.width(150.dp).aspectRatio(1.5f).padding(4.dp)) {
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