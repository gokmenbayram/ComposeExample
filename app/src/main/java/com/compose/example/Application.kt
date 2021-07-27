package com.compose.example

import android.app.Application
import android.content.Context

open class Application: Application() {

    companion object {

        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()

        appContext = applicationContext
    }
}