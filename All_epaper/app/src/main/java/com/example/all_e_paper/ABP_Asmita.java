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

public class ABP_Asmita extends AppCompatActivity {
    Button gujarati_news,surat_news,ahmedabad_news,vadodra_news,rajkot_news;
    InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_b_p__asmita);
        this.setTitle("ABP Asmita");

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

        gujarati_news = findViewById(R.id.gujarati_news);
        gujarati_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://gujarati.abplive.com/live-tv");
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ABP_Asmita.this);
                } else {
                    //Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }
            }
        });
        surat_news = findViewById(R.id.surat_news);
        surat_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://gujarati.abplive.com/news/surat");
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ABP_Asmita.this);
                } else {
                    //Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }
            }
        });
        ahmedabad_news = findViewById(R.id.ahmedabad_news);
        ahmedabad_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://gujarati.abplive.com/news/ahmedabad");
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ABP_Asmita.this);
                } else {
                    //Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }
            }
        });
        vadodra_news = findViewById(R.id.vadodra_news);
        vadodra_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://gujarati.abplive.com/news/vadodara");
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ABP_Asmita.this);
                } else {
                    //Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }
            }
        });
        rajkot_news = findViewById(R.id.rajkot_news);
        rajkot_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://gujarati.abplive.com/news/rajkot");
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ABP_Asmita.this);
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