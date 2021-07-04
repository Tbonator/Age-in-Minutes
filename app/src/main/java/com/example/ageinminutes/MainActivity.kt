package com.example.ageinminutes

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ageinminutes.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDatePicker.setOnClickListener {
                view -> clickDatePicker(view)
            //Toast.makeText(this,"Button Works",Toast.LENGTH_LONG).show()
        }

        binding.secondActivityBtn.setOnClickListener {
            val intent = Intent(this,secondActivity::class.java)
            startActivity(intent)
        }


    }
    fun clickDatePicker(view: View) {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,DatePickerDialog.OnDateSetListener {
                view, selectedYear, selectedMonth, selectedDayOfMonth ->

            val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
            binding.tvSelectedDate.text = selectedDate

            val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)

            val theDate = simpleDateFormat.parse(selectedDate)

            val currentDate = simpleDateFormat.parse(simpleDateFormat.format(System.currentTimeMillis()))
            val selectedDateInMinutes = theDate!!.time / 60000
            val currentDateInMinutes = currentDate!!.time / 60000

            binding.tvSelectedDateInMinutes.text = (currentDateInMinutes - selectedDateInMinutes).toString()
        }
       ,year
       ,month
       ,day).show()

    }


}