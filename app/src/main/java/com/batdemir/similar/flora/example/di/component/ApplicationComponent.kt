package com.batdemir.similar.flora.example.di.component

import android.content.Context
import com.batdemir.similar.flora.example.di.module.NetworkModule
import com.batdemir.similar.flora.example.di.module.ProductServiceModule
import com.batdemir.similar.flora.example.di.module.StorageModule
import com.batdemir.similar.flora.example.di.module.SubComponentsModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ProductServiceModule::class, StorageModule::class, SubComponentsModule::class])
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun mainComponent(): MainComponent.Factory
}