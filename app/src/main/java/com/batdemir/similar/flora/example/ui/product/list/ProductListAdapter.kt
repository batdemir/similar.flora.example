package com.batdemir.similar.flora.example.ui.product.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.batdemir.similar.flora.example.databinding.ItemProductBinding
import com.batdemir.similar.flora.example.model.ProductModel
import com.bumptech.glide.Glide

class ProductListAdapter(private val listener: ProductItemListener) :
    RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    interface ProductItemListener {
        fun onClicked(model: ProductModel)
    }

    private val items = ArrayList<ProductModel>()

    fun setItems(items: ArrayList<ProductModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding: ItemProductBinding =
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) =
        holder.bind(items[position])

    inner class ProductViewHolder(
        private val binding: ItemProductBinding,
        private val listener: ProductListAdapter.ProductItemListener
    ) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {

        private lateinit var item: ProductModel

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(item: ProductModel) {
            this.item = item
            binding.textViewEditProductName.text = item.name
            binding.textViewEditProductProperty.text = item.deliveryBadgeText
            if (item.price.discountPercentage == 0)
                binding.textViewEditProductDiscount.visibility = View.GONE
            else
                binding.textViewEditProductDiscount.text =
                    String.format("%d", item.price.discountPercentage)
            if (item.price.old.toDouble() == 0.00)
                binding.textViewEditProductOldPrice.visibility = View.GONE
            else
                binding.textViewEditProductOldPrice.text =
                    String.format("%.2f", item.price.old.toDouble())
            binding.textViewEditProductPrice.text =
                String.format("%.2f", item.price.current.toDouble())
            binding.textViewEditProductCommentCount.text =
                String.format("%.2f", item.reviewRating.toDouble())
            binding.textViewEditProductInstallment.text = item.installmentText
            Glide.with(binding.root)
                .load(item.smallImage)
                .into(binding.imageViewEditProduct)
        }

        override fun onClick(v: View?) {
            listener.onClicked(item)
        }
    }
}