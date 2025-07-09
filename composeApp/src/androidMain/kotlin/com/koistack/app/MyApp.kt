package com.koistack.app

import android.app.Application

class MyApp: Application() {

    companion object {
        //use this to get the context of this application
        lateinit var instance: MyApp
            private set

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}