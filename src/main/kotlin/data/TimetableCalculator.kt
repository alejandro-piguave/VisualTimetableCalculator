package data

class TimetableCalculator {
    companion object {
        private const val ROWS = 6
        private const val COLUMNS = 5
    }

    fun calculate(courses: List<Course>): List<List<List<CourseClassRoom?>>> {
        val currentTimetable = Array<Array<CourseClassRoom?>>(ROWS) { Array(COLUMNS) { null } }
        val solutions = mutableListOf<List<List<CourseClassRoom?>>>()
        recursiveCalculate(courses, solutions, currentTimetable, 0)
        return solutions
    }

    private fun recursiveCalculate(courses: List<Course>, solutions: MutableList<List<List<CourseClassRoom?>>>, currentSolution: Array<Array<CourseClassRoom?>>, depth: Int) {
        for(i in 0 until courses[depth].schedules.size) {
            val currentSchedule = courses[depth].schedules[i]
            if(canAdd(currentSolution, currentSchedule.times)) {
                val courseClassRoom = CourseClassRoom(courses[depth].name, currentSchedule.classroomName)
                currentSchedule.times.forEach { currentSolution[it.row][it.column] = courseClassRoom }
                if(depth == courses.size -1) {
                    val hasDoubleGaps = (0 until COLUMNS).any { getColumnGapCount(currentSolution, it) > 1 }
                    val singleGapCount = (0 until COLUMNS).count { getColumnGapCount(currentSolution, it) == 1 }
                    val hasClassOnMonday = (0 until ROWS).any { currentSolution[it][0] != null }
                    if(!hasDoubleGaps) {
                        val solutionCopy = currentSolution.map { solutionRow -> solutionRow.map { it } }
                        solutions.add(solutionCopy)
                    }
                } else {
                    recursiveCalculate(courses, solutions, currentSolution, depth + 1)
                }
                currentSchedule.times.forEach { currentSolution[it.row][it.column] = null }

            }
        }

    }

    private fun canAdd(timetable: Array<Array<CourseClassRoom?>>, times: List<CourseTime>): Boolean {
        return times.all { timetable[it.row][it.column] == null }
    }

    private fun getColumnGapCount(timetable: Array<Array<CourseClassRoom?>>, column: Int): Int {
        var gapCount = 0
        var startCounting = false
        var checkingGap = false
        for(i in timetable.indices) {
            if(!startCounting && (timetable[i][column] != null)) startCounting = true
            else if(startCounting && timetable[i][column] == null) checkingGap = true
            else if(checkingGap && (timetable[i][column] != null)) {
                gapCount++
                checkingGap = false
            }
        }

        return gapCount
    }
}