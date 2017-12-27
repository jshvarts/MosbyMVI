package com.jshvarts.mosbymvi

import com.hannesdorfmann.mosby3.mvp.MvpView
import com.jshvarts.mosbymvi.domain.HelloWorldViewState
import io.reactivex.Observable

interface HelloWorldView : MvpView {
    /**
     * Emits button clicks
     */
    fun sayHelloWorldIntent(): Observable<Unit>

    /**
     * Renders the state in the UI
     */
    fun render(state: HelloWorldViewState)
}

