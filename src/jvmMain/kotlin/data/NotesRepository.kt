package data

import data.model.Note
import io.ktor.client.call.*
import io.ktor.client.request.*

const val NOTES_URL = "http://localhost:8080/notes"

object NotesRepository {

    suspend fun getNotes(): List<Note> {

        val response = notesClient.request(NOTES_URL) {
            method = io.ktor.http.HttpMethod.Get
        }

        return response.body()
    }
}