package com.example.smartwindow

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)
        setSupportActionBar(toolbar)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        loadData()


        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tempView.text = progress.toString()
                saveData()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        seekBar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                humiView.text = progress.toString()
                saveData()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        seekBar3.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                dustView.text = progress.toString()
                saveData()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })



        switch1.setOnClickListener(View.OnClickListener { //switch 부분
            if (switch1.isChecked) {
                switchTrue()
            } else {
                switchFalse()
            }
        });
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        saveData()
    }



    private fun switchTrue() { ////switch 부분
        val pref = getSharedPreferences("pref", 0)
        val edit = pref.edit() //수정모드
        val database : FirebaseDatabase = FirebaseDatabase.getInstance()
        val myRef : DatabaseReference = database.getReference("conf")
        edit.putBoolean("switch",switch1.isChecked)
        myRef.child("auto").setValue(true)
        edit.apply();
    }

    private fun switchFalse() { ////switch 부분
        val pref = getSharedPreferences("pref", 0)
        val edit = pref.edit() //수정모드
        val database : FirebaseDatabase = FirebaseDatabase.getInstance()
        val myRef : DatabaseReference = database.getReference("conf")
        edit.putBoolean("switch",switch1.isChecked)
        myRef.child("auto").setValue(false)
        edit.apply();
    }

    private fun saveData() {
        val pref = getSharedPreferences("pref", 0)
        val edit = pref.edit() //수정모드
        val database : FirebaseDatabase = FirebaseDatabase.getInstance()
        val myRef : DatabaseReference = database.getReference("conf")
        val temp = tempView.text.toString()
        val humi = humiView.text.toString()
        val dust = dustView.text.toString()
        edit.putString("temp", temp)
        edit.putString("humi", humi)
        edit.putString("dust", dust)
        edit.putInt("seekbar", seekBar.progress)
        edit.putInt("seekbar2",seekBar2.progress)
        edit.apply() //저장완료
        myRef.child("temp").setValue(temp)
        myRef.child("humi").setValue(humi)
        myRef.child("dust").setValue(dust)
    }

    private fun loadData() {
        val pref = getSharedPreferences("pref", 0)
        tempView.text = pref.getString("temp","")
        humiView.text = pref.getString("humi", "")
        dustView.text = pref.getString("dust", "")
        seekBar.progress = pref.getInt("seekbar", 0)
        seekBar2.progress = pref.getInt("seekbar2", 0)
        switch1.isChecked = pref.getBoolean("switch", false)
    }



}