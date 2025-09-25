package com.example.countrypickerapp

import android.app.Application
import com.example.countrypickerapp.di.AppModule
import com.example.countrypickerapp.di.AppModuleImpl

class MyApplication : Application() {
    companion object {
        lateinit var appModule: AppModule
    }

    override fun onCreate() {
        super.onCreate()
        appModule = AppModuleImpl(this@MyApplication)
    }
}