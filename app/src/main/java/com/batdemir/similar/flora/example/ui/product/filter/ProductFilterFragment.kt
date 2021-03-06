package com.batdemir.similar.flora.example.ui.product.filter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.batdemir.similar.flora.example.databinding.ProductFilterFragmentBinding
import com.batdemir.similar.flora.example.model.DynamicFilterValuesModel
import com.batdemir.similar.flora.example.ui.main.MainActivity
import com.batdemir.similar.flora.example.ui.main.MainViewModel
import com.batdemir.similar.flora.example.ui.product.list.ProductListViewModel
import com.batdemir.similar.flora.example.utils.Resource
import javax.inject.Inject

class ProductFilterFragment :
    Fragment(),
    ProductFilterDetailAdapter.ProductFilterDetailItemListener {
    @Inject
    lateinit var viewModel: ProductFilterViewModel

    @Inject
    lateinit var productListViewModel: ProductListViewModel

    @Inject
    lateinit var mainViewModel: MainViewModel

    private lateinit var binding: ProductFilterFragmentBinding
    private lateinit var adapter: ProductFilterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductFilterFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        (requireActivity() as MainActivity).mainComponent.productComponent().create().inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
        setupListener()
    }

    private fun setupRecyclerView() {
        adapter = ProductFilterAdapter(this)
        binding.recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        mainViewModel.getProducts(false).observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    if (!it.data?.result?.data?.products.isNullOrEmpty()) {
                        adapter.setItems(it.data?.result?.data?.mainFilter?.dynamicFilter!!)
                        binding.recyclerView.setItemViewCacheSize(adapter.itemCount)
                        viewModel.setFilter(adapter.getItems())
                    }
                }

                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    binding.progressBar.visibility = View.VISIBLE
            }
        })
    }

    private fun setupListener() {
        binding.btnFilter.setOnClickListener {
            viewModel.doFilter()
            findNavController().popBackStack()
        }
    }

    override fun onClicked(model: DynamicFilterValuesModel) {
        viewModel.crudFilter(model)
    }
}