package com.kailin.coroutines_arch.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kailin.coroutines_arch.databinding.FragmentHomeBinding
import com.kailin.traffic.app.BaseFragment

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    override val viewModel: HomeViewModel by viewModels()

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun initView() {
        val adapter = HomeAdapter()
        viewDataBinding?.let {
            it.recyclerView.adapter = adapter
        }
        viewModel.typiCodes.observe(this, { adapter.updateData(it) })
    }
}