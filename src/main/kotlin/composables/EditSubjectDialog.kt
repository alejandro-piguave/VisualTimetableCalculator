package composables

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogWindow

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EditSubjectDialog(onCloseRequest: () -> Unit, title: String, onNewSchedule: (String) -> Unit, onNewSubjectName: (String) -> Unit) {
    DialogWindow(
        onCloseRequest = onCloseRequest, title = title) {
        Column(Modifier.padding(16.dp)) {
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                AddButton(onClick = {}, text = "Add schedule")
                Spacer(Modifier.width(8.dp))
                EditButton(onClick = {}, text = "Edit name")
            }
            FlowRow(modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState()), horizontalArrangement = Arrangement.Center) {
                repeat(5) {
                    TimetableItem(6, 5)
                }
            }
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