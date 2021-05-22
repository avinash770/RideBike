package com.ridebike.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ridebike.R
import com.ridebike.adapter.AddFriendsAdapter
import kotlinx.android.synthetic.main.activity_create_group.*
import kotlinx.android.synthetic.main.common_button_layout.*
import kotlinx.android.synthetic.main.common_header.*
import kotlinx.android.synthetic.main.create_group_adapter_view.*

/**
 * Activity used to create a group
 */
class CreateGroupActivity : BaseActivity(), View.OnClickListener {

    private var TAG = "CreateGroupActivity"

    private var mainViewOpen: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_group)

        init()
        settingSpinnerData()
        llProgressBar.visibility = View.GONE
    }


    /**
     * Used to set spinner items
     */
    private fun settingSpinnerData() {

        val state =
            arrayOf(
                resources.getString(R.string.state_one),
                resources.getString(R.string.state_two)
            )

        val adapterState = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            state
        )

        val city =
            arrayOf(
                resources.getString(R.string.state_one),
                resources.getString(R.string.state_three)
            )

        val adapterCity = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            city
        )

        state_spinner.setSelection(0)
        state_spinner.adapter = adapterState
        city_spinner.setSelection(0)
        city_spinner.adapter = adapterCity
    }

    private fun init() {
        common_button_text.setText(R.string.next)
        tv_heading.setText(R.string.create_a_group)
        tv_skip.visibility = View.INVISIBLE

        //setting adapter
        rv_schedule_ride_friends.layoutManager = LinearLayoutManager(this)
        rv_schedule_ride_friends.adapter = AddFriendsAdapter(this)


        //listener for back icon
        iv_back.setOnClickListener(this)

        //listener for next button
        common_button_text.setOnClickListener(this)
    }

    /**
     * Implementing onClick listener
     */
    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.iv_back -> {
                if (!mainViewOpen) {
                    create_group_adapter_view.visibility = View.GONE
                    schedule_ride_main_view.visibility = View.VISIBLE
                    common_button_text.setText(R.string.next)
                    mainViewOpen = true

                } else finish()
            }

            R.id.common_button_text -> {
                if (mainViewOpen) {
                    schedule_ride_main_view.visibility = View.GONE
                    create_group_adapter_view.visibility = View.VISIBLE
                    common_button_text.setText(R.string.save)

                    mainViewOpen = false

                } else {
                    startActivity(Intent(this, MainHomeScreenActivity::class.java))
                }
            }
        }
    }
}
