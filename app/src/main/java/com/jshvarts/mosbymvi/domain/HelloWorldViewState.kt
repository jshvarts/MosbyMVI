package com.jshvarts.mosbymvi.domain

sealed class HelloWorldViewState {
    class LoadingState : HelloWorldViewState()
    data class DataState(val greeting: String) : HelloWorldViewState()
    data class ErrorState(val error: Throwable) : HelloWorldViewState()
}