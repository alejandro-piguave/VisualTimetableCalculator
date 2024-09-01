package data

class TimetableValidator(private val config: Config = Config()) {

    fun isValidSolution(hours: Int, days: Int, currentSolution: Array<Array<TimetableCell?>>): Boolean {
        val hasDoubleGaps = (0 until days).any { getColumnGapCount(currentSolution, it) > 1 }
        val daysWithGaps = (0 until days).count { getColumnGapCount(currentSolution, it) == 1 }

        if(!config.allowDoubleGaps && hasDoubleGaps) return false
        if(config.maxDaysWithGaps != null && daysWithGaps > config.maxDaysWithGaps) return false
        if(config.disallowClassOnDay != null && hasClassInDay(currentSolution, hours, config.disallowClassOnDay)) return false

        return true
    }

    private fun hasClassInDay(currentSolution: Array<Array<TimetableCell?>>, hours: Int, day: Int): Boolean {
        return (0 until hours).any { currentSolution[it][day] != null }
    }

    private fun getColumnGapCount(timetable: Array<Array<TimetableCell?>>, column: Int): Int {
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

    data class Config(
        val allowDoubleGaps: Boolean = false,
        val maxDaysWithGaps: Int? = null,
        val disallowClassOnDay: Int? = null
    )

}