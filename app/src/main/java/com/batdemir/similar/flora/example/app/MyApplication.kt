package com.batdemir.similar.flora.example.app

import android.app.Application
import com.batdemir.similar.flora.example.BuildConfig
import com.batdemir.similar.flora.example.di.component.ApplicationComponent
import com.batdemir.similar.flora.example.di.component.DaggerApplicationComponent
import timber.log.Timber

class MyApplication : Application() {
    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}