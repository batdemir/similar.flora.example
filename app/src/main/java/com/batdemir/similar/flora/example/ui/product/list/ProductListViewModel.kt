package com.batdemir.similar.flora.example.ui.product.list

import androidx.lifecycle.ViewModel
import com.batdemir.similar.flora.example.repo.ProductRepository
import javax.inject.Inject

class ProductListViewModel @Inject constructor(productRepository: ProductRepository) :
    ViewModel() {
    val products = productRepository.getProducts()
}