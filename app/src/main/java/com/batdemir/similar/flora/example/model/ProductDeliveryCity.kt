package com.batdemir.similar.flora.example.model

import java.io.Serializable

data class ProductDeliveryCity(
    val deliveryCityImage: String,
    val isSendToSingleCity: Boolean
) : Serializable