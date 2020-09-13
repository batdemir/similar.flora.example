package com.batdemir.similar.flora.example.ui.product.detail

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.batdemir.similar.flora.example.databinding.ProductFragmentBinding
import com.batdemir.similar.flora.example.model.ProductModel
import com.batdemir.similar.flora.example.ui.main.MainActivity
import com.bumptech.glide.Glide
import javax.inject.Inject


class ProductFragment : Fragment() {
    @Inject
    lateinit var viewModel: ProductViewModel

    private lateinit var binding: ProductFragmentBinding
    private lateinit var productModel: ProductModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        (requireActivity() as MainActivity).mainComponent.productComponent().create().inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupData()
        setupListener()
    }

    private fun setupData() {
        productModel = arguments?.get("productArg") as ProductModel
        binding.textViewEditProductName.text = productModel.name
        binding.textViewEditProductProperty.text = productModel.deliveryBadgeText
        if (productModel.price.discountPercentage == 0)
            binding.textViewEditProductDiscount.visibility = View.GONE
        else
            binding.textViewEditProductDiscount.text =
                String.format("%d", productModel.price.discountPercentage)
        if (productModel.price.old.toDouble() == 0.00)
            binding.textViewEditProductOldPrice.visibility = View.GONE
        else
            binding.textViewEditProductOldPrice.text =
                String.format("%.2f", productModel.price.old.toDouble())
        binding.textViewEditProductPrice.text =
            String.format("%.2f", productModel.price.current.toDouble())
        binding.textViewEditProductCommentCount.text =
            String.format("%.2f", productModel.reviewRating.toDouble())
        binding.textViewEditProductInstallment.text = productModel.installmentText
        Glide.with(binding.root)
            .load(productModel.mediumImage)
            .into(binding.imageViewEditProduct)
    }

    private fun setupListener() {
        binding.btnBuy.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(productModel.webLink))
            startActivity(browserIntent)
        }
    }
}