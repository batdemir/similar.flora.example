package com.batdemir.similar.flora.example.app

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.batdemir.similar.flora.example.di.component.ApplicationComponent
import com.batdemir.similar.flora.example.di.component.DaggerApplicationComponent

class MyApplication : Application() {
    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
    }
}