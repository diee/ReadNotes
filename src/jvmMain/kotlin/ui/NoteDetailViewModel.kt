package ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import data.NotesRepository
import data.model.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class NoteDetailViewModel(private val scope: CoroutineScope, private val noteId: Long) {

    var state by mutableStateOf(NoteDetailState())
        private set

    var note = Note(-1L, "", "")

    init {
        loadNote(noteId)
    }

    private fun loadNote(noteId: Long) {
        scope.launch {
            state = state.copy(loading = true)
            if (noteId != -1L) {
                NotesRepository.getById(noteId)?.let { note = it }
            }
            state = state.copy(note = note)
        }
    }

    fun updateNote(note: Note) {
        scope.launch {
            state = state.copy(note = note)
        }
    }

    fun saveNote() {
        scope.launch {
            try {
                NotesRepository.save(state.note ?: return@launch)
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }

    fun deleteNote() {
        scope.launch {
            try {
                NotesRepository.delete(state.note ?: return@launch)
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }
}

data class NoteDetailState(
    val note: Note? = null,
    val loading: Boolean = false
)