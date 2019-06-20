package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Year
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAge.setOnClickListener {
            /*  var dob = editAge.text.toString().toInt()
            var cyear = Calendar.getInstance().get(Calendar.YEAR)
            var age = cyear - dob
            txtAge.text = "${txtAge.text.toString()}: $age"*/

            var dateOB = editAge.text.toString()
            var arr = dateOB.split("/")
            var days: Int
            var months: Int
            var years: Int = 0
            var omonths: Int = 0
            var cday = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
            var cmonth = Calendar.getInstance().get(Calendar.MONTH)+1
            var cyear = Calendar.getInstance().get(Calendar.YEAR)

            if(cday - arr[0].toInt() >= 0)
            {
                days = cday - arr[0].toInt()
            }
            else
            {
                days = cday + 30 - arr[0].toInt()
                if(cmonth%2==0)
                    days+=1
                omonths-=1
            }

            if (cmonth - arr[1].toInt() >= 0) {
                months = cmonth - arr[1].toInt() + omonths
            }
            else
            {
                months = cmonth + 12 - arr[1].toInt() + omonths
                years-=1
            }

            years+=(cyear-arr[2].toInt())

            txtAge.text = "${days} days:${months} months:${years} years"
        }
    }
}
