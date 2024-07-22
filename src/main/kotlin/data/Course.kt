package data

import androidx.compose.runtime.Immutable

@Immutable
data class Course(val name: String, val courseSchedules: List<CourseSchedule>)

@Immutable
data class CourseSchedule(val classroomName: String, val times: List<CourseTime>)
@Immutable
data class CourseTime(val column: Int, val row: Int)

data class CourseClassRoom(val course: String, val classroom: String)