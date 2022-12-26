package com.example.smartwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CctvActivity extends AppCompatActivity {
    private ImageButton UpButton, DownButton, LeftButton, RightButton, btncall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cctv);
        UpButton = (ImageButton) findViewById(R.id.UpButton);
        DownButton = (ImageButton) findViewById(R.id.DownButton);
        LeftButton = (ImageButton) findViewById(R.id.LeftButton);
        RightButton = (ImageButton) findViewById(R.id.RightButton);
        btncall = (ImageButton) findViewById(R.id.btncall);




                UpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CctvActivity.this,"앞으로 이동",Toast.LENGTH_SHORT).show();
                OkHttpClient client=new OkHttpClient();
                Request request=new Request.Builder()
                        .url("http://172.111.73.199:5000/r_forward")
                        .build();
                client.newCall(request).enqueue(new Callback(){

                    @Override
                    public void onFailure(Call call, IOException e) {
                        call.cancel();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String myResponse=response.body().string();
                        CctvActivity.this.runOnUiThread(new Runnable(){

                            @Override
                            public void run() {
                                //cctvOffButton.setText(myResponse);

                            }
                        });
                    }
                });
            }
        });

        DownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CctvActivity.this,"아래쪽 이동",Toast.LENGTH_SHORT).show();
                OkHttpClient client=new OkHttpClient();
                Request request=new Request.Builder()
                        .url("http://172.111.73.199:5000/r_backward")
                        .build();
                client.newCall(request).enqueue(new Callback(){

                    @Override
                    public void onFailure(Call call, IOException e) {
                        call.cancel();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String myResponse=response.body().string();
                        CctvActivity.this.runOnUiThread(new Runnable(){

                            @Override
                            public void run() {
                                //cctvOffButton.setText(myResponse);

                            }
                        });
                    }
                });
            }
        });

        LeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CctvActivity.this,"왼쪽 이동",Toast.LENGTH_SHORT).show();
                OkHttpClient client=new OkHttpClient();
                Request request=new Request.Builder()
                        .url("http://172.111.73.199:5000/r_left")
                        .build();
                client.newCall(request).enqueue(new Callback(){

                    @Override
                    public void onFailure(Call call, IOException e) {
                        call.cancel();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String myResponse=response.body().string();
                        CctvActivity.this.runOnUiThread(new Runnable(){

                            @Override
                            public void run() {
                                //cctvOffButton.setText(myResponse);
                            }
                        });
                    }
                });
            }
        });

        RightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CctvActivity.this,"오른쪽 이동",Toast.LENGTH_SHORT).show();
                OkHttpClient client=new OkHttpClient();
                Request request=new Request.Builder()
                        .url("http://172.111.73.199:5000/r_right")
                        .build();
                client.newCall(request).enqueue(new Callback(){

                    @Override
                    public void onFailure(Call call, IOException e) {
                        call.cancel();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String myResponse=response.body().string();
                        CctvActivity.this.runOnUiThread(new Runnable(){

                            @Override
                            public void run() {
                                //cctvOffButton.setText(myResponse);

                            }
                        });
                    }
                });
            }
        });

        WebView myWebView = (WebView) findViewById(R.id.webView);
        // wide viewport를 사용하도록 설정
        myWebView.getSettings().setUseWideViewPort(true);

// 컨텐츠가 웹뷰보다 클 경우 스크린 크기에 맞게 조정
        myWebView.getSettings().setLoadWithOverviewMode(true);

//zoom 허용
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setSupportZoom(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("http://192.168.25.17:8091/?action=stream");


        
        btncall.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:119"));
                startActivity(intent);
            }
        });
    }
}
