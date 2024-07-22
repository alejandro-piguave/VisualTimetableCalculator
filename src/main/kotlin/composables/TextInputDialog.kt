package composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogWindow

@Composable
fun TextInputDialog(onCloseRequest: () -> Unit, title: String, labelText: String, buttonText: String, onInputReceived: (String) -> Unit, initialInput: String = "") {
    DialogWindow(
        onCloseRequest = onCloseRequest, title = title) {
        Column(modifier = Modifier.fillMaxSize().padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            var subjectName by remember { mutableStateOf(initialInput) }
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = subjectName,
                label = { Text(labelText) },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                onValueChange = { subjectName = it}
            )

            Button(onClick = { onInputReceived(subjectName) }, modifier = Modifier.fillMaxWidth()) {
                Icon(Icons.Default.Add, null)
                Spacer(Modifier.width(4.dp))
                Text(buttonText)
            }
        }
    }
}