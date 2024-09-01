package data

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable

@Stable
data class Course(val name: String, val schedules: List<Schedule>)

@Immutable
data class Schedule(val classroomName: String, val times: List<CourseTime>)
data class CourseTime(val day: Int, val hour: Int)

