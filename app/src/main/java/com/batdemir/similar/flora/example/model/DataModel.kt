package com.batdemir.similar.flora.example.model

data class DataModel(
    val products: List<ProductModel>,
    val mainFilter: MainFilterModel,
    val productCount: Long,
    val isAlternate: Boolean,
    val hasOldPrice: Boolean,
    val subCategoryModel: SubCategoryModel
)