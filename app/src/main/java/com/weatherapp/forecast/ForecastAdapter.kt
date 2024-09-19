package com.weatherapp.forecast

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.weatherapp.databinding.ItemCityBinding
import com.weatherapp.databinding.ItemForecastBinding
import com.weatherapp.domain.entity.ForecastDayEntity

class ForecastAdapter() :
    RecyclerView.Adapter<ForecastAdapter.ForecastViewModel>() {

    private var forecastList: List<ForecastDayEntity> = emptyList()

    fun setForecastList(cityList: List<ForecastDayEntity>?) {
        this.forecastList = cityList ?: emptyList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewModel {
        val binding =
            ItemForecastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ForecastViewModel(binding)
    }

    override fun onBindViewHolder(holder: ForecastViewModel, position: Int) {
        holder.bind(forecastList[position])
    }

    override fun getItemCount(): Int = forecastList.size

    inner class ForecastViewModel(private val binding: ItemForecastBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dayDetails: ForecastDayEntity) {
            binding.dayDetails = dayDetails

            Glide.with(binding.root.context).load("https:${dayDetails.day.condition.icon}")
                .into(binding.imgIcon)

            binding.executePendingBindings()
        }

    }
}