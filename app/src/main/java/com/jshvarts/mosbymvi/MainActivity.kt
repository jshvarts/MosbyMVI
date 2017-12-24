package com.jshvarts.mosbymvi

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.hannesdorfmann.mosby3.mvi.MviActivity
import com.jakewharton.rxbinding2.view.clicks
import com.jshvarts.mosbymvi.domain.HelloWorldViewState

class MainActivity : MviActivity<HelloWorldView, HelloWorldPresenter>(), HelloWorldView {

    private val sayHelloWorldButton: Button by lazy { findViewById<Button>(R.id.hello_world_button) }

    private val helloWorldTextView: TextView by lazy { findViewById<TextView>(R.id.hellow_world_textview) }

    private val loadingIndicator: ProgressBar by lazy { findViewById<ProgressBar>(R.id.loading_indicator) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun createPresenter() = HelloWorldPresenter()

    override fun sayHelloWorldIntent() = sayHelloWorldButton.clicks()

    override fun render(state: HelloWorldViewState) {
        when(state) {
            is HelloWorldViewState.LoadingState -> renderLoadingState()
            is HelloWorldViewState.DataState -> renderDataState(state)
            is HelloWorldViewState.ErrorState -> renderErrorState(state)
        }
    }

    private fun renderLoadingState() {
        loadingIndicator.visibility = View.VISIBLE
        helloWorldTextView.visibility = View.GONE
    }

    private fun renderDataState(dataState: HelloWorldViewState.DataState) {
        loadingIndicator.visibility = View.GONE
        helloWorldTextView.visibility = View.VISIBLE
        helloWorldTextView.text = dataState.greeting
    }

    private fun renderErrorState(errorState: HelloWorldViewState.ErrorState) {
        loadingIndicator.visibility = View.GONE
        helloWorldTextView.visibility = View.GONE
        Toast.makeText(this, "error ${errorState.error}", Toast.LENGTH_LONG).show()
    }
}
