package presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import presentation.composables.TableCell

@Composable
fun TimetableView(rows: List<String>, columns: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier.fillMaxSize().padding(16.dp)) {
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