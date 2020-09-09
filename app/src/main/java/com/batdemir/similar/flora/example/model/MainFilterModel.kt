package com.batdemir.similar.flora.example.model

data class MainFilterModel(
    val dynamicFilter: List<DynamicFilterModel>,
    val sort: List<SortModel>
)