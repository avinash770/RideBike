package com.ridebike.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ridebike.R
import com.ridebike.adapter.FragmentSocialAdapter
import com.ridebike.views.MainHomeScreenActivity
import kotlinx.android.synthetic.main.home_view_content.*
import kotlinx.android.synthetic.main.common_header_home_screen.*
import kotlinx.android.synthetic.main.fragment_social_view.*

/**
 * Social Fragment
 */
class SocialFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_social_view,
            container, false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //setting groups radio button by default
        radio_groups.isChecked = true

        //setting header icons and visibility
        activity?.header_right_icon!!.visibility = View.INVISIBLE
        activity?.floating_add_icon!!.visibility = View.VISIBLE
        activity?.menu_icon!!.visibility = View.VISIBLE
        activity?.back_icon!!.visibility = View.GONE

        //setting adapter for your groups
        rv_your_group.layoutManager = LinearLayoutManager(context)
        rv_your_group.adapter = FragmentSocialAdapter()

        //setting adapter for nearby groups
        rv_nearby_group.layoutManager = LinearLayoutManager(context)
        rv_nearby_group.adapter = FragmentSocialAdapter()

    }

}