package com.ridebike.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.ridebike.R
import com.ridebike.adapter.SelectInterestActivityAdapter
import kotlinx.android.synthetic.main.activity_select_interest_acitvity.*
import kotlinx.android.synthetic.main.common_button_layout.*
import kotlinx.android.synthetic.main.common_header.*

/**
 * Class used for select interest activity view
 */
class SelectInterestActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_interest_acitvity)
        init()

        //click listener for back icon
        iv_back.visibility = View.INVISIBLE
        iv_back.setOnClickListener {
            finish()
        }
        tv_skip.setOnClickListener {
            startActivity(Intent(this, VehicleDetailsActivity::class.java))
        }

        //handling click listener for next button
        common_button_text.setOnClickListener {
            startActivity(Intent(this, VehicleDetailsActivity::class.java))
        }
    }

    /**
     * Init method
     */
    private fun init() {
        common_button_text.setText(R.string.next)
        tv_heading.setText(R.string.select_interest_heading)

        //setting adapter
        rv_select_activity.layoutManager = GridLayoutManager(this, 3)
        rv_select_activity.adapter = SelectInterestActivityAdapter(this)
    }


}
