package com.weatherapp

import android.widget.Toast
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    fun showProgressBar(isVisible: Boolean) {
        (activity as MainActivity).showProgressBar(isVisible)
    }

    fun showError(message: String?) {
        Toast.makeText(
            context,
            message ?: getString(R.string.something_went_wrong),
            Toast.LENGTH_SHORT
        ).show()
    }

    fun showToolbar(isVisible: Boolean) {
        (activity as MainActivity).showToolbar(isVisible)
    }
}