package presentation.state

import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.snapshots.SnapshotStateMap

@Stable
data class ScheduleState(val classroomName: String, val cells: SnapshotStateMap<Int, Boolean> = mutableStateMapOf())