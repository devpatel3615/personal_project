package com.example.all_e_paper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class N0_internet extends AppCompatActivity {

    WebView webview;
    Button referesh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0_internet);
        setTitle("All e-paper");

        //Assign variable
        webview =findViewById(R.id.web_view);
        getSupportActionBar().hide();
        //Initialize websetting
        WebSettings webSettings=webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //Initialize ConnectivityManager
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        //get active network info
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        //Check Network Status
        if(networkInfo==null || !networkInfo.isConnected() || !networkInfo.isAvailable())
        {
            //When internet is inactive
            // initialize dialog
            Dialog dialog = new Dialog(this);
            //set content view
            dialog.setContentView(R.layout.alert_dialog);
            // set Outside touch
            dialog.setCanceledOnTouchOutside(false);
            //set dialog widht and height
            dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT);
//            set transparent background
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            set Animation
            dialog.getWindow().getAttributes().windowAnimations=
                    android.R.style.Animation_Dialog;
            //Initalize dialog variable
            Button btTryAgain =dialog.findViewById(R.id.bt_try_again);
            //Perform onlick listener
            btTryAgain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Call recreate method
                    recreate();
                }
            });
            //Show dialog
            dialog.show();
        }
        else
        {
            Thread th=new Thread()
            {
                public void run()
                {
                    try
                    {
                        Thread.sleep(300);

                    }
                    catch (Exception e)
                    {

                    }
                    finally
                    {
                        Intent i=new Intent(N0_internet.this,Choise_Language_Paper.class);
                        startActivity(i);
                    }
                }
            };
            th.start();
            // webview.loadUrl("https://www.youtube.com/");
        }
    }
}