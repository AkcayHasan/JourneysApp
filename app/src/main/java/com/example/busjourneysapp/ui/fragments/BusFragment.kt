package com.example.busjourneysapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.busjourneysapp.App
import com.example.busjourneysapp.base.BaseFragment
import com.example.busjourneysapp.data.repository.JourneyRepositoryImpl
import com.example.busjourneysapp.databinding.FragmentBusBinding
import com.example.busjourneysapp.domain.usecases.SessionUseCase
import com.example.busjourneysapp.util.CustomSharedPref
import com.example.busjourneysapp.viewmodel.BusViewModel
import com.example.busjourneysapp.viewmodel.BusViewModelFactory
import com.example.busjourneysapp.viewmodel.ViewModelParams

class BusFragment : BaseFragment<FragmentBusBinding>() {

    // search özelliğini implement et
    // busJourneys servisini ve data classlarını ekle

    private lateinit var viewModel: BusViewModel
    private lateinit var busViewModelFactory: BusViewModelFactory

    override fun getViewBinding(): FragmentBusBinding {
        return FragmentBusBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val journeyRepositoryImpl = JourneyRepositoryImpl()

        val viewModelParams = ViewModelParams()
        viewModelParams.application = requireActivity().application
        viewModelParams.sessionUseCase = SessionUseCase(journeyRepositoryImpl)
        viewModelParams.customSharedPref = CustomSharedPref(binding.root.context)

        busViewModelFactory = BusViewModelFactory(viewModelParams)
        CustomSharedPref(binding.root.context).fetchSessionId()?.let {
            App.sessionId = it
        }
        CustomSharedPref(binding.root.context).fetchDeviceId()?.let {
            App.deviceId = it
        }


        actions()

        viewModel = ViewModelProvider(requireActivity(), busViewModelFactory).get(BusViewModel::class.java)


    }

    private fun actions() {

    }


}