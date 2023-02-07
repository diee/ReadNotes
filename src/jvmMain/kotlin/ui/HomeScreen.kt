package ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.model.Note
import data.notesClient

@Composable
fun HomeScreen(vm: HomeViewModel) {

    val state = vm.state

    Scaffold {
        NotesList(state.notes ?: emptyList())
    }
}

@Composable
fun NotesList(notes: List<Note>) {
    LazyColumn {
        items(notes) { note ->
            Box(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                Column {
                    Text(text = note.title, style = MaterialTheme.typography.h6)
                    Text(text = note.content, style = MaterialTheme.typography.body2)
                }
            }
        }
    }
}