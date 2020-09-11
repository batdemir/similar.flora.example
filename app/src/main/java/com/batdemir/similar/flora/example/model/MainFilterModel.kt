package com.batdemir.similar.flora.example.model

data class MainFilterModel(
    val dynamicFilter: ArrayList<DynamicFilterModel>,
    val sort: ArrayList<SortModel>
)