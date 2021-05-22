package com.ridebike.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ridebike.R
import kotlinx.android.synthetic.main.home_view_content.*
import kotlinx.android.synthetic.main.common_header_home_screen.*

/**
 * Live view fragment with map
 * Coming SOON
 */
class LiveViewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_live_view,
            container, false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //setting header icons and visibility
        activity?.header_right_icon!!.visibility = View.INVISIBLE
        activity?.floating_add_icon!!.visibility = View.GONE
        activity?.menu_icon!!.visibility = View.VISIBLE
        activity?.back_icon!!.visibility = View.GONE

    }
}