package com.weatherapp.searchcity

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.weatherapp.databinding.ItemCityBinding
import com.weatherapp.domain.entity.SearchCityResponseEntity

class CityAdapter(private val listener: OnItemClickListener) :
    RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    private var cityList: List<SearchCityResponseEntity> = emptyList()

    fun setCityList(cityList: List<SearchCityResponseEntity>?) {
        this.cityList = cityList?: emptyList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val binding = ItemCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(cityList[position])
    }

    override fun getItemCount(): Int = cityList.size

    inner class CityViewHolder(private val binding: ItemCityBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cityDetails: SearchCityResponseEntity) {
            binding.cityDetails = cityDetails
            binding.executePendingBindings()

            binding.root.setOnClickListener {
                listener.onItemClick(cityDetails)
            }
        }

    }
}

interface OnItemClickListener {
    fun onItemClick(cityDetails: SearchCityResponseEntity)
}
