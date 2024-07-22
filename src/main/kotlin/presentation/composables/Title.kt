package presentation.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Title(title: String, modifier: Modifier = Modifier, ) {
    Text(title, modifier = modifier.padding(8.dp), fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
}