package data

typealias Timetable = List<List<TimetableCell?>>

data class TimetableCell(val course: String, val classroom: String)