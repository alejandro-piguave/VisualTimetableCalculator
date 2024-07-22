package presentation.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogWindow


@Composable
fun EditItemsListWindow(onCloseRequest: () -> Unit, title: String, items: List<String>, onAddNewItem: (String) -> Unit, onDeleteAt: (Int) -> Unit) {
    DialogWindow(
        onCloseRequest = onCloseRequest, title = title) {
        ItemsList(items = items, onAdd = onAddNewItem, onDeleteAt = onDeleteAt)

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemsList(modifier: Modifier = Modifier, items: List<String>, onAdd: (String) -> Unit, onDeleteAt: (Int) -> Unit) {
    LazyColumn(modifier = modifier.padding(8.dp).fillMaxSize()) {
        stickyHeader {
            Column(Modifier.background(Color.White)) {
                var rowName by remember { mutableStateOf("") }
                TextField(
                    modifier = Modifier.fillParentMaxWidth(),
                    value = rowName,
                    label = { Text("New row name") },
                    onValueChange = { rowName = it },
                )
                AddButton(text = "Add item", modifier = Modifier.fillParentMaxWidth(), onClick = {
                    if(rowName.isNotBlank()){
                        onAdd(rowName)
                        rowName = ""
                    }
                })
            }
        }

        items(items.size) { index ->
            Row {
                Text(modifier = Modifier.padding(8.dp), text = items[index])
                Spacer(Modifier.weight(1f))
                IconButton(onClick = { onDeleteAt(index) }){
                    Icon(Icons.Default.Delete, null)
                }
            }
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}
