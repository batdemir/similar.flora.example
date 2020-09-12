package com.batdemir.similar.flora.example.ui.product.filter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.batdemir.similar.flora.example.databinding.ItemFilterDetailBinding
import com.batdemir.similar.flora.example.model.DynamicFilterValuesModel
import java.util.stream.Collectors

class ProductFilterDetailAdapter(private val listener: ProductFilterDetailItemListener) :
    RecyclerView.Adapter<ProductFilterDetailAdapter.ProductFilterDetailViewHolder>() {

    interface ProductFilterDetailItemListener {
        fun onClicked(model: DynamicFilterValuesModel)
    }

    private val items = ArrayList<DynamicFilterValuesModel>()

    fun setItems(items: ArrayList<DynamicFilterValuesModel>, showAll: Boolean) {
        this.items.clear()
        this.items.addAll(
            items.stream()
                .limit(
                    (
                            if (!showAll)
                                if (items.size >= 3) 3
                                else items.size
                            else items.size
                            ).toLong()
                )
                .collect(Collectors.toList())
        )
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductFilterDetailViewHolder {
        val binding: ItemFilterDetailBinding =
            ItemFilterDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductFilterDetailViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ProductFilterDetailViewHolder, position: Int) =
        holder.bind(items[position])

    inner class ProductFilterDetailViewHolder(
        private val binding: ItemFilterDetailBinding,
        private val listener: ProductFilterDetailItemListener
    ) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {

        private lateinit var item: DynamicFilterValuesModel

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(item: DynamicFilterValuesModel) {
            this.item = item
            binding.textViewEditFilterDetailName.text = item.name
        }

        override fun onClick(v: View?) {
            listener.onClicked(item)
        }
    }
}