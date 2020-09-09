package com.batdemir.similar.flora.example.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.batdemir.similar.flora.example.api.IProduct
import com.batdemir.similar.flora.example.model.DataModel
import com.batdemir.similar.flora.example.model.ResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

interface IProductRepository {
    fun getProducts(): LiveData<ResponseModel<DataModel>>
}

@Singleton
class ProductRepository @Inject constructor(
    private val iService: IProduct
) : IProductRepository {

    var postInfoMutableList: MutableLiveData<ResponseModel<DataModel>> = MutableLiveData()

    override fun getProducts(): LiveData<ResponseModel<DataModel>> {
        iService.getDynamicProductList().enqueue(
            object : Callback<ResponseModel<DataModel>> {
                override fun onResponse(
                    call: Call<ResponseModel<DataModel>>,
                    response: Response<ResponseModel<DataModel>>
                ) {
                    val body: ResponseModel<DataModel> = response.body()!!
                    if (body.error.type == 0)
                        postInfoMutableList.value = response.body()
                    else
                        Log.e("", body.error.message)
                }

                override fun onFailure(call: Call<ResponseModel<DataModel>>, t: Throwable) {
                    Log.e("", t.message.orEmpty())
                }
            })

        return postInfoMutableList;
    }
}