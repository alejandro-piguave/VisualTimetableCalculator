package data

class TimetableSorter {
    fun sort(timetables: List<List<List<TimetableCell?>>> ): List<List<List<TimetableCell?>>> {
        return timetables.sortedBy { getScore(it) }
    }

    private fun getScore(timetable: List<List<TimetableCell?>>): Int {
        return timetable.mapIndexed { index, row ->
            row.count { it != null } * (index + 1)
        }.reduce { acc, unit -> acc + unit }
    }
}