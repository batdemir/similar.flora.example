package com.batdemir.similar.flora.example.ui.product.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.batdemir.similar.flora.example.R
import com.batdemir.similar.flora.example.databinding.ProductListFragmentBinding
import com.batdemir.similar.flora.example.model.ProductModel
import com.batdemir.similar.flora.example.ui.main.MainActivity
import com.batdemir.similar.flora.example.ui.main.MainViewModel
import com.batdemir.similar.flora.example.utils.Resource
import javax.inject.Inject


class ProductListFragment :
    Fragment(),
    ProductListAdapter.ProductItemListener {
    @Inject
    lateinit var viewModel: ProductListViewModel

    @Inject
    lateinit var mainViewModel: MainViewModel

    private lateinit var binding: ProductListFragmentBinding
    private lateinit var adapter: ProductListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductListFragmentBinding.inflate(inflater, container, false)
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
        setupListeners()
    }

    private fun setupRecyclerView() {
        adapter = ProductListAdapter(this)
        binding.recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        mainViewModel.getProducts(false).observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    if (!it.data?.result?.data?.products.isNullOrEmpty()) adapter.setItems(it.data?.result?.data?.products!!)
                }

                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    binding.progressBar.visibility = View.VISIBLE
            }
        })
    }

    private fun setupListeners() {
        binding.btnSearch.setOnClickListener {
            Toast.makeText(
                context,
                getString(R.string.not_supported),
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.btnFilter.setOnClickListener {
            findNavController().navigate(
                R.id.navigation_product_filter,
                null,
                mainViewModel.navOptions
            )
        }
    }

    override fun onClicked(model: ProductModel) {
        val bundle = bundleOf("productArg" to model)
        findNavController().navigate(
            R.id.navigation_product,
            bundle,
            mainViewModel.navOptions
        )
    }
}