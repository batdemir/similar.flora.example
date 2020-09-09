package com.batdemir.similar.flora.example.app

import android.app.Application
import com.batdemir.similar.flora.example.di.component.ApplicationComponent
import com.batdemir.similar.flora.example.di.component.DaggerApplicationComponent

class MyApplication : Application() {
    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext)
    }
}