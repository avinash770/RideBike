package com.ridebike.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ridebike.R
import kotlinx.android.synthetic.main.join_group_adapter_item.view.*

/**
 * Adapter for Social Fragment
 */
class FragmentSocialAdapter :
    RecyclerView.Adapter<FragmentSocialAdapter.FragmentSocialAdapterViewHolder>() {

    private val groupImage = intArrayOf(
        R.drawable.ic_group_one,
        R.drawable.ic_group_two,
        R.drawable.ic_group_three
    )

    private val groupName = intArrayOf(
        R.string.demo_group_name_one,
        R.string.demo_group_name_two,
        R.string.demo_group_name_three
    )
    private val groupMembers = intArrayOf(
        R.string.demo_size_one,
        R.string.demo_size_two,
        R.string.demo_size_three
    )
    private val groupStatus = intArrayOf(
        R.string.open,
        R.string.closed,
        R.string.closed
    )
    private val groupJoinRequest = intArrayOf(
        R.string.join,
        R.string.request,
        R.string.request
    )

    override fun getItemCount(): Int {
        return groupImage.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FragmentSocialAdapterViewHolder {
        return FragmentSocialAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.join_group_adapter_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FragmentSocialAdapterViewHolder, position: Int) {
        holder.tv_group_name?.setText(groupName[position])
        holder.tv_no_members?.setText(groupMembers[position])
        holder.tv_group_status?.setText(groupStatus[position])
        holder.iv_group_image.setImageResource(groupImage[position])          // setting interest bike image
        holder.join_request_view.visibility = View.GONE                         // hiding join button for this fragment only
    }

    inner class FragmentSocialAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_group_image = view.iv_group_image
        val tv_group_name = view.tv_group_name
        val tv_no_members = view.tv_no_members
        val tv_group_status = view.tv_group_status
        var join_request_view = view.cl_join_request_view

    }
}