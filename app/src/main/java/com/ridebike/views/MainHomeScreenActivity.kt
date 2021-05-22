package com.ridebike.views

import android.animation.AnimatorListenerAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.google.android.material.internal.NavigationMenuView
import com.ridebike.R
import com.ridebike.fragment.HomeFragment
import com.ridebike.fragment.LiveViewFragment
import com.ridebike.fragment.ProfileFragment
import com.ridebike.fragment.SocialFragment
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.bottom_nav_bar_view.*
import kotlinx.android.synthetic.main.common_header_home_screen.*
import kotlinx.android.synthetic.main.floating_action_button.*
import kotlinx.android.synthetic.main.home_view_content.*

/**
 * This is the main home screen/landing page after add group activity.
 * All fragments are handled in this activity.
 */
class MainHomeScreenActivity : BaseActivity(), View.OnClickListener {

    private var isFabOpen = false
    private var rotateForward: Animation? = null
    private var rotateBackward: Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //adding dividing line on navigation drawer
        val navMenuView = nav_view.getChildAt(0) as NavigationMenuView
        navMenuView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

        //open navigation drawer on menu click
        menu_icon.setOnClickListener(this)

        //handling add button animation
        handleFloatingButtonAnimation()

        //loading the default fragment
        loadFragment(HomeFragment())

        //setting listener on bottom navigation to load fragments
        bottom_navigation_menu.setItemSelected(R.id.home, true)
        bottom_navigation_menu.setOnItemSelectedListener { id ->

            when (id) {
                R.id.home -> loadFragment(HomeFragment())
                R.id.social -> loadFragment(SocialFragment())
                R.id.live_view -> loadFragment(LiveViewFragment())
                R.id.discover -> loadFragment(ProfileFragment())
            }
        }
        //setting click listener for schedule ride
        schedule_ride.setOnClickListener(this)

        // setting click listener for create group
        create_group.setOnClickListener(this)

        try {
            val position: String? = intent.getStringExtra("position")
            if (position == "4") {
                bottom_navigation_menu.setItemSelected(R.id.discover, true)
            }
        } catch (ex: Exception) {

        }
//        initPermission();
    }


    /**
     * Method used to handle animation on floating add button
     */
    private fun handleFloatingButtonAnimation() {

        rotateForward = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.rotate_forward
        )
        rotateBackward = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.rotate_backward
        )

        add_icon.setOnClickListener(this)
    }

    /**
     * Method used to animate floating add button
     */
    private fun animateFAB() {
        if (isFabOpen) {
            shadowView.visibility = View.GONE

            showOut(create_group)
            showOut(schedule_ride)
            showOut(create_post)
            add_icon!!.startAnimation(rotateBackward)

            create_group.isClickable = false
            schedule_ride.isClickable = false
            create_post.isClickable = false

            isFabOpen = false
        } else {
            shadowView.visibility = View.VISIBLE
            shadowView.setOnClickListener(null)

            showIn(create_group)
            showIn(schedule_ride)
            showIn(create_post)
            add_icon!!.startAnimation(rotateForward)
            create_group.isClickable = true
            schedule_ride.isClickable = true
            create_post.isClickable = true

            isFabOpen = true
        }
    }

    /**
     * Method used to handle animation on floating add button items
     */
    private fun showIn(view: View?) {
        view!!.visibility = View.VISIBLE
        view.alpha = 0f
        view.translationY = view.height.toFloat()
        view.animate()
            .setDuration(300)
            .translationY(0f)
            .setListener(object : AnimatorListenerAdapter() {
            })
            .alpha(1f)
            .start()
    }

    /**
     * Method used to handle animation on floating add button items
     */
    private fun showOut(view: View?) {
        view!!.visibility = View.VISIBLE
        view.alpha = 1f
        view.translationY = 0f
        view.animate()
            .setDuration(300)
            .translationY(view.height.toFloat())
            .setListener(object : AnimatorListenerAdapter() {
            })
            .alpha(0f)
            .start()
    }

    /**
     * Method used to load fragments on bottom navigation click
     */
    private fun loadFragment(fragment: Fragment?): Boolean { //switching fragment
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
            return true
        }
        return false
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.menu_icon -> {
                drawer_layout.openDrawer(GravityCompat.START)
            }

            R.id.schedule_ride -> {
                startActivity(Intent(this, ScheduleRideActivity::class.java))
                animateFAB()
            }

            R.id.create_group -> {
                startActivity(Intent(this, CreateGroupActivity::class.java))
                animateFAB()
            }

            R.id.add_icon -> {
                animateFAB()
            }

        }
    }
}
