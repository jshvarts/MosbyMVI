package com.jshvarts.mosbymvi

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import com.jshvarts.mosbymvi.domain.GetHelloWorldTextUseCase
import com.jshvarts.mosbymvi.domain.HelloWorldViewState
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class HelloWorldPresenter : MviBasePresenter<HelloWorldView, HelloWorldViewState>() {
    override fun bindIntents() {
        val showHelloWorld: Observable<HelloWorldViewState> = intent(HelloWorldView::sayHelloWorldIntent)
                .subscribeOn(Schedulers.io())
                .switchMap { GetHelloWorldTextUseCase.getHelloWorldText() }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext { Timber.d("Received sayHelloIntent") }
                .doAfterNext { Timber.d("Received new state: " + it) }

        subscribeViewState(showHelloWorld, HelloWorldView::render)
    }
}