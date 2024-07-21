package composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogState
import androidx.compose.ui.window.DialogWindow

@Composable
fun EditTimetableWindow(onCloseRequest: () -> Unit, title: String, rows: List<String>, columns: List<String>) {
    DialogWindow(
        title = title,
        state = DialogState(size = DpSize(Dp.Unspecified, Dp.Unspecified)),
        onCloseRequest = onCloseRequest) {
        Table(rows, columns)
    }
}

@Composable
fun RowScope.TableCell(
    text: String,
    weight: Float
) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxSize()
            .border(1.dp, Color.Black)
            .weight(weight)
            .padding(8.dp)
    )
}

@Composable
fun Table(rows: List<String>, columns: List<String>) {
    LazyColumn(Modifier.width(800.dp).padding(16.dp)) {
        item {
            Row(Modifier.background(Color.Gray).height(intrinsicSize = IntrinsicSize.Max)) {
                TableCell("", weight = 1f)
                columns.forEach{ column ->
                    TableCell(text = column, weight = 1f)
                }
            }
        }
        items(rows.size) { index ->
            Row(Modifier.height(intrinsicSize = IntrinsicSize.Max)) {
                TableCell(rows[index], weight = 1f)
                repeat(columns.size) {
                    TableCell(text = "", weight = 1f)
                }
            }
        }
    }
}