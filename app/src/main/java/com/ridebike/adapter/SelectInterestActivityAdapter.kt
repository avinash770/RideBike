package com.ridebike.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.ridebike.R
import kotlinx.android.synthetic.main.select_interest_items.view.*

class SelectInterestActivityAdapter(private val activity: AppCompatActivity) :
    RecyclerView.Adapter<SelectInterestActivityAdapter.SelectInterestActivityAdapterViewHolder>() {

    //dummy data
    private val selectInterestImages = intArrayOf(
        R.drawable.morning_rides,
        R.drawable.long_tour,
        R.drawable.offroading
    )

    //dummy data
    private val selectInterestText = intArrayOf(
        R.string.camping,
        R.string.trekking,
        R.string.biker_event
    )

    override fun getItemCount(): Int {
        return selectInterestImages.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SelectInterestActivityAdapterViewHolder {
        return SelectInterestActivityAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.select_interest_items,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SelectInterestActivityAdapterViewHolder, position: Int) {
        holder.tvInterestTitleType?.text = activity.getString(selectInterestText[position])
        holder.ivImage.setImageResource(selectInterestImages[position])          // setting interest bike image

        holder.itemView.setOnClickListener {
            Toast.makeText(activity, holder.tvInterestTitleType.text, Toast.LENGTH_SHORT).show()
        }
    }


    inner class SelectInterestActivityAdapterViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val tvInterestTitleType = view.cv_title
        var ivImage = view.cv_image
    }
}