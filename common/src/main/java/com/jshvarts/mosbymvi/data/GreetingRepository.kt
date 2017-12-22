package com.jshvarts.mosbymvi.data

import io.reactivex.Single
import java.util.concurrent.TimeUnit

/**
 * In a Production app, inject the Repository into your Use Case (Domain layer).
 */
object GreetingRepository {
    fun getHelloGreeting(): Single<String> {
        return Single.just("hi there!").delay(2, TimeUnit.SECONDS)
    }
}