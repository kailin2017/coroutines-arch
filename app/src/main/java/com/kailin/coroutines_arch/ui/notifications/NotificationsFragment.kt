package com.kailin.coroutines_arch.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kailin.coroutines_arch.databinding.FragmentNotificationsBinding
import com.kailin.traffic.app.BaseFragment

class NotificationsFragment : BaseFragment<NotificationsViewModel, FragmentNotificationsBinding>() {

    override val viewModel: NotificationsViewModel by viewModels()

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentNotificationsBinding.inflate(inflater, container, false)

    override fun initView() {
    }
}