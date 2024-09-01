package data

class TimetableCalculator(private val validator: TimetableValidator) {
    fun calculate(hours: Int, days: Int, courses: List<Course>): List<Timetable> {
        val currentTimetable = Array<Array<TimetableCell?>>(hours) { Array(days) { null } }
        val solutions = mutableListOf<List<List<TimetableCell?>>>()
        recursiveCalculate(hours, days, courses, solutions, currentTimetable, 0)
        return solutions
    }

    private fun recursiveCalculate(hours: Int, days: Int, courses: List<Course>, solutions: MutableList<Timetable>, currentSolution: Array<Array<TimetableCell?>>, depth: Int) {
        for(i in 0 until courses[depth].schedules.size) {
            val currentSchedule = courses[depth].schedules[i]
            if(canAdd(currentSolution, currentSchedule.times)) {
                val timetableCell = TimetableCell(courses[depth].name, currentSchedule.classroomName)
                currentSchedule.times.forEach { currentSolution[it.hour][it.day] = timetableCell }
                if(depth == courses.size -1) {
                    if(validator.isValidSolution(hours, days, currentSolution)) {
                        val solutionCopy = currentSolution.map { solutionRow -> solutionRow.map { it } }
                        solutions.add(solutionCopy)
                    }
                } else {
                    recursiveCalculate(hours, days, courses, solutions, currentSolution, depth + 1)
                }
                currentSchedule.times.forEach { currentSolution[it.hour][it.day] = null }
            }
        }

    }


    private fun canAdd(timetable: Array<Array<TimetableCell?>>, times: List<CourseTime>): Boolean {
        return times.all { timetable[it.hour][it.day] == null }
    }

}