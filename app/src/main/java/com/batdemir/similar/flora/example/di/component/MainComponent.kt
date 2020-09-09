package com.batdemir.similar.flora.example.di.component

import com.batdemir.similar.flora.example.di.module.ProductionModule
import com.batdemir.similar.flora.example.di.module.SettingsModule
import com.batdemir.similar.flora.example.di.scope.ActivityScope
import com.batdemir.similar.flora.example.ui.main.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ProductionModule::class, SettingsModule::class])
interface MainComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(activity: MainActivity)
    fun productComponent(): ProductComponent.Factory
    fun settingsComponent(): SettingsComponent.Factory
}