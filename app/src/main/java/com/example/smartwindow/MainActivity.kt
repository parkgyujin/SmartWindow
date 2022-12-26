package com.example.smartwindow

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.EditText
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Switch
import androidx.appcompat.widget.Toolbar
import com.android.volley.AuthFailureError
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray;
import org.json.JSONException
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt
import com.android.volley.*
import com.google.android.datatransport.runtime.util.PriorityMapping.toInt

class MainActivity : AppCompatActivity() {
    var readText: TextView? = null
    var writeEdit: EditText? = null
    var myToolbar: Toolbar? = null

    var requestQueue: RequestQueue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val readBtn = findViewById<Button>(R.id.read_btn)

        val openBtn = findViewById<Button>(R.id.openBtn)
        val closeBtn = findViewById<Button>(R.id.closeBtn)
        val stopBtn = findViewById<Button>(R.id.stopBtn)

        val windowstatus2 = findViewById<TextView>(R.id.windowstatus2)

        val temper = findViewById<TextView>(R.id.temper)
        val humidity = findViewById<TextView>(R.id.humidity)
        val dust = findViewById<TextView>(R.id.dust)
        val gasView = findViewById<TextView>(R.id.gasView)
        val rainView = findViewById<TextView>(R.id.rainView)

        val toolbar_Title = findViewById<TextView>(R.id.toolbar_title)

        val imageWindow1 = findViewById<ImageView>(R.id.imageWindow1)
        val imageWindow2 = findViewById<ImageView>(R.id.imageWindow2)


        val switch1 = findViewById<Switch>(R.id.switch1)



