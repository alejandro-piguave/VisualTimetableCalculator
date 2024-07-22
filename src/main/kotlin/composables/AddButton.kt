package composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddButton(onClick: () -> Unit, text: String, modifier: Modifier = Modifier) {
    Button(onClick = onClick, modifier = modifier) {
        Icon(Icons.Default.Add, null)
        Spacer(Modifier.width(4.dp))
        Text(text)
    }
}