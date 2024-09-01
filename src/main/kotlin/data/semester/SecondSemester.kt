package data.semester

import data.Course
import data.CourseTime
import data.Schedule
import data.days.Day
import data.hours.Hour

val secondSemester = listOf(
    Course(
        "FEE",
        listOf(
            Schedule(
                "3301",
                listOf(
                    CourseTime(Day.WEDNESDAY.ordinal, Hour.NINE.ordinal),
                    CourseTime(Day.FRIDAY.ordinal, Hour.ELEVEN.ordinal)
                ),
            ),
            Schedule(
                "CIC2",
                listOf(
                    CourseTime(Day.TUESDAY.ordinal, Hour.NINE.ordinal),
                    CourseTime(Day.THURSDAY.ordinal, Hour.ELEVEN.ordinal)
                )
            ),
            Schedule(
                "3301",
                listOf(
                    CourseTime(Day.TUESDAY.ordinal, Hour.NINETEEN.ordinal),
                    CourseTime(Day.WEDNESDAY.ordinal, Hour.NINETEEN.ordinal)
                )
            ),
            Schedule(
                "CIC2",
                listOf(
                    CourseTime(Day.TUESDAY.ordinal, Hour.NINETEEN.ordinal),
                    CourseTime(Day.WEDNESDAY.ordinal, Hour.NINETEEN.ordinal)
                )
            )
        )
    ),
    Course(
        "PCA",
        listOf(
            Schedule(
                "3301",
                listOf(
                    CourseTime(Day.WEDNESDAY.ordinal, Hour.THIRTEEN.ordinal),
                    CourseTime(Day.FRIDAY.ordinal, Hour.NINE.ordinal)
                ),
            ),
            Schedule(
                "CIC2",
                listOf(
                    CourseTime(Day.WEDNESDAY.ordinal, Hour.ELEVEN.ordinal),
                    CourseTime(Day.FRIDAY.ordinal, Hour.THIRTEEN.ordinal)
                )
            ),
            Schedule(
                "3301",
                listOf(
                    CourseTime(Day.MONDAY.ordinal, Hour.SEVENTEEN.ordinal),
                    CourseTime(Day.THURSDAY.ordinal, Hour.NINETEEN.ordinal)
                )
            ),
            Schedule(
                "CIC2",
                listOf(
                    CourseTime(Day.MONDAY.ordinal, Hour.SEVENTEEN.ordinal),
                    CourseTime(Day.THURSDAY.ordinal, Hour.SEVENTEEN.ordinal)
                )
            )
        )
    ),
    Course(
        "SI",
        listOf(
            Schedule(
                "3301",
                listOf(
                    CourseTime(Day.TUESDAY.ordinal, Hour.ELEVEN.ordinal),
                ),
            ),
            Schedule(
                "CIC2",
                listOf(
                    CourseTime(Day.FRIDAY.ordinal, Hour.NINE.ordinal),
                )
            ),
            Schedule(
                "3301",
                listOf(
                    CourseTime(Day.MONDAY.ordinal, Hour.NINETEEN.ordinal),
                )
            ),
        )
    ),
    Course(
        "ADS",
        listOf(

            Schedule(
                "CIC3",
                listOf(
                    CourseTime(Day.WEDNESDAY.ordinal, Hour.ELEVEN.ordinal),
                    CourseTime(Day.FRIDAY.ordinal, Hour.NINE.ordinal)
                )
            ),
            Schedule(
                "CIC1",
                listOf(
                    CourseTime(Day.TUESDAY.ordinal, Hour.THIRTEEN.ordinal),
                    CourseTime(Day.FRIDAY.ordinal, Hour.ELEVEN.ordinal)
                )
            ),
            Schedule(
                "CIC3",
                listOf(
                    CourseTime(Day.TUESDAY.ordinal, Hour.NINETEEN.ordinal),
                    CourseTime(Day.THURSDAY.ordinal, Hour.NINETEEN.ordinal)
                )
            ),
        )
    ),
    Course(
        "BDA",
        listOf(

            Schedule(
                "CIC3",
                listOf(
                    CourseTime(Day.TUESDAY.ordinal, Hour.ELEVEN.ordinal),
                    CourseTime(Day.THURSDAY.ordinal, Hour.ELEVEN.ordinal)
                )
            ),
            Schedule(
                "CIC1",
                listOf(
                    CourseTime(Day.WEDNESDAY.ordinal, Hour.ELEVEN.ordinal),
                    CourseTime(Day.THURSDAY.ordinal, Hour.THIRTEEN.ordinal)
                )
            ),
            Schedule(
                "CIC3",
                listOf(
                    CourseTime(Day.TUESDAY.ordinal, Hour.FIFTEEN.ordinal),
                    CourseTime(Day.THURSDAY.ordinal, Hour.FIFTEEN.ordinal)
                )
            ),
        )
    ),
    Course(
        "EMS",
        listOf(

            Schedule(
                "CIC3",
                listOf(
                    CourseTime(Day.TUESDAY.ordinal, Hour.NINE.ordinal),
                    CourseTime(Day.THURSDAY.ordinal, Hour.NINE.ordinal)
                )
            ),
            Schedule(
                "CIC1",
                listOf(
                    CourseTime(Day.TUESDAY.ordinal, Hour.ELEVEN.ordinal),
                    CourseTime(Day.THURSDAY.ordinal, Hour.ELEVEN.ordinal)
                )
            ),
            Schedule(
                "CIC3",
                listOf(
                    CourseTime(Day.TUESDAY.ordinal, Hour.SEVENTEEN.ordinal),
                    CourseTime(Day.THURSDAY.ordinal, Hour.SEVENTEEN.ordinal)
                )
            ),
        )
    ),

    Course(
        "CDIG",
        listOf(

            Schedule(
                "CIC3",
                listOf(
                    CourseTime(Day.WEDNESDAY.ordinal, Hour.THIRTEEN.ordinal),
                    CourseTime(Day.FRIDAY.ordinal, Hour.THIRTEEN.ordinal)
                )
            ),
            Schedule(
                "CIC3",
                listOf(
                    CourseTime(Day.MONDAY.ordinal, Hour.NINETEEN.ordinal),
                    CourseTime(Day.WEDNESDAY.ordinal, Hour.SEVENTEEN.ordinal)
                )
            ),
        )
    ),
)
