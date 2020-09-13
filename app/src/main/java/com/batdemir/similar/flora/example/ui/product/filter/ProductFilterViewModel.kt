package com.batdemir.similar.flora.example.ui.product.filter

import androidx.lifecycle.ViewModel
import com.batdemir.similar.flora.example.model.DynamicFilterModel
import com.batdemir.similar.flora.example.model.DynamicFilterValuesModel
import com.batdemir.similar.flora.example.ui.main.MainViewModel
import javax.inject.Inject

class ProductFilterViewModel @Inject constructor(private val mainViewModel: MainViewModel) :
    ViewModel() {

    private var filterList: ArrayList<DynamicFilterValuesModel>? = null;

    init {
        filterList = arrayListOf()
    }

    private fun addFilter(dynamicFilterValuesModel: DynamicFilterValuesModel) {
        filterList?.add(dynamicFilterValuesModel)
    }

    private fun removeFilter(dynamicFilterValuesModel: DynamicFilterValuesModel) {
        filterList?.remove(dynamicFilterValuesModel)
    }

    fun setFilter(filterList: ArrayList<DynamicFilterModel>) {
        filterList.forEach { model ->
            model.values.forEach { values ->
                if (values.selected)
                    this.filterList!!.add(values)
            }
        }
    }

    fun getFilter(): ArrayList<DynamicFilterValuesModel>? {
        return filterList
    }

    fun crudFilter(dynamicFilterValuesModel: DynamicFilterValuesModel) {
        if (filterList!!.contains(dynamicFilterValuesModel))
            removeFilter(dynamicFilterValuesModel)
        else
            addFilter(dynamicFilterValuesModel)
    }

    fun doFilter() {
        if (filterList!!.isEmpty()) {
            mainViewModel.getProducts(true)
            return
        }

        val detailList: ArrayList<Long> = arrayListOf()
        val checkList: ArrayList<Long> = arrayListOf()
        val priceList: ArrayList<Long> = arrayListOf()

        filterList!!.forEach {
            when (it.group) {
                1 -> detailList.add(it.id)
                2 -> checkList.add((it.id))
                3 -> priceList.add(it.id)
            }
        }

        mainViewModel.getProducts(detailList, checkList, priceList)
    }
}