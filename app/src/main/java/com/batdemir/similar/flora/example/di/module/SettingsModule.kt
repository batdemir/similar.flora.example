package com.batdemir.similar.flora.example.di.module

import com.batdemir.similar.flora.example.di.component.SettingsComponent
import dagger.Module

@Module(subcomponents = [SettingsComponent::class])
class SettingsModule