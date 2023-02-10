package ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun NoteDetail(vm: NoteDetailViewModel, onBackClick: () -> Unit) {

    val state = vm.state

    Scaffold(topBar = {
        TopAppBar {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
                IconButton(onClick = { vm.deleteNote() }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = null)
                }
            }
        }
    }) {
        Column {
            TextField(
                value = state.note?.title ?: "",
                onValueChange = {
                    vm.updateNote(state.note?.copy(title = it) ?: return@TextField)
                })
            TextField(
                value = state.note?.content ?: "",
                onValueChange = {
                    vm.updateNote(state.note?.copy(content = it) ?: return@TextField)
                })
            Button(onClick = { vm.saveNote() }) {
                Text(text = "Save")
            }
        }
    }
}