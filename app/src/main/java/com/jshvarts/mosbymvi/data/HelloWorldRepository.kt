package com.jshvarts.mosbymvi.data

import io.reactivex.Observable
import java.util.Random

/**
 * In a Production app, inject your Repository into your Use Case instead.
 */
object HelloWorldRepository {

    fun loadHelloWorldText(): Observable<String> = Observable.just(getRandomMessage())

    private fun getRandomMessage(): String {
        val messages = listOf("Hello World", "Hola Mundo", "Hallo Welt", "Bonjour le monde")
        return messages[Random().nextInt(messages.size)]
    }
}

