package com.batdemir.similar.flora.example.model

import java.io.Serializable

data class PriceModel(
    val current: Number,
    val old: Number,
    val total: Number,
    val currency: String,
    val currencyCode: String,
    val oldTotal: Number,
    val discountPercentage: Int,
    val showFirstPrice: Boolean,
    val subscriptionPrice: Number,
    val showCurrencyCode: Boolean,
    val showDecimalPart: Boolean
) : Serializable