package presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun ClickableCard(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    onClick: () -> Unit,
    isSelected: Boolean = false
) {
    Card(
        modifier.padding(8.dp).fillMaxWidth().then(if(isSelected) Modifier else Modifier.clickable(onClick = onClick)),
        backgroundColor = if (isSelected) Color(0xffCCCCFF) else MaterialTheme.colors.surface,
        elevation = 8.dp
    ) {
        Row(
            Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(Modifier.weight(1f)) {
                Text(title, fontWeight = FontWeight.Bold)
                Text(subtitle, maxLines = 1, overflow = TextOverflow.Ellipsis)
            }

            Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, null, Modifier.alpha(if(isSelected) 0f else 1f))
        }
    }
}