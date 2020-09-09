package com.batdemir.similar.flora.example.model

data class ResponseModel<T>(
    val result: ResultModel<T>,
    val error: ErrorModel
)