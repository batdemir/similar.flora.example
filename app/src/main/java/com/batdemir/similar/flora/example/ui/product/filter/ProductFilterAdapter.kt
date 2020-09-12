package com.batdemir.similar.flora.example.ui.product.filter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.batdemir.similar.flora.example.databinding.ItemFilterBinding
import com.batdemir.similar.flora.example.model.DynamicFilterModel
import com.batdemir.similar.flora.example.model.DynamicFilterValuesModel

class ProductFilterAdapter() :
    RecyclerView.Adapter<ProductFilterAdapter.ProductFilterViewHolder>() {

    private val items = ArrayList<DynamicFilterModel>()

    fun setItems(items: ArrayList<DynamicFilterModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductFilterViewHolder {
        val binding: ItemFilterBinding =
            ItemFilterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductFilterViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ProductFilterViewHolder, position: Int) =
        holder.bind(items[position])

    inner class ProductFilterViewHolder(
        private val binding: ItemFilterBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var item: DynamicFilterModel

        fun bind(item: DynamicFilterModel) {
            this.item = item
            binding.textViewEditFilterName.text = item.name
            val adapter: ProductFilterDetailAdapter = ProductFilterDetailAdapter(object :
                ProductFilterDetailAdapter.ProductFilterDetailItemListener {
                override fun onClicked(model: DynamicFilterValuesModel) {
                    TODO("Not yet implemented")
                }
            })
            binding.recyclerViewFilterDetail.adapter = adapter
            adapter.setItems(item.values, false)
            binding.recyclerViewFilterDetail.setItemViewCacheSize(item.values.size)
            binding.btnShowAll.setOnClickListener {
                it.isSelected = !it.isSelected
                adapter.setItems(item.values, it.isSelected)
                binding.recyclerViewFilterDetail.setItemViewCacheSize(adapter.itemCount)
            }
        }
    }
}