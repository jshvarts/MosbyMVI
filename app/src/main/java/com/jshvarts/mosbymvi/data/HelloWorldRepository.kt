package com.jshvarts.mosbymvi.data

import com.jshvarts.mosbymvi.domain.HelloWorldViewState
import io.reactivex.Observable
import java.util.*

/**
 * In a Production app, inject your Repository into your Use Case instead.
 */
object HelloWorldRepository {

    private val messages = listOf("Hello World", "Hola Mundo", "Hallo Welt", "Bonjour le monde")

    fun loadHelloWorldText(): Observable<HelloWorldViewState> {
        return Observable.just(HelloWorldViewState.DataState(getRandomMessage()))
                .map<HelloWorldViewState> { it }
                .startWith(HelloWorldViewState.LoadingState())
                .onErrorReturn {e: Throwable -> HelloWorldViewState.ErrorState(e) }
    }

    private fun getRandomMessage(): String {
        return messages[Random().nextInt(messages.size)]
    }
}