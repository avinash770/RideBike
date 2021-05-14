package com.ridebike.views

import android.animation.Animator
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewTreeObserver
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import androidx.appcompat.widget.AppCompatEditText
import com.ridebike.R
import com.ridebike.utility.AppConstants
import com.ridebike.utility.AppConstants.Constant.LOGIN_SIGNUP_ALPHA_DURATION
import kotlinx.android.synthetic.main.login_view.*
import kotlinx.android.synthetic.main.signup_view.*
import kotlinx.android.synthetic.main.splash_screen.*
import java.util.*

/**
 * Class used for splash screen and login view
 */
class SplashScreenActivity : BaseActivity() {

    var width: Int = 0
    var height: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        llProgressBar.visibility = View.GONE
        init()

        //setting click listener for login button
        tv_login_button.setOnClickListener {
            startActivity(Intent(this, SelectInterestActivity::class.java))
        }

        ///handling bike logo
        handleBikeLogoAnimation()

        //sign up
        handleLoginSignupListener()
    }

    /**
     * Init method
     */
    private fun init() {
        //calculating height width to translate bike logo
        width = Resources.getSystem().displayMetrics.widthPixels
        height = Resources.getSystem().displayMetrics.heightPixels
        splash_bottom_view_login.translationY = height.toFloat()

        //setting logo view initial position to center of screen for splash
        val vto: ViewTreeObserver = logo_view.viewTreeObserver
        vto.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                logo_view.viewTreeObserver.removeOnGlobalLayoutListener(this)
                val width: Int = logo_view.measuredWidth
                val heightView: Int = logo_view.measuredHeight
                logo_view.translationY = (height - heightView) / 2f
                iv_bike_logo.translationX = -width.toFloat()
            }
        })
        passwordHideShow(et_password)
        passwordHideShow(et_password_sign_up)

        //setting alpha for login and signup view
        splash_bottom_view_sign_up.animate().alpha(0.0f)
        splash_bottom_view_login.animate().alpha(1.0f)
    }

    /**
     * Used to hide/show password field
     */
    @SuppressLint("ClickableViewAccessibility")
    private fun passwordHideShow(passwordView: AppCompatEditText) {
        passwordView.setOnTouchListener(OnTouchListener { v, event ->
            val DRAWABLE_RIGHT = 2
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= passwordView.right - passwordView.compoundDrawables[DRAWABLE_RIGHT].bounds.width()
                ) {
                    if (passwordView.inputType == 129) {
                        passwordView.inputType = 145
                        passwordView.setCompoundDrawablesWithIntrinsicBounds(
                            0,
                            0,
                            R.drawable.ic_password_invisible,
                            0
                        )
                    } else {
                        passwordView.inputType = 129
                        passwordView.setCompoundDrawablesWithIntrinsicBounds(
                            0,
                            0,
                            R.drawable.ic_password_visibility,
                            0
                        )
                    }
                    passwordView.setSelection(passwordView.length())
                    return@OnTouchListener true
                }
            }
            false
        })
    }


    /**
     * Setting on click listener for login and signup button
     */
    private fun handleLoginSignupListener() {

        tv_signup.setOnClickListener {
            splash_bottom_view_login.animate().alpha(0.0f).duration =
                AppConstants.LOGIN_SIGNUP_ALPHA_DURATION

            splash_bottom_view_login.visibility = View.GONE
            splash_bottom_view_sign_up.visibility = View.VISIBLE
            splash_bottom_view_sign_up.animate().alpha(1.0f).duration =
                AppConstants.LOGIN_SIGNUP_ALPHA_DURATION
            handleBikeAnimationOnLoginSignup()
        }

        tv_login.setOnClickListener {
            splash_bottom_view_sign_up.animate().alpha(0.0f).duration =
                AppConstants.LOGIN_SIGNUP_ALPHA_DURATION

            splash_bottom_view_sign_up.visibility = View.GONE
            splash_bottom_view_login.visibility = View.VISIBLE
            splash_bottom_view_login.animate().alpha(1.0f).duration = LOGIN_SIGNUP_ALPHA_DURATION
            handleBikeAnimationOnLoginSignup()
        }
    }

    /**
     * Used to handle logo animation on login and signup click
     */
    private fun handleBikeAnimationOnLoginSignup() {

        ObjectAnimator.ofFloat(iv_bike_logo, "translationX", width.toFloat()).apply {
            duration = AppConstants.LOGO_ANIMATION_DURATION
            start()

            addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {
                }

                override fun onAnimationEnd(animation: Animator?) {
                    iv_bike_logo.translationX = -width.toFloat()
                    ObjectAnimator.ofFloat(iv_bike_logo, "translationX", 0f).apply {
                        duration = AppConstants.LOGO_ANIMATION_DURATION
                        start()
                    }
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {
                }
            })
        }
    }


    /**
     * Used to handle bike logo animation translations
     */
    private fun handleBikeLogoAnimation() {

        //Bike logo coming at center
        ObjectAnimator.ofFloat(iv_bike_logo, "translationX", 0f).apply {
            duration = AppConstants.LOGO_ANIMATION_DURATION
            startDelay = AppConstants.LOGO_ANIMATION_DURATION * 2
            start()

            addListener(object : Animator.AnimatorListener {
                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationRepeat(animation: Animator?) {
                }

                override fun onAnimationEnd(animation: Animator?) {

                    //bike logo going out
                    ObjectAnimator.ofFloat(iv_bike_logo, "translationX", width.toFloat())
                        .apply {
                            duration = AppConstants.LOGO_ANIMATION_DURATION
                            startDelay = AppConstants.LOGO_ANIMATION_DURATION
                            start()
                            addListener(object : Animator.AnimatorListener {
                                override fun onAnimationRepeat(animation: Animator?) {
                                }

                                override fun onAnimationEnd(animation: Animator?) {

                                    //setting bike logo again to back
                                    iv_bike_logo.translationX = -width.toFloat()

                                    //moving logo view to upside
                                    ObjectAnimator.ofFloat(logo_view, "translationY", 0f)
                                        .apply {
                                            duration = AppConstants.LOGO_VIEW_TRANSLATE_DURATION
                                            start()

                                            addListener(object : Animator.AnimatorListener {
                                                override fun onAnimationRepeat(animation: Animator?) {

                                                }

                                                override fun onAnimationEnd(animation: Animator?) {

                                                    //bike logo coming at center
                                                    ObjectAnimator.ofFloat(
                                                        iv_bike_logo,
                                                        "translationX",
                                                        0f
                                                    ).apply {
                                                        duration =
                                                            AppConstants.LOGO_ANIMATION_DURATION
                                                        start()
                                                    }

                                                    //login view coming bottom to up
                                                    ObjectAnimator.ofFloat(
                                                        splash_bottom_view_login,
                                                        "translationY",
                                                        0f
                                                    ).apply {
                                                        duration =
                                                            AppConstants.LOGO_ANIMATION_DURATION * 2
                                                        start()
                                                    }
                                                }

                                                override fun onAnimationCancel(animation: Animator?) {
                                                }

                                                override fun onAnimationStart(animation: Animator?) {

                                                }
                                            })
                                        }
                                }

                                override fun onAnimationCancel(animation: Animator?) {
                                }

                                override fun onAnimationStart(animation: Animator?) {
                                }
                            })
                        }
                }

                override fun onAnimationStart(animation: Animator?) {
                }
            })
        }
    }
}
