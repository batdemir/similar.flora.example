package com.batdemir.similar.flora.example.model

data class ErrorModel(
    val type: Int,
    val title: String,
    val message: String,
    val returnUrl: String
)