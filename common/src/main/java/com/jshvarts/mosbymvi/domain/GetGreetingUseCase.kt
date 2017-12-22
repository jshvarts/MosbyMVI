package com.jshvarts.mosbymvi.domain

import com.jshvarts.mosbymvi.data.GreetingRepository
import io.reactivex.Single

/**
 * In a Production app, inject the Use Case in your Presentation layer.
 */
object GetGreetingUseCase {
    fun getHelloGreeting(): Single<String> = GreetingRepository.getHelloGreeting()
}