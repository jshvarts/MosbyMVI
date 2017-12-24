package com.jshvarts.mosbymvi.domain

import com.jshvarts.mosbymvi.data.HelloWorldRepository
import io.reactivex.Observable

/**
 * In a Production app, inject your Use Case into your Presenter instead.
 */
object GetHelloWorldTextUseCase {
    fun getHelloWorldText(): Observable<HelloWorldViewState> = HelloWorldRepository.loadHelloWorldText()
}