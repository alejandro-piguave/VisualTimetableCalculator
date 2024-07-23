package presentation.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.onClick
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import presentation.composables.TableCell
import presentation.selectedCellColor
import presentation.state.ScheduleState
import presentation.utils.getCellIndex

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TimetableView(scheduleState: ScheduleState, courseName: String, rows: List<String>, columns: List<String>, onCellClicked: (row: Int, column: Int) -> Unit, modifier: Modifier = Modifier) {
    LazyColumn(modifier.fillMaxSize().padding(16.dp)) {
        item {
            Row(Modifier.background(Color.Gray).height(intrinsicSize = IntrinsicSize.Max)) {
                TableCell("", weight = 1f)
                columns.forEach { column ->
                    TableCell(text = column, weight = 1f)
                }
            }
        }
        items(rows.size) { row ->
            Row(Modifier.height(intrinsicSize = IntrinsicSize.Max)) {
                TableCell(rows[row], weight = 1f, fontWeight = FontWeight.Bold)
                repeat(columns.size) { column ->
                    val isSelected = scheduleState.cells[getCellIndex(row, column, columns.size)] == true
                    TableCell(
                        text = if(isSelected) courseName else "",
                        weight = 1f,
                        modifier = Modifier.onClick { onCellClicked(row, column) }
                            .then(if (isSelected) Modifier.background(
                                selectedCellColor) else Modifier)
                    )
                }
            }
        }
    }
}