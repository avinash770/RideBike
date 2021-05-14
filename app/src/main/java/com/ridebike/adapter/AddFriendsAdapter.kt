package com.ridebike.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.ridebike.R
import kotlinx.android.synthetic.main.add_friends_adapter_item.view.*

/**
 * Adapter used to set add friends data
 */
class AddFriendsAdapter(
    private val activity: AppCompatActivity
) :
    RecyclerView.Adapter<AddFriendsAdapter.AddFriendsAdapterViewHolder>() {

    //dummy data
    private val addFriendImages = intArrayOf(
        R.drawable.ic_friend_one,
        R.drawable.ic_friend_two,
        R.drawable.ic_friend_three,
        R.drawable.ic_friend_one,
        R.drawable.ic_friend_two,
        R.drawable.ic_friend_three,
        R.drawable.ic_friend_one,
        R.drawable.ic_friend_two,
        R.drawable.ic_friend_three,
        R.drawable.ic_friend_one

    )

    //dummy data
    private val addFriendNames = intArrayOf(
        R.string.demo_name_one,
        R.string.demo_name_two,
        R.string.demo_name_three,
        R.string.demo_name_one,
        R.string.demo_name_two,
        R.string.demo_name_three,
        R.string.demo_name_one,
        R.string.demo_name_two,
        R.string.demo_name_three,
        R.string.demo_name_one
    )

    override fun getItemCount(): Int {
        return addFriendImages.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AddFriendsAdapterViewHolder {
        return AddFriendsAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.add_friends_adapter_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AddFriendsAdapterViewHolder, position: Int) {

        holder.tv_friend_name?.text = activity.getString(addFriendNames[position])
        holder.iv_friend_image.setImageResource(addFriendImages[position])

        //handling checkbox on view click
        var checkFlag: Boolean = false
        holder.itemView.setOnClickListener {

            if (checkFlag) {
                holder.checkBox.isChecked = false
                checkFlag = false
            } else {
                holder.checkBox.isChecked = true
                checkFlag = true
            }
        }
    }

    inner class AddFriendsAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_friend_name = view.tv_friend_name
        var iv_friend_image = view.uv_friend_image
        var checkBox = view.cb_friend_selected
    }

}