package presentation.state

import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

@Stable
data class CourseState(val name: String, val scheduleStates: SnapshotStateList<ScheduleState> = mutableStateListOf())

