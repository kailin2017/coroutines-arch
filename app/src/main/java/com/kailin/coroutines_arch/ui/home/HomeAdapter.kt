package com.kailin.coroutines_arch.ui.home

import com.kailin.coroutines_arch.R
import com.kailin.coroutines_arch.databinding.ItemHomeBinding
import com.kailin.coroutines_arch.repo.common.Category
import com.kailin.traffic.app.MyRecyclerAdapter
import com.kailin.traffic.app.ViewHolder

class HomeAdapter : MyRecyclerAdapter<ItemHomeBinding, Category>() {

    override val viewLayoutRes: Int = R.layout.item_home

    override fun onBindViewHolder(holder: ViewHolder<ItemHomeBinding>, position: Int) {
        holder.binding.data = data[position]
    }
}