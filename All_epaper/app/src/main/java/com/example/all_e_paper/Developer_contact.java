package com.example.all_e_paper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class Developer_contact extends AppCompatActivity {
//    InterstitialAd mInterstitialAd;

    ImageView gmail,telegram;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_contact);
        setTitle("Support Development");

        gmail=findViewById(R.id.gmail);
        telegram=findViewById(R.id.telegram);
        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent((Intent.ACTION_SENDTO));
                String uriText ="mailto:" + Uri.encode("devrpatel0201@gmail.com")+"?subject="+
                        Uri.encode("All ")+"E-paper"+Uri.encode("");
                Uri uri=Uri.parse(uriText);
                intent.setData(uri);
                startActivity(Intent.createChooser(intent,"Send email"));
            }
        });
        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://t.me/DevPatel3615");

            }
        });

    }
    private void gotoUrl(String s)
    {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}