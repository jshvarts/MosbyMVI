package com.jshvarts.mosbymvi

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import com.jshvarts.mosbymvi.domain.GetHelloWorldTextUseCase
import com.jshvarts.mosbymvi.domain.HelloWorldViewState
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.TimeUnit

class HelloWorldPresenter : MviBasePresenter<HelloWorldView, HelloWorldViewState>() {
    override fun bindIntents() {
        val helloWorldState: Observable<HelloWorldViewState> = intent(HelloWorldView::sayHelloWorldIntent)
                .subscribeOn(Schedulers.io())
                .debounce(400, TimeUnit.MILLISECONDS)
                .switchMap { GetHelloWorldTextUseCase.getHelloWorldText() }
                .doOnNext { Timber.d("Received new state: " + it) }
                .observeOn(AndroidSchedulers.mainThread())

        subscribeViewState(helloWorldState, HelloWorldView::render)
    }
}

