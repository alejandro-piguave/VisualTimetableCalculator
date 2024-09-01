package presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import data.TimetableCell

@Composable
fun TimetableEditView(rows: List<String>, columns: List<String>, schedule: List<List<TimetableCell?>>, modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize().padding(16.dp)) {
        Row(Modifier.background(Color.Gray).height(intrinsicSize = IntrinsicSize.Max)) {
            TableCell("", weight = 1f)
            columns.forEach { column ->
                TableCell(text = column, weight = 1f)
            }
        }
        repeat(rows.size) { row ->
            Row(Modifier.height(intrinsicSize = IntrinsicSize.Max)) {
                TableCell(rows[row], weight = 1f, fontWeight = FontWeight.Bold)
                repeat(columns.size) { column ->
                    val cell = schedule[row][column]
                    val cellText = cell?.let { "${cell.course}\n${cell.classroom}" } ?: ""
                    TableCell(
                        text = cellText,
                        weight = 1f
                    )
                }
            }
        }
    }
}