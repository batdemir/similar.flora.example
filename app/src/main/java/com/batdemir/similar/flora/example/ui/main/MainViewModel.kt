package com.batdemir.similar.flora.example.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.batdemir.similar.flora.example.model.DataModel
import com.batdemir.similar.flora.example.model.ResponseModel
import com.batdemir.similar.flora.example.repo.ProductRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val productionRepository: ProductRepository) :
    ViewModel() {

    private val _data = MutableLiveData<ResponseModel<DataModel>>()
    val data: LiveData<ResponseModel<DataModel>>
        get() = _data


    fun getData() {
        _data.value = productionRepository.getProducts().value
    }
}