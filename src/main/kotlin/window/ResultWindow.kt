package window

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window

@Composable
fun ResultWindow(onCloseRequest: () -> Unit) {
    Window(onCloseRequest = onCloseRequest, title = "Result") {
        Text("Result")
    }
}