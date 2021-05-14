package com.ridebike.views

import android.content.Intent
import android.os.Bundle
import com.ridebike.R
import kotlinx.android.synthetic.main.common_button_layout.*
import kotlinx.android.synthetic.main.common_header.*


/**
 * Class used for vehicle details page
 */
class VehicleDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_details)
        init()

        //setting listener for back icon
        iv_back.setOnClickListener {
            finish()
        }

        //skip button listener
        tv_skip.setOnClickListener {
            startActivity(Intent(this, AddFriendsActivity::class.java))
        }

        //setting listener for next button
        common_button_text.setOnClickListener {
            startActivity(Intent(this, AddFriendsActivity::class.java))
        }
    }

    /**
     * Init method
     */
    private fun init() {
        common_button_text.setText(R.string.next)
        tv_heading.setText(R.string.vehicle_detail_heading)
    }
}
