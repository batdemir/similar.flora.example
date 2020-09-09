package com.batdemir.similar.flora.example.di.module

import com.batdemir.similar.flora.example.di.component.MainComponent
import dagger.Module

@Module(subcomponents = [MainComponent::class])
class SubComponentsModule