        //날씨데이터의 Null값
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(applicationContext)
        }


        openBtn.setOnClickListener(View.OnClickListener {
            switchSwap()
            val database: FirebaseDatabase = FirebaseDatabase.getInstance()
            val myRef: DatabaseReference = database.getReference("conf")
            myRef.child("ch").setValue("1")
            myRef.child("window_status").setValue("1")

            windowstatus2.text = "열려있습니다!"

            imageWindow1.setVisibility(View.VISIBLE)
            imageWindow2.setVisibility(View.INVISIBLE)
            imageWindow3.setVisibility(View.INVISIBLE)
        })
        closeBtn.setOnClickListener(View.OnClickListener {
            switchSwap()
            val database: FirebaseDatabase = FirebaseDatabase.getInstance()
            val myRef: DatabaseReference = database.getReference("conf")
            myRef.child("ch").setValue("2")
            myRef.child("window_status").setValue("0")

            windowstatus2.text = "닫혀있습니다!"

            imageWindow1.setVisibility(View.INVISIBLE)
            imageWindow2.setVisibility(View.VISIBLE)
            imageWindow3.setVisibility(View.INVISIBLE)
        })
        stopBtn.setOnClickListener(View.OnClickListener {
            switchSwap()
            val database: FirebaseDatabase = FirebaseDatabase.getInstance()
            val myRef: DatabaseReference = database.getReference("conf")
            myRef.child("ch").setValue("0")
            myRef.child("window_status").setValue("2")

            windowstatus2.text = "정지되었습니다!"

            imageWindow1.setVisibility(View.INVISIBLE)
            imageWindow2.setVisibility(View.INVISIBLE)
            imageWindow3.setVisibility(View.VISIBLE)
        })



        switch1.setOnClickListener(View.OnClickListener { //switch 부분
            if (switch1.isChecked) {
                switchTrue()

                val database: FirebaseDatabase = FirebaseDatabase.getInstance()
                val myRef: DatabaseReference = database.getReference("conf")

                myRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val status = dataSnapshot.child("window_status").getValue(String::class.java)

                        if (status == "0") {

                            windowstatus2.text = "닫혀있습니다!"

                            imageWindow1.setVisibility(View.INVISIBLE)
                            imageWindow2.setVisibility(View.VISIBLE)
                            imageWindow3.setVisibility(View.INVISIBLE)
                        }
                        else if(status == "1"){
                            windowstatus2.text = "열려있습니다!"

                            imageWindow1.setVisibility(View.VISIBLE)
                            imageWindow2.setVisibility(View.INVISIBLE)
                            imageWindow3.setVisibility(View.INVISIBLE)
                        }
                        else {
                            windowstatus2.text = "정지되었습니다!"

                            imageWindow1.setVisibility(View.INVISIBLE)
                            imageWindow2.setVisibility(View.INVISIBLE)
                            imageWindow3.setVisibility(View.VISIBLE)
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Failed to read value
                        temper.text = "error: " + error.toException()
                    }
                })
            }
            else {
                switchFalse()
            }
        });

        myToolbar = findViewById<View>(R.id.my_toolbar) as Toolbar
        setSupportActionBar(myToolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        readBtn.setOnClickListener {
            val intent = Intent(applicationContext, CctvActivity::class.java)
            startActivity(intent)
        }


        //현재시간 가져오기
        val now = System.currentTimeMillis()
        val date = Date(now)
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val getTime = sdf.format(date)

        //시간을 가져오는 TextView
        toolbar_Title.text = getTime


        //쓰기
        val database = FirebaseDatabase.getInstance()
        //DatabaseReference myRef = database.getReference("dht");
        val myRef = database.getReference("dht")
        // 읽기
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val dusts = dataSnapshot.child("ugm3").getValue(String::class.java)
                val temp = dataSnapshot.child("temp").getValue(String::class.java)
                val humi = dataSnapshot.child("humi").getValue(String::class.java)
                val gas = dataSnapshot.child("gas").getValue(String::class.java)
                val rain = dataSnapshot.child("rain").getValue(String::class.java)
                temper.text = "$temp°C"
                humidity.text = "$humi%"
                dust.text = dusts + "ug/m3" //dust로 대체 예정
                
                val gasint = Integer.parseInt(gas)
                val rainint = Integer.parseInt(rain)

                if(gasint > 330)
                    gasView.text = "감지됨"
                else
                    gasView.text = "정상"
                
                if(rainint < 800)
                    rainView.text = "감지됨"
                else
                    rainView.text = "정상"
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                temper.text = "error: " + error.toException()
            }
        })

    }

    override fun onStart() {
        super.onStart()
        //날씨를 받기
        CurrentCall()
        window()
    }

    private fun switchSwap() {
        val pref = getSharedPreferences("pref", 0)
        val edit = pref.edit()
        switch1.isChecked = false
        edit.putBoolean("switch",switch1.isChecked)
        edit.apply();

    }
    private fun switchTrue() { ////switch 부분
        val pref = getSharedPreferences("pref", 0)
        val edit = pref.edit() //수정모드
        val database : FirebaseDatabase = FirebaseDatabase.getInstance()
        val myRef : DatabaseReference = database.getReference("conf")
        edit.putBoolean("switch",switch1.isChecked)
        myRef.child("ch").setValue("3")
        edit.apply();
    }

    private fun switchFalse() { ////switch 부분
        val pref = getSharedPreferences("pref", 0)
        val edit = pref.edit() //수정모드
        val database : FirebaseDatabase = FirebaseDatabase.getInstance()
        val myRef : DatabaseReference = database.getReference("conf")
        edit.putBoolean("switch",switch1.isChecked)
        myRef.child("ch").setValue("4")
        edit.apply();
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        //return super.onCreateOptionsMenu(menu);
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //return super.onOptionsItemSelected(item);
        when (item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(applicationContext, SettingsActivity::class.java)
                startActivity(intent)
            }
        }
        return true
    }

    fun CurrentCall(){

        val cityView: TextView = findViewById(R.id.cityView)
        val weatherView: TextView = findViewById(R.id.weatherView)
        val tempView: TextView = findViewById(R.id.tempView)
        val heatText = findViewById<TextView>(R.id.heatText)

        val url = "https://api.openweathermap.org/data/2.5/weather?q=Seoul, KR,uk&APPID=bdc9150fa915f2970dda565e1e75047e"

        val request: StringRequest = @SuppressLint("SetTextI18n")
        object : StringRequest(Method.GET, url, Response.Listener
        { response ->
            try {

                //api로 받은 파일 jsonobject로 새로운 객체 선언
                val jsonObject = JSONObject(response)


                //도시 키값 받기
                val city = jsonObject.getString("name")
                cityView.text = "$city"


                //날씨 키값 받기
                val weatherJson = jsonObject.getJSONArray("weather")
                val weatherObj = weatherJson.getJSONObject(0)
                val weather = weatherObj.getString("description")
                weatherView.text = "$weather"


                //기온 키값 받기
                val tempK = JSONObject(jsonObject.getString("main"))

                //기온 받고 켈빈 온도를 섭씨 온도로 변경
                val tempDo = ((tempK.getDouble("temp") - 273.15) * 100).roundToInt() / 100.0
                val tempMax = ((tempK.getDouble("temp_max") - 273.15) * 100).roundToInt() / 100.0
                val tempMin = ((tempK.getDouble("temp_min") - 273.15) * 100).roundToInt() / 100.0

                tempView.text = "$tempDo°C"
                heatText.text = "$tempMax°C/$tempMin°C"


            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }, Response.ErrorListener { }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String> {
                return HashMap()
            }
        }

        request.setShouldCache(false)
        requestQueue!!.add(request)
    }
    
    fun window(){
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val myRef: DatabaseReference = database.getReference("conf")

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val status = dataSnapshot.child("window_status").getValue(String::class.java)

                if (status == "0") {

                    windowstatus2.text = "닫혀있습니다!"

                    imageWindow1.setVisibility(View.INVISIBLE)
                    imageWindow2.setVisibility(View.VISIBLE)
                    imageWindow3.setVisibility(View.INVISIBLE)
                }
                else if(status == "1"){
                    windowstatus2.text = "열려있습니다!"

                    imageWindow1.setVisibility(View.VISIBLE)
                    imageWindow2.setVisibility(View.INVISIBLE)
                    imageWindow3.setVisibility(View.INVISIBLE)
                }
                else {
                    windowstatus2.text = "정지되었습니다!"

                    imageWindow1.setVisibility(View.INVISIBLE)
                    imageWindow2.setVisibility(View.INVISIBLE)
                    imageWindow3.setVisibility(View.VISIBLE)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                temper.text = "error: " + error.toException()
            }
        })
    }

    override fun onStop() {
        super.onStop()
        //날씨를 받기
        CurrentCall()
    }
}