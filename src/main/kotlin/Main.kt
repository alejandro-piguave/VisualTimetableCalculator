import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import presentation.view.App


fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Timetable Calculator") {
        App()
    }
}
