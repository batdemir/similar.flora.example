package com.batdemir.similar.flora.example.di.component

import com.batdemir.similar.flora.example.ui.product.detail.ProductFragment
import com.batdemir.similar.flora.example.ui.product.filter.ProductFilterFragment
import com.batdemir.similar.flora.example.ui.product.list.ProductListFragment
import dagger.Subcomponent

@Subcomponent
interface ProductComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): ProductComponent
    }

    fun inject(fragment: ProductListFragment)
    fun inject(fragment: ProductFragment)
    fun inject(fragment: ProductFilterFragment)
}