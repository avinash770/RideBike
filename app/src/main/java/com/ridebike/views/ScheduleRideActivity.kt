package com.ridebike.views

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.DatePicker
import androidx.recyclerview.widget.LinearLayoutManager
import com.ridebike.R
import com.ridebike.adapter.AddFriendsAdapter
import com.ridebike.utility.*
import kotlinx.android.synthetic.main.activity_schedule_ride.*
import kotlinx.android.synthetic.main.common_button_layout.*
import kotlinx.android.synthetic.main.common_header.*
import kotlinx.android.synthetic.main.schedule_ride_adapter_view.*
import kotlinx.android.synthetic.main.schedule_ride_halt_layout.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Activity used to schedule a ride
 */
class ScheduleRideActivity : BaseActivity() {

    var cal = Calendar.getInstance()
    private var mainViewOpen: Boolean = true
    private var addHaltOpen: Boolean = false

    //val progressDialog = ProgressDialog(this@ScheduleRideActivity)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_ride)

        init()
        //setting radio buttons by default
        radio_single.isChecked = true
        radio_friends.isChecked = true
        radio_private.isChecked = true
        settingSpinnerData()
//        initData()
        initDatePicker();
        llProgressBar.visibility = View.GONE
    }

    private fun initDatePicker() {
        // create an OnDateSetListener
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//                updateDateInView()
            }
        rl_start_date.setOnClickListener {
            DatePickerDialog(
                this@ScheduleRideActivity,
                dateSetListener,
                // set DatePickerDialog to point to today's date when it loads up
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        val dateSetListenerEndDate = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(
                view: DatePicker, year: Int, monthOfYear: Int,
                dayOfMonth: Int
            ) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//                updateDateInViewEndDate()
            }
        }
        rl_end_date.setOnClickListener {
            DatePickerDialog(
                this@ScheduleRideActivity,
                dateSetListenerEndDate,
                // set DatePickerDialog to point to today's date when it loads up
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        rl_start_time.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                start_time.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }
        rl_end_time.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                end_time.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }

    }


    /**
     * Used to set spinner items
     */
    private fun settingSpinnerData() {

        val trip =
            arrayOf("One way", "Two way")

        val adapterTrip = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            trip
        )

        vehicle_spinner.setSelection(0)
        year_spinner.setSelection(0)

        year_spinner.adapter = adapterTrip
    }

    private fun init() {
        common_button_text.setText(R.string.next)
        tv_heading.setText(R.string.schedule_a_ride)
        tv_skip.visibility = View.INVISIBLE
        tv_skip.setText("Trips History")

        //setting adapter
        rv_schedule_ride_friends.layoutManager = LinearLayoutManager(this)
        rv_schedule_ride_friends.adapter = AddFriendsAdapter(this)


        //listener for back icon
        iv_back.setOnClickListener {
            if (!addHaltOpen && !mainViewOpen) {
                schedule_ride_adapter_view.visibility = View.GONE
                schedule_ride_halt_layout.visibility = View.VISIBLE
                common_button_text.setText(R.string.next)
                mainViewOpen = false
                addHaltOpen = true
            } else if (addHaltOpen && !mainViewOpen) {
                schedule_ride_halt_layout.visibility = View.GONE
                schedule_ride_main_view.visibility = View.VISIBLE
                common_button_text.setText(R.string.next)
                mainViewOpen = true
                addHaltOpen = false
            } else finish()
        }

        //setting listener on radio button
        radio_is_single_day.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId == R.id.radio_single) {
                ll_end_date_time.visibility = View.GONE
            } else if (checkedId == R.id.radio_more_than_a_day) {
                ll_end_date_time.visibility = View.VISIBLE
            }
        }

        //listener for next button
        common_button_text.setOnClickListener {
                     startActivity(Intent(this, MainHomeScreenActivity::class.java))

            }


        }
    }
