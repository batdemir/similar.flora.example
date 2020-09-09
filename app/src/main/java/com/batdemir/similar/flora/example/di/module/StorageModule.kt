package com.batdemir.similar.flora.example.di.module

import com.batdemir.similar.flora.example.repo.storage.SharedPreferencesStorage
import com.batdemir.similar.flora.example.repo.storage.Storage
import dagger.Binds
import dagger.Module

@Module
abstract class StorageModule {
    @Binds
    abstract fun provideStorage(storage: SharedPreferencesStorage): Storage
}