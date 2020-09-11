package com.batdemir.similar.flora.example.ui.product.list

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.batdemir.similar.flora.example.databinding.ItemProductBinding
import com.batdemir.similar.flora.example.model.ProductModel


class RecyclerViewAdapter(var context: Activity, private val models: List<ProductModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var binding : ItemProductBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemProductBinding.inflate(context.layoutInflater,parent,false)
        return ProductListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model: ProductModel = models[position]
        val viewHolder = holder as ProductListViewHolder
        viewHolder.setData(model)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    internal inner class ProductListViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        lateinit var productionModel: ProductModel

        fun setData(productModel: ProductModel) {
            this.productionModel = productModel
            binding.textViewEditProductName.text = productionModel.name
            binding.textViewEditProductProperty.text = productionModel.deliveryBadgeText
            binding.textViewEditProductDiscount.text =
                String.format("%.2f", productionModel.price.discountPercentage)
            binding.textViewEditProductOldPrice.text =
                String.format("%.2f", productionModel.price.old)
            binding.textViewEditProductPrice.text =
                String.format("%.2f", productionModel.price.current)
            binding.textViewEditProductCommentCount.text =
                String.format("%.2f", productionModel.reviewRating)
            binding.textViewEditProductInstallment.text = productionModel.installmentText
        }

        override fun onClick(v: View?) {
            //Not implemented.
        }
    }
}