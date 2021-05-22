package com.ridebike.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ridebike.R
import com.ridebike.adapter.FragmentProfileAdapter
import kotlinx.android.synthetic.main.common_header_home_screen.*
import kotlinx.android.synthetic.main.fragment_profile_view.*
import kotlinx.android.synthetic.main.home_view_content.*
import java.util.*


/**
 * Profile Fragment
 */
class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_profile_view,
            container, false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //setting header icons and visibility
        activity?.header_right_icon!!.visibility = View.VISIBLE
        activity?.header_right_icon!!.setText(R.string.bell_icon)
        activity?.menu_icon!!.setText(R.string.home_header_menu_icon)
        activity?.floating_add_icon!!.visibility = View.GONE
        activity?.menu_icon!!.visibility = View.VISIBLE
        activity?.back_icon!!.visibility = View.GONE
//        profile_name.text = PreferenceUtils.getName().toString().toUpperCase(Locale.getDefault())

        //setting adapter
        rv_profile_list.layoutManager = LinearLayoutManager(context)
        rv_profile_list.adapter = FragmentProfileAdapter()

    }
}