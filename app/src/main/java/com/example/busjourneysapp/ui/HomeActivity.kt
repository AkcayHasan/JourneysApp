package com.example.busjourneysapp.ui

import android.os.Bundle
import com.example.busjourneysapp.adapter.ViewPagerAdapter
import com.example.busjourneysapp.base.BaseActivity
import com.google.android.material.tabs.TabLayoutMediator
import android.widget.FrameLayout
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.busjourneysapp.data.repository.JourneyRepositoryImpl
import com.example.busjourneysapp.databinding.ActivityHomeBinding
import com.example.busjourneysapp.domain.usecases.SessionUseCase
import com.example.busjourneysapp.util.CustomSharedPref
import com.example.busjourneysapp.viewmodel.HomeViewModel
import com.example.busjourneysapp.viewmodel.HomeViewModelFactory
import com.example.busjourneysapp.viewmodel.ViewModelParams


class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    private var indicatorWidth = 0
    private lateinit var viewModel: HomeViewModel
    private lateinit var homeViewModelFactory: HomeViewModelFactory

    override fun getViewBinding(): ActivityHomeBinding {
        return ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val journeyRepositoryImpl = JourneyRepositoryImpl()

        val viewModelParams = ViewModelParams()
        viewModelParams.application = this.application
        viewModelParams.sessionUseCase = SessionUseCase(journeyRepositoryImpl)
        viewModelParams.customSharedPref = CustomSharedPref(this)

        homeViewModelFactory = HomeViewModelFactory(viewModelParams)

        viewModel = ViewModelProvider(this, homeViewModelFactory).get(HomeViewModel::class.java)

        val viewPager2 = binding.viewPager2
        val tabLayout = binding.tab

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager2.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Otobüs Bileti"
                }
                1 -> {
                    tab.text = "Uçak Bileti"
                }
            }

        }.attach()

        tabLayout.post {
            indicatorWidth = tabLayout.width / tabLayout.tabCount
            val indicatorParams = binding.indicator.layoutParams
            indicatorParams.width = indicatorWidth
            binding.indicator.layoutParams = indicatorParams
        }


        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                val params = binding.indicator.layoutParams as FrameLayout.LayoutParams

                val translationOffset: Float = (positionOffset + position) * indicatorWidth
                params.leftMargin = translationOffset.toInt()
                binding.indicator.layoutParams = params
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })

    }

}