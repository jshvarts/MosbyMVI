package com.jshvarts.mosbymvi.data

import com.jshvarts.mosbymvi.domain.NoteEntity
import io.reactivex.Single
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * In a Production app, inject the Repository into your Use Case (Domain layer).
 */
object NotesRepository {
    fun getNotes(): Single<List<NoteEntity>> = Single.just(generateNotes()).delay(2, TimeUnit.SECONDS)

    /**
     * Generates a list of note items randomly between 2 and 50
     */
    private fun generateNotes() = (1..(2..50).random()).map { NoteEntity(it, "note $it") }

    private fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) +  start
}