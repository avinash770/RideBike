package com.ridebike.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ridebike.R
import kotlinx.android.synthetic.main.home_view_checkbox_adapter_list.view.*

/**
 * Setting adapter for top checkbox on home screen
 */
class HomeViewCheckboxAdapter :
    RecyclerView.Adapter<HomeViewCheckboxAdapter.HomeViewCheckboxAdapterViewHolder>() {

    private val homeViewCheckboxList = intArrayOf(
        R.string.all,
        R.string.rides,
        R.string.activities,
        R.string.riding_news,
        R.string.shop
    )

    override fun getItemCount(): Int {
        return homeViewCheckboxList.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeViewCheckboxAdapterViewHolder {
        return HomeViewCheckboxAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.home_view_checkbox_adapter_list,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeViewCheckboxAdapterViewHolder, position: Int) {
        holder.cb_home_view?.setText(homeViewCheckboxList[position])

        //setting "Rides" and "Riding News" checkbox by default
        if (position == 1 || position == 3)
            holder.cb_home_view.isChecked = true
    }

    inner class HomeViewCheckboxAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cb_home_view = view.cb_home_view

    }
}