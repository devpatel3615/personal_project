package com.example.all_e_paper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class The_Economic_Times extends AppCompatActivity {

    Button The_Economic_Times,live;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the__economic__times);
        this.setTitle("The Economic Times");

        //        AdMobe
//        MobileAds.initialize(this, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(InitializationStatus initializationStatus) {}
//        });
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this,"ca-app-pub-8391096929304342/8189514772", adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                // The mInterstitialAd reference will be null until
                // an ad is loaded.
                mInterstitialAd = interstitialAd;
//                Log.i(TAG, "onAdLoaded");
            }
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                // Handle the error
//                Log.i(TAG, loadAdError.getMessage());
                mInterstitialAd = null;
            }
        });

        live = findViewById(R.id.live);
        live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://economictimes.indiatimes.com/");
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(The_Economic_Times.this);
                } else {
                    //Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }
            }
        });
        The_Economic_Times = findViewById(R.id.The_Economic_Times);
        The_Economic_Times.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("http://www.epaper-hub.com/india/economic-times.aspx");
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(The_Economic_Times.this);
                } else {
                    //Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }
            }
        });
    }
    private void gotoUrl(String s)
    {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}