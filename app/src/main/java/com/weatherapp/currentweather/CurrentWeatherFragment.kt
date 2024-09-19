package com.weatherapp.currentweather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.weatherapp.BaseFragment
import com.weatherapp.R
import com.weatherapp.databinding.FragmentCurrentWeatherBinding
import com.weatherapp.databinding.FragmentSearchCityBinding
import com.weatherapp.domain.Resource
import com.weatherapp.domain.entity.SearchCityResponseEntity
import com.weatherapp.searchcity.SearchCityFragmentDirections
import com.weatherapp.searchcity.SearchCityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrentWeatherFragment : BaseFragment() {

    private lateinit var binding: FragmentCurrentWeatherBinding
    private val viewModel: CurrentWeatherViewModel by viewModels()
    private val args: CurrentWeatherFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        showToolbar(true)
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_current_weather, container, false)
        binding.lifecycleOwner = viewLifecycleOwner


        viewModel.currentWeatherResponse.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Loading -> {
                    showProgressBar(true)
                }

                is Resource.Success -> {
                    showProgressBar(false)
                    binding.weatherDetails = response.data

                    response.data?.current?.condition?.icon?.let {
                        Glide.with(requireContext()).load("https:$it").into(binding.imgIcon)
                    }

                }

                is Resource.Error -> {
                    showProgressBar(false)
                    showError(response.message)
                }
            }
        }

        viewModel.fetchCurrentWeather(args.city)
        binding.tvCity.text = args.city


        binding.btn5dayForecast.setOnClickListener {
            findNavController().navigate(
                CurrentWeatherFragmentDirections.actionCurrentWeatherFragmentToForecastFragment(
                    args.city
                )
            )
        }

        return binding.root
    }

}