package com.batdemir.similar.flora.example.model

import java.io.Serializable

data class ProductModel(
    val id: Long,
    val code: String,
    val name: String,
    val image: String,
    val link: String,
    val webLink: String,
    val deliveryBadgeType: Int,
    val deliveryBadgeText: String,
    val deliveryChargeText: String,
    val price: PriceModel,
    val isMarketplace: Boolean,
    val largeImage: String,
    val isDiscountAvailable: Boolean,
    val isOriginal: Boolean,
    val installment: Boolean,
    val installmentText: String,
    val smallImage: String,
    val xlargeImage: String,
    val mediumImage: String,
    val mostSellestProduct: Boolean,
    val isHaveVase: Boolean,
    val isHaveVaseText: String,
    val productDeliveryCity: ProductDeliveryCity,
    val productGroupId: Int,
    val variantCode: String,
    val entryId: Long,
    val reviewRating: Number,
    val reviewCount: Long,
    val information: String,
    val isSubscription: Boolean,
    val productType: Int
) : Serializable