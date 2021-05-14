package com.ridebike.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.ridebike.R
import kotlinx.android.synthetic.main.join_group_adapter_item.view.*

/**
 * Adapter for showing groups
 */
class JoinGroupAdapter(private val activity: AppCompatActivity) :
    RecyclerView.Adapter<JoinGroupAdapter.JoinGroupAdapterViewHolder>() {

    //dummy data
    private val groupImage = intArrayOf(
        R.drawable.ic_group_one,
        R.drawable.ic_group_two,
        R.drawable.ic_group_three
    )

    //dummy data
    private val groupName = intArrayOf(
        R.string.demo_group_name_one,
        R.string.demo_group_name_two,
        R.string.demo_group_name_three
    )

    //dummy data
    private val groupMembers = intArrayOf(
        R.string.demo_size_one,
        R.string.demo_size_two,
        R.string.demo_size_three
    )

    //dummy data
    private val groupStatus = intArrayOf(
        R.string.open,
        R.string.closed,
        R.string.closed
    )

    //dummy data
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
    ): JoinGroupAdapterViewHolder {
        return JoinGroupAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.join_group_adapter_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: JoinGroupAdapterViewHolder, position: Int) {
        holder.tv_group_name?.text = activity.getString(groupName[position])
        holder.tv_no_members?.text = activity.getString(groupMembers[position])
        holder.tv_group_status?.text = activity.getString(groupStatus[position])
        holder.tv_join_request?.text = activity.getString(groupJoinRequest[position])
        holder.iv_group_image.setImageResource(groupImage[position])          // setting interest bike image
    }

    inner class JoinGroupAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_group_image = view.iv_group_image
        val tv_group_name = view.tv_group_name
        val tv_no_members = view.tv_no_members
        val tv_group_status = view.tv_group_status
        val tv_join_request = view.tv_join_request

    }
}