package com.ridebike.views

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ridebike.R
import com.ridebike.adapter.AddFriendsAdapter
import kotlinx.android.synthetic.main.activity_add_friends.*
import kotlinx.android.synthetic.main.add_friends_adapter_item.*
import kotlinx.android.synthetic.main.common_button_layout.*
import kotlinx.android.synthetic.main.common_header.*

/**
 * Class used to add friends from contacts
 */
class AddFriendsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_friends)
        init()
    }

    /**
     * Init method
     */
    private fun init() {
        common_button_text.setText(R.string.next)
        tv_heading.setText(R.string.add_friends)

        //setting adapter
        rv_add_friends.layoutManager = LinearLayoutManager(this)
        rv_add_friends.adapter = AddFriendsAdapter(this)

        //listener for back icon
        iv_back.setOnClickListener {
            finish()
        }

        //skip button listener
        tv_skip.setOnClickListener {
            startActivity(Intent(this, JoinGroupActivity::class.java))
        }

        //listener for next button
        common_button_text.setOnClickListener {
            startActivity(Intent(this, JoinGroupActivity::class.java))
        }

        //listener for select all
        tv_select_all.setOnClickListener {
            cb_friend_selected.isChecked = true
        }
    }
}
