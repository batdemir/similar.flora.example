package com.batdemir.similar.flora.example.di.module

import com.batdemir.similar.flora.example.di.component.ProductComponent
import dagger.Module

@Module(subcomponents = [ProductComponent::class])
class ProductionModule