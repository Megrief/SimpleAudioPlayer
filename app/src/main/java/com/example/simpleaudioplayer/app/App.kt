package com.example.simpleaudioplayer.app

import android.app.Application
import com.example.simpleaudioplayer.app.di.dataModule
import com.example.simpleaudioplayer.app.di.domainModule
import com.example.simpleaudioplayer.app.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(dataModule, domainModule, presentationModule)
        }
    }
}