package com.matheusmt.wikirick.application

import android.app.Application
import com.matheusmt.wikirick.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(level = Level.INFO)
            androidContext(this@MyApplication)
            modules(appModules)
        }
    }
}