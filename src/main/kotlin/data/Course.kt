package data

data class Course(val name: String, val courseSchedule: List<CourseSchedule>)

data class CourseSchedule(val classroom: String, val times: List<CourseTime>)
data class CourseTime(val column: Int, val row: Int)

data class CourseClassRoom(val course: String, val classroom: String)