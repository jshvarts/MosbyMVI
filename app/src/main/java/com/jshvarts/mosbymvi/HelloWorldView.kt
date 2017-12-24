package com.jshvarts.mosbymvi

import com.hannesdorfmann.mosby3.mvp.MvpView
import com.jshvarts.mosbymvi.domain.HelloWorldViewState
import io.reactivex.Observable

interface HelloWorldView : MvpView {
    fun sayHelloWorldIntent(): Observable<Unit>

    /**
     * Render the state in the UI
     */
    fun render(state: HelloWorldViewState)
}