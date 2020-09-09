package com.batdemir.similar.flora.example.di.module

import com.batdemir.similar.flora.example.api.IProduct
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object ProductServiceModule {
    @Singleton
    @Provides
    fun provideProductService(retrofit: Retrofit): IProduct = retrofit.create(IProduct::class.java)
}