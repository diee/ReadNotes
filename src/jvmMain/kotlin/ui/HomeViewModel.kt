package ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import data.NotesRepository
import data.model.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class HomeViewModel(private val scope: CoroutineScope) {

    var state by mutableStateOf(HomeState())
        private set

    init {
        loadNotes()
    }

    private fun loadNotes() {
        scope.launch {
            state = state.copy(loading = true)
            val notes = NotesRepository.getAll()
            state = state.copy(notes = notes)
        }
    }
}


data class HomeState(
    val notes: List<Note>? = emptyList(),
    val loading: Boolean = false
)