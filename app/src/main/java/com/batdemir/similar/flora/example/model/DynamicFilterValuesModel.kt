package com.batdemir.similar.flora.example.model

data class DynamicFilterValuesModel(
    val count: Long,
    val id: Long,
    val selected: Boolean,
    val link: String,
    val name: String,
    val group: Int,
    val detailValueId: Long
)