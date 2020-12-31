package com.kailin.coroutines_arch.ui.home

import com.kailin.coroutines_arch.R
import com.kailin.coroutines_arch.databinding.ItemHomeBinding
import com.kailin.coroutines_arch.repo.typicode.TypiCode
import com.kailin.coroutines_arch.utils.GlideHelper
import com.kailin.traffic.app.MyRecyclerAdapter
import com.kailin.traffic.app.ViewHolder

class HomeAdapter : MyRecyclerAdapter<ItemHomeBinding, TypiCode>() {

    override val viewLayoutRes: Int = R.layout.item_home
    private val glideHelper = GlideHelper.instance

    override fun onBindViewHolder(holder: ViewHolder<ItemHomeBinding>, position: Int) {
        holder.binding.also {
            val itemData = data[position]
            it.data = itemData
            glideHelper.load(it.image, itemData.thumbnailUrl)
        }
    }
}