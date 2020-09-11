package com.batdemir.similar.flora.example.api

import com.batdemir.similar.flora.example.model.DataModel
import com.batdemir.similar.flora.example.model.ResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface IProduct {
    @GET("v1/product/ch/dynamicproductlist")
    suspend fun getDynamicProductList(): Response<ResponseModel<DataModel>>
}