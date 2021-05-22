package com.ridebike.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.ridebike.R
import kotlinx.android.synthetic.main.profile_view_adapter_item.view.*

/**
 * Setting adapter for profile fragment list items
 */
class FragmentProfileAdapter :
    RecyclerView.Adapter<FragmentProfileAdapter.FragmentProfileAdapterViewHolder>() {

    private val profileTitle = intArrayOf(
        R.string.profile_title_one,
        R.string.profile_title_two,
        R.string.profile_title_three,
        R.string.profile_title_four
    )
    private val profileSubItem = intArrayOf(
        R.string.profile_sub_item_one,
        R.string.profile_sub_item_two,
        R.string.profile_sub_item_three,
        R.string.profile_sub_item_four
    )

    override fun getItemCount(): Int {
        return profileTitle.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FragmentProfileAdapterViewHolder {
        return FragmentProfileAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.profile_view_adapter_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FragmentProfileAdapterViewHolder, position: Int) {
        holder.profileTitle?.setText(profileTitle[position])
        holder.profileSubItem?.setText(profileSubItem[position])

    }

    inner class FragmentProfileAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val profileTitle = view.tv_profile_list_title
        val profileSubItem = view.tv_profile_list_sub_item

    }

}