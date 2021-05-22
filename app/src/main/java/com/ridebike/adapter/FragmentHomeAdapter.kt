package com.ridebike.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ridebike.R
import kotlinx.android.synthetic.main.home_view_adpater_list.view.*

/**
 * Adapter for home fragment
 */
class FragmentHomeAdapter : RecyclerView.Adapter<FragmentHomeAdapter.HomeViewAdapterViewHolder>() {

    private val homeViewImage = intArrayOf(
        R.drawable.ic_home_image_one,
        R.drawable.ic_home_image_two,
        R.drawable.ic_home_image_one,
        R.drawable.ic_home_image_two
    )

    private val homeViewHeading = intArrayOf(
        R.string.home_view_heading_one,
        R.string.home_view_heading_two,
        R.string.home_view_heading_one,
        R.string.home_view_heading_two

    )
    private val homeViewTime = intArrayOf(
        R.string.home_view_time_one,
        R.string.home_view_time_two,
        R.string.home_view_time_one,
        R.string.home_view_time_two
    )

    // Gets the number of images in the list
    override fun getItemCount(): Int {
        return homeViewImage.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeViewAdapterViewHolder {
        return HomeViewAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.home_view_adpater_list,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeViewAdapterViewHolder, position: Int) {
        holder.homeViewActivityHeading?.setText(homeViewHeading[position])
        holder.homeViewTime?.setText(homeViewTime[position])
        holder.homeViewMiddleImage.setImageResource(homeViewImage[position])          // setting interest bike image
    }

    inner class HomeViewAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var homeViewMiddleImage = view.home_view_middle_image
        val homeViewActivityHeading = view.home_view_activity_heading
        val homeViewTime = view.home_view_time

    }
}