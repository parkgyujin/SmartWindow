package com.example.smartwindow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView readText;

    EditText writeEdit;

    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button readBtn = findViewById(R.id.read_btn);

        TextView temper = findViewById(R.id.temper);
        TextView humidity = findViewById(R.id.humidity);
        TextView dust = findViewById(R.id.dust);
        TextView gasView = findViewById(R.id.gasView);
        TextView rainView = findViewById(R.id.rainView);

        TextView toolbar_Title = findViewById(R.id.toolbar_title);




        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        
        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CctvActivity.class);
                startActivity(intent);
            }
        });


        //현재시간 가져오기
        long now = System.currentTimeMillis();
        Date date = new Date(now);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String getTime =sdf.format(date);

        //시간을 가져오는 TextView
        toolbar_Title.setText(getTime);


                //쓰기
        FirebaseDatabase database = FirebaseDatabase.getInstance();
                //DatabaseReference myRef = database.getReference("dht");
        DatabaseReference myRef = database.getReference("dht");
                // 읽기
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String heat = dataSnapshot.child("heat").getValue(String.class);
                String temp = dataSnapshot.child("temp").getValue(String.class);
                String humi = dataSnapshot.child("humi").getValue(String.class);
                String gas = dataSnapshot.child("gas").getValue(String.class);
                String rain = dataSnapshot.child("rain").getValue(String.class);

                temper.setText(temp +"°C");
                humidity.setText(humi +"%");
                dust.setText(heat+"ug/m3");//dust로 대체 예정
                gasView.setText(gas);
                rainView.setText(rain);

            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                temper.setText("error: " + error.toException());
                    }
            });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.action_settings:

                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent);

        }
        return true;
    }


}