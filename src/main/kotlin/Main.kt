import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.application
import window.MainWindow
import window.ResultWindow


fun main() = application {
    var showResult by remember { mutableStateOf(false) }
    MainWindow(onCloseRequest = ::exitApplication, onShowResult = { showResult = true })
    if(showResult) {
        ResultWindow(onCloseRequest = { showResult = false })
    }
}
