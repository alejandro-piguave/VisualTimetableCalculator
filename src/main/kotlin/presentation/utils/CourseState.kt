package presentation.utils

import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import data.Course
import presentation.state.CourseState
import presentation.state.ScheduleState

fun List<Course>.toState(days: Int): List<CourseState> {
    return map { course ->
        CourseState(
            course.name,
            SnapshotStateList<ScheduleState>().apply {
                addAll(
                    course.schedules.map { schedule ->
                        ScheduleState(
                            schedule.classroomName,
                            mutableStateMapOf<Int, Boolean>().apply {
                                schedule.times.forEach { times ->
                                    put(getCellIndex(times.hour, times.day, days), true)
                                }
                            }
                        )
                    }
                )
            }
        )
    }
}