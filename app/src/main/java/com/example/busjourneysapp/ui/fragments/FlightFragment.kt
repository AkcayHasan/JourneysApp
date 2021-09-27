package com.example.busjourneysapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.busjourneysapp.R
import com.example.busjourneysapp.base.BaseFragment
import com.example.busjourneysapp.databinding.FragmentFlightBinding

class FlightFragment : BaseFragment<FragmentFlightBinding>() {

    override fun getViewBinding(): FragmentFlightBinding {
        return FragmentFlightBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}