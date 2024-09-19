package com.weatherapp.searchcity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.weatherapp.BaseFragment
import com.weatherapp.R
import com.weatherapp.databinding.FragmentSearchCityBinding
import com.weatherapp.domain.Resource
import com.weatherapp.domain.entity.SearchCityResponseEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchCityFragment : BaseFragment(), OnItemClickListener {

    private lateinit var binding: FragmentSearchCityBinding
    private val viewModel: SearchCityViewModel by viewModels()
    private lateinit var adapter: CityAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        showToolbar(false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search_city, container, false)
        binding.lifecycleOwner = viewLifecycleOwner


        adapter = CityAdapter(this)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        // Observe changes in weather data
        viewModel.searchCityResponse.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Loading -> {
                    showProgressBar(true)
                }

                is Resource.Success -> {
                    showProgressBar(false)
                    adapter.setCityList(response.data)
                }

                is Resource.Error -> {
                    showProgressBar(false)
                    showError(response.message)
                }
            }
        }


        binding.searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    viewModel.userInputCity.value = newText
                }
                return false
            }
        })

        return binding.root
    }

    override fun onItemClick(cityDetails: SearchCityResponseEntity) {
        findNavController().navigate(
            SearchCityFragmentDirections.actionSearchCityFragmentToCurrentWeatherFragment(
                cityDetails.name
            )
        )
    }

}