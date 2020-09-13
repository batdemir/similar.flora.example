package com.batdemir.similar.flora.example.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.navOptions
import com.batdemir.similar.flora.example.R
import com.batdemir.similar.flora.example.model.DataModel
import com.batdemir.similar.flora.example.model.ResponseModel
import com.batdemir.similar.flora.example.repo.ProductRepository
import com.batdemir.similar.flora.example.utils.Resource
import javax.inject.Inject

class MainViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {

    val navOptions = navOptions {
        anim {
            enter = R.anim.slide_in_right
            exit = R.anim.slide_out_left
            popEnter = R.anim.slide_in_left
            popExit = R.anim.slide_out_right
        }
    }

    companion object {
        private var products: LiveData<Resource<ResponseModel<DataModel>>>? = null
    }

    fun getProducts(requireRestart: Boolean): LiveData<Resource<ResponseModel<DataModel>>> {
        if (products == null || requireRestart)
            products = productRepository.getProducts()
        return products!!
    }

    fun getProducts(
        detailList: List<Long>,
        checkList: List<Long>,
        priceList: List<Long>
    ): LiveData<Resource<ResponseModel<DataModel>>> {
        products = productRepository.getProducts(detailList, checkList, priceList)
        return products!!
    }
}