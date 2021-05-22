package com.ridebike.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ridebike.R
import com.ridebike.adapter.JoinGroupAdapter
import kotlinx.android.synthetic.main.activity_join_group.*
import kotlinx.android.synthetic.main.common_button_layout.*
import kotlinx.android.synthetic.main.common_header.*

/**
 * Class used to join different groups
 */
class JoinGroupActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_group)

        init()
    }

    /**
     * Init method
     */
    private fun init() {
        common_button_text.setText(R.string.next)
        tv_heading.setText(R.string.join_group_heading)

        //back button listener
        iv_back.setOnClickListener {
            finish()
        }

        //skip button listener
        tv_skip.setOnClickListener {
            startActivity(Intent(this, MainHomeScreenActivity::class.java))
        }

        //setting adapter
        rv_join_group.layoutManager = LinearLayoutManager(this)
        rv_join_group.adapter = JoinGroupAdapter(this)

        //next button listener
        common_button_text.setOnClickListener {
            startActivity(Intent(this, MainHomeScreenActivity::class.java))
        }
    }
}