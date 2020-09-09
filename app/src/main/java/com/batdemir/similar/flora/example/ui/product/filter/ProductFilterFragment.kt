package com.batdemir.similar.flora.example.ui.product.filter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.batdemir.similar.flora.example.R
import javax.inject.Inject

class ProductFilterFragment : Fragment() {
    companion object {
        fun newInstance() = ProductFilterFragment()
    }

    @Inject
    lateinit var viewModel: ProductFilterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.product_filter_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProductFilterViewModel::class.java)
        // TODO: Use the ViewModel
    }

}