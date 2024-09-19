package com.weatherapp.forecast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.weatherapp.BaseFragment
import com.weatherapp.R
import com.weatherapp.databinding.FragmentForecastBinding
import com.weatherapp.domain.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForecastFragment : BaseFragment() {

    private lateinit var binding: FragmentForecastBinding
    private val viewModel: ForecastViewModel by viewModels()

    private val args: ForecastFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        showToolbar(true)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_forecast, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        val forecastAdapter = ForecastAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = forecastAdapter
        }

        viewModel.forecastResponse.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Loading -> {
                    showProgressBar(true)
                }

                is Resource.Success -> {
                    showProgressBar(false)
                    forecastAdapter.setForecastList(response.data?.forecast?.forecastDays)
                }

                is Resource.Error -> {
                    showProgressBar(false)
                    showError(response.message)
                }
            }
        }

        viewModel.fetchForecast(args.city)
        binding.tvCity.text = args.city

        return binding.root
    }

}