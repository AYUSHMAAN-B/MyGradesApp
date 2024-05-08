package com.example.grades

sealed class Screens (val title : String, val icon : Int, val route : String)
{
    data object Home : Screens(
        "HOME",
        R.drawable.ic_icon,
        "home")

    data object Overall : Screens(
        "OVERALL",
        R.drawable.ic_icon,
        "overall")

    data object Sem1 : Screens(
        "Semester 1",
        R.drawable.ic_icon,
        "sem1"
    )

    data object Sem2 : Screens(
        "Semester 2",
        R.drawable.ic_icon,
        "sem2"
    )

    data object Sem3 : Screens(
        "Semester 3",
        R.drawable.ic_icon,
        "sem3"
    )

    data object Sem4 : Screens(
        "Semester 4",
        R.drawable.ic_icon,
        "sem4"
    )

    data object Sem5 : Screens(
        "Semester 5",
        R.drawable.ic_icon,
        "sem5"
    )

    data object Sem6 : Screens(
        "Semester 6",
        R.drawable.ic_icon,
        "sem6"
    )

    data object Sem7 : Screens(
        "Semester 7",
        R.drawable.ic_icon,
        "sem7"
    )

    data object Sem8 : Screens(
        "Semester 8",
        R.drawable.ic_icon,
        "sem8"
    )
}