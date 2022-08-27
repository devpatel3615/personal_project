package com.example.all_e_paper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            setTitle("All e-paper");



            checkConnection();
//        Thread th=new Thread()
//        {
//            public void run()
//            {
//                try
//                {
//                    Thread.sleep(3000);
//                }
//                catch (Exception e)
//                {
//
//                }
//                finally
//                {
//
//                    Intent i=new Intent(MainActivity.this,Choise_Language_Paper.class);
//                    startActivity(i);
//                }
//            }
//        };
//        th.start();
    }
    public void checkConnection()
    {
        ConnectivityManager manager=(ConnectivityManager)
                getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo acticeNetwork=manager.getActiveNetworkInfo();

        if(null!=acticeNetwork) {
            if (acticeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
//                Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(MainActivity.this,Choise_Language_Paper.class);
                startActivity(i);
            }
            if (acticeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
//                Toast.makeText(this, "Data", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(MainActivity.this,Choise_Language_Paper.class);
                startActivity(i);
            }
        }
        else{
            Toast.makeText(this, "No internet connection , Please check your Network", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(MainActivity.this,N0_internet.class);
            startActivity(i);
        }
        finish();
    }

}