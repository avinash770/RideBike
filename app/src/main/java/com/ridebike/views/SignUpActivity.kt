package com.ridebike.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.ridebike.R
import com.ridebike.utility.*

import kotlinx.android.synthetic.main.common_header.*

class SignUpActivity : AppCompatActivity(){

    private val TAG = (SignUpActivity::class.java).toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        initLayout()
    }

    private fun initLayout() {
        //setting click listener for login button
//        tv_register.setOnClickListener(View.OnClickListener {
//            if (et_name.text.toString().equals("", ignoreCase = true)) {
//                AppUtilsKotlin.showToast(this, resources.getString(R.string.name_alert));
//            } else if (et_email.text.toString().equals("", ignoreCase = true)) {
//                AppUtilsKotlin.showToast(this, resources.getString(R.string.email_alert));
//            } else if (et_mobile.text.toString().equals("", ignoreCase = true)) {
//                AppUtilsKotlin.showToast(this, resources.getString(R.string.mobile_alert));
//            } else if (et_password.text.toString().equals("", ignoreCase = true)) {
//                AppUtilsKotlin.showToast(this, resources.getString(R.string.password_alert));
//            } else {
//                Utility.showTag(TAG, "SignUp Request Sended")
//                if (et_password.text.toString().equals(et_confirm_password.text.toString())) {
//                      val keys = arrayOf(AppConstants.NAME, AppConstants.EMAIL,AppConstants.PASSWORD, AppConstants.MOBILE,AppConstants.DOB, AppConstants.BLOOD_GROUP)
//                    val values = arrayOf(et_name.text.toString(),et_email.text.toString(),et_password.text.toString(),et_mobile.text.toString(),"1991-10-14","0+")
//                    NetworkApiHelper(this).performRequest(
//                                             JsonHelper.getJsonRequest(keys,values)
//                                            , Holders.API_URL_REGISTER,
//                                            AppConstants.REQUEST_CODE_1
//                                        );
//                } else {
//                    AppUtilsKotlin.showToast(
//                        this,
//                        resources.getString(R.string.confirm_password_alert)
//                    );
//                }
//            }
//    })
        iv_back.setOnClickListener {
            finish()
        }
    }
}
