package window

import data.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import presentation.state.CourseState

class MainViewModel(private val coroutineScope: CoroutineScope) {
    private val calculator = TimetableCalculator(TimetableValidator())

    private val _timetables: MutableStateFlow<List<Timetable>> = MutableStateFlow(emptyList())
    val timetables = _timetables.asStateFlow()


    fun calculate(hours: Int, days: Int, courseStates: List<CourseState>) {
        println("calculate $hours $days $courseStates")
        coroutineScope.launch(Dispatchers.IO) {
            val courses = courseStates.toCourseList(days)
            val result = calculator.calculate(hours, days, courses)
            println("result $result")
            _timetables.update { result }
        }
    }

    private fun List<CourseState>.toCourseList(days: Int): List<Course> {
        return map { courseState ->
            Course(
                courseState.name,
                courseState.scheduleStates.toList().map { scheduleState ->
                    Schedule(scheduleState.classroomName, scheduleState.cells.toCourseTimeList(days))
                }
            )
        }
    }

    private fun Map<Int, Boolean>.toCourseTimeList(days: Int): List<CourseTime> {
        val list = mutableListOf<CourseTime>()
        forEach { entry ->
            list.add(CourseTime(entry.key % days, entry.key / days))
        }
        return list
    }

}