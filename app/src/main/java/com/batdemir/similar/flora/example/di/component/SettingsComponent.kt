package com.batdemir.similar.flora.example.di.component

import com.batdemir.similar.flora.example.ui.settings.SettingsFragment
import dagger.Subcomponent

@Subcomponent
interface SettingsComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): SettingsComponent
    }

    fun inject(fragment: SettingsFragment)
}