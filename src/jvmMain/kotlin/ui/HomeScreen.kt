package ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.model.Note

@Composable
fun HomeScreen(vm: HomeViewModel, onCreateClick: (Long) -> Unit = {}) {

    val state = vm.state

    Scaffold(topBar = {
        TopAppBar { Text(text = "Notes") }
    }, floatingActionButton = {
        FloatingActionButton(onClick = { onCreateClick(-1L) }) {
            Text(text = "+")
        }
    }) {
        NotesList(
            notes = state.notes ?: emptyList(),
            onItemClick = { note ->
                onCreateClick(note.id)
            })
    }
}

@Composable
fun NotesList(notes: List<Note>, onItemClick: (Note) -> Unit) {
    LazyColumn {
        items(notes) { note ->
            Box(modifier = Modifier.fillMaxWidth().padding(16.dp).clickable { onItemClick(note) }) {
                Column {
                    Text(text = note.title, style = MaterialTheme.typography.h6)
                    Text(text = note.content, style = MaterialTheme.typography.body2)
                }
            }
        }
    }
}