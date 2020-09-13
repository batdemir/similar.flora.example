package com.batdemir.similar.flora.example.data

import com.batdemir.similar.flora.example.api.IProduct
import javax.inject.Inject

class ProductRemoteDataSource @Inject constructor(private val productService: IProduct) :
    BaseDataSource() {

    suspend fun getProducts() = getResult { productService.getDynamicProductList() }

    suspend fun getProducts(
        detailList: List<Long>,
        checkList: List<Long>,
        priceList: List<Long>
    ) = getResult { productService.getDynamicProductList(detailList, checkList, priceList) }
}