package com.batdemir.similar.flora.example.model

data class DynamicFilterModel(
    val detailId: Long,
    val name: String,
    val sequence: Int,
    val filterType: Int,
    val values: ArrayList<DynamicFilterValuesModel>
)
