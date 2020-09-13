package com.batdemir.similar.flora.example.api

import com.batdemir.similar.flora.example.model.DataModel
import com.batdemir.similar.flora.example.model.ResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IProduct {
    @GET("v1/product/ch/dynamicproductlist")
    suspend fun getDynamicProductList(): Response<ResponseModel<DataModel>>

    @GET("v1/product/ch/dynamicproductlist")
    suspend fun getDynamicProductList(
        @Query("detailList") detailList: List<Long>,
        @Query("checkList") checkList: List<Long>,
        @Query("priceList") priceList: List<Long>
    ): Response<ResponseModel<DataModel>>
}