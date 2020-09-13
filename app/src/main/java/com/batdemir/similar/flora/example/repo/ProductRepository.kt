package com.batdemir.similar.flora.example.repo

import com.batdemir.similar.flora.example.data.ProductRemoteDataSource
import com.batdemir.similar.flora.example.utils.performGetOperation
import javax.inject.Inject

class ProductRepository @Inject constructor(private val remoteDataSource: ProductRemoteDataSource) {
    fun getProducts() = performGetOperation(
        networkCall = { remoteDataSource.getProducts() }
    )

    fun getProducts(
        detailList: List<Long>,
        checkList: List<Long>,
        priceList: List<Long>
    ) = performGetOperation(
        networkCall = { remoteDataSource.getProducts(detailList, checkList, priceList) }
    )
}