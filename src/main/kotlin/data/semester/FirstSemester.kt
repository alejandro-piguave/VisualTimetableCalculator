package data.semester

import data.Course
import data.CourseTime
import data.Schedule
import data.days.Day
import data.hours.Hour

val firstSemester = listOf(
    Course(
        "AL",
        listOf(
            Schedule(
                "3301",
                listOf(
                    CourseTime(Day.TUESDAY.ordinal, Hour.ELEVEN.ordinal),
                    CourseTime(Day.THURSDAY.ordinal, Hour.NINE.ordinal)
                ),
            ),
            Schedule(
                "CIC2",
                listOf(
                    CourseTime(Day.WEDNESDAY.ordinal, Hour.THIRTEEN.ordinal),
                    CourseTime(Day.FRIDAY.ordinal, Hour.NINE.ordinal)
                )
            ),
            Schedule(
                "3301",
                listOf(
                    CourseTime(Day.TUESDAY.ordinal, Hour.FIFTEEN.ordinal),
                    CourseTime(Day.THURSDAY.ordinal, Hour.NINETEEN.ordinal)
                )
            ),
            Schedule(
                "CIC2",
                listOf(
                    CourseTime(Day.TUESDAY.ordinal, Hour.SEVENTEEN.ordinal),
                    CourseTime(Day.THURSDAY.ordinal, Hour.FIFTEEN.ordinal)
                )
            )
        )
    ),
    Course(
        "ALP",

        listOf(

            Schedule(
                "CIC3",
                listOf(
                    CourseTime(Day.FRIDAY.ordinal, Hour.ELEVEN.ordinal),
                )
            ),
            Schedule(
                "CIC3",
                listOf(
                    CourseTime(Day.TUESDAY.ordinal, Hour.FIFTEEN.ordinal),
                )
            ),
        )
    ),
    Course(
        "IPS",
        listOf(

            Schedule(
                "CIC3",
                listOf(
                    CourseTime(Day.WEDNESDAY.ordinal, Hour.ELEVEN.ordinal),
                    CourseTime(Day.THURSDAY.ordinal, Hour.ELEVEN.ordinal)
                )
            ),
            Schedule(
                "CIC1",
                listOf(
                    CourseTime(Day.WEDNESDAY.ordinal, Hour.NINE.ordinal),
                    CourseTime(Day.THURSDAY.ordinal, Hour.NINE.ordinal)
                )
            ),
            Schedule(
                "CIC3",
                listOf(
                    CourseTime(Day.WEDNESDAY.ordinal, Hour.SEVENTEEN.ordinal),
                    CourseTime(Day.THURSDAY.ordinal, Hour.FIFTEEN.ordinal)
                )
            ),
        )
    ),
    Course(
        "IRM",
        listOf(

            Schedule(
                "CIC3",
                listOf(
                    CourseTime(Day.TUESDAY.ordinal, Hour.ELEVEN.ordinal),
                    CourseTime(Day.WEDNESDAY.ordinal, Hour.NINE.ordinal)
                )
            ),
            Schedule(
                "CIC1",
                listOf(
                    CourseTime(Day.TUESDAY.ordinal, Hour.NINE.ordinal),
                    CourseTime(Day.WEDNESDAY.ordinal, Hour.ELEVEN.ordinal)
                )
            ),
            Schedule(
                "CIC3",
                listOf(
                    CourseTime(Day.TUESDAY.ordinal, Hour.SEVENTEEN.ordinal),
                    CourseTime(Day.WEDNESDAY.ordinal, Hour.NINETEEN.ordinal)
                )
            ),
        )
    ),
    Course(
        "CS",
        listOf(
            Schedule(
                "3104",
                listOf(
                    CourseTime(Day.WEDNESDAY.ordinal, Hour.ELEVEN.ordinal),
                    CourseTime(Day.FRIDAY.ordinal, Hour.ELEVEN.ordinal)
                )
            ),
            Schedule(
                "3203",
                listOf(
                    CourseTime(Day.WEDNESDAY.ordinal, Hour.NINE.ordinal),
                    CourseTime(Day.FRIDAY.ordinal, Hour.NINE.ordinal)
                )
            ),
            Schedule(
                "3104",
                listOf(
                    CourseTime(Day.TUESDAY.ordinal, Hour.NINETEEN.ordinal),
                    CourseTime(Day.WEDNESDAY.ordinal, Hour.SEVENTEEN.ordinal)
                )
            ),
        )
    ),


    Course(
        "GPR",
        listOf(
            Schedule(
                "3104",
                listOf(
                    CourseTime(Day.TUESDAY.ordinal, Hour.ELEVEN.ordinal),
                    CourseTime(Day.THURSDAY.ordinal, Hour.ELEVEN.ordinal)
                )
            ),
            Schedule(
                "3203",
                listOf(
                    CourseTime(Day.TUESDAY.ordinal, Hour.NINE.ordinal),
                    CourseTime(Day.THURSDAY.ordinal, Hour.NINE.ordinal)
                )
            ),
            Schedule(
                "3104",
                listOf(
                    CourseTime(Day.TUESDAY.ordinal, Hour.SEVENTEEN.ordinal),
                    CourseTime(Day.THURSDAY.ordinal, Hour.SEVENTEEN.ordinal)
                )
            ),
        )
    ),
    Course(
        "VV",
        listOf(
            Schedule(
                "3104",
                listOf(
                    CourseTime(Day.WEDNESDAY.ordinal, Hour.NINE.ordinal),
                    CourseTime(Day.FRIDAY.ordinal, Hour.NINE.ordinal)
                )),
            Schedule(
                "3203",
                listOf(
                    CourseTime(Day.WEDNESDAY.ordinal, Hour.ELEVEN.ordinal),
                    CourseTime(Day.THURSDAY.ordinal, Hour.ELEVEN.ordinal)
                )),

            Schedule(
                "3104",
                listOf(
                    CourseTime(Day.MONDAY.ordinal, Hour.SEVENTEEN.ordinal),
                    CourseTime(Day.WEDNESDAY.ordinal, Hour.NINETEEN.ordinal)
                )),
        )
    )
)
