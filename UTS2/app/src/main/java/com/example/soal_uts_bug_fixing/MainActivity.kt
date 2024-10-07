package com.example.soal_uts_bug_fixing

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.soal_uts_bug_fixing.databinding.ActivityMainBinding

import android.app.TimePickerDialog
import android.widget.Button
import android.widget.TextView
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment)

        // Inisialisasi button dan textView
        val pilihWaktuButton = findViewById<Button>(R.id.timer_button)
        val waktuTextView = findViewById<TextView>(R.id.timer_txt)

        // Set OnClickListener untuk button "Pilih Waktu Pertemuan"
        pilihWaktuButton.setOnClickListener {
            // Mendapatkan waktu saat ini
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            // Membuat TimePickerDialog
            val timePickerDialog = TimePickerDialog(this,
                { _, selectedHour, selectedMinute ->
                    // Set waktu yang dipilih ke TextView
                    waktuTextView.text = String.format("%02d:%02d", selectedHour, selectedMinute)
                }, hour, minute, true)

            // Menampilkan TimePickerDialog
            timePickerDialog.show()
        }
    }
}

