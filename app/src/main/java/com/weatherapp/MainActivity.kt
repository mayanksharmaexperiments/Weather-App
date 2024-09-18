package com.weatherapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.weatherapp.domain.Resource
import com.weatherapp.domain.usecase.WeatherUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var weatherUseCase: WeatherUseCase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch(Dispatchers.IO) {
            weatherUseCase.searchCity("Jaipur")
                .collectLatest { response ->
                    withContext(Dispatchers.Main) {
                        when (response) {
                            is Resource.Loading -> {
                                Toast.makeText(
                                    this@MainActivity,
                                    "Loading",
                                    Toast.LENGTH_SHORT
                                ).show()

                            }

                            is Resource.Success -> {
                                Toast.makeText(
                                    this@MainActivity,
                                    response.data.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                            is Resource.Error -> {
                                Toast.makeText(
                                    this@MainActivity,
                                    response.message,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }


                }
        }

    }

}