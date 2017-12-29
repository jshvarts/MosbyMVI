package com.jshvarts.mosbymvi

import android.os.Bundle
import android.widget.Toast
import com.hannesdorfmann.mosby3.mvi.MviActivity
import com.jakewharton.rxbinding2.view.clicks
import com.jshvarts.mosbymvi.domain.HelloWorldViewState
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MviActivity<HelloWorldView, HelloWorldPresenter>(), HelloWorldView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun createPresenter() = HelloWorldPresenter()

    override fun sayHelloWorldIntent() = helloWorldButton.clicks()

    override fun render(state: HelloWorldViewState) {
        when(state) {
            is HelloWorldViewState.LoadingState -> renderLoadingState()
            is HelloWorldViewState.DataState -> renderDataState(state)
            is HelloWorldViewState.ErrorState -> renderErrorState(state)
        }
    }

    private fun renderLoadingState() {
        loadingIndicator.visible = true
        helloWorldTextview.visible = false
    }

    private fun renderDataState(dataState: HelloWorldViewState.DataState) {
        loadingIndicator.visible = false
        helloWorldTextview.apply {
            visible = true
            text = dataState.greeting
        }
    }

    private fun renderErrorState(errorState: HelloWorldViewState.ErrorState) {
        loadingIndicator.visible = false
        helloWorldTextview.visible = false
        Toast.makeText(this, "error ${errorState.error}", Toast.LENGTH_LONG).show()
    }
}
