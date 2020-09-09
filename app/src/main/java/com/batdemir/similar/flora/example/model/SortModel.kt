package com.batdemir.similar.flora.example.model

data class SortModel(
    val count: Long,
    val id: Long,
    val selected: Boolean,
    val link: String,
    val name: String,
    val group: Long,
    val detailValuedId: Long
)