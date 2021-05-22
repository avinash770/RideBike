package com.ridebike.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ridebike.R
import com.ridebike.adapter.FragmentHomeAdapter
import com.ridebike.adapter.HomeViewCheckboxAdapter
import kotlinx.android.synthetic.main.home_view_content.*
import kotlinx.android.synthetic.main.common_header_home_screen.*
import kotlinx.android.synthetic.main.fragment_home_view.*

/**
 * Home Fragment
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_home_view,
            container, false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //setting header icons and visibility
        activity?.header_right_icon!!.visibility = View.VISIBLE
        activity?.header_right_icon!!.setText(R.string.search_icon)
        activity?.floating_add_icon!!.visibility = View.VISIBLE
        activity?.menu_icon!!.visibility = View.VISIBLE
        activity?.back_icon!!.visibility = View.GONE

        //setting adapter
        rv_home_view.layoutManager = LinearLayoutManager(context)
        rv_home_view.adapter = FragmentHomeAdapter()

        //setting checkbox adapter
        rv_home_view_checkbox.layoutManager = LinearLayoutManager(context)
        rv_home_view_checkbox.adapter = HomeViewCheckboxAdapter()
        rv_home_view_checkbox.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
    }
}