package com.example.all_e_paper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class All_Hindi_News extends AppCompatActivity {
    GridView gvamain;
    public String pages_detail[]=new String[]{"Dainik Jagran","Dainik Bhaskar","Hindustan","Amar Ujala"};
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__hindi__news);
        this.setTitle("Hindi");


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                super.onAdLoaded();
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                super.onAdOpened();
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                super.onAdClicked();
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });
        gvamain=(GridView)findViewById(R.id.gvmain);
        gvamain.setAdapter(new menuAd(this,pages_detail));
        gvamain.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tdetail=((TextView)view.findViewById(R.id.tvmenu)).getText().toString();
                if(tdetail.equals("Dainik Jagran"))
                {
                    Intent icat=new Intent(All_Hindi_News.this,Dainik_Jagran.class);
                    startActivity(icat);
                }
                if(tdetail.equals("Dainik Bhaskar"))
                {
                    Intent icat=new Intent(All_Hindi_News.this,Dainik_Bhaskar.class);
                    startActivity(icat);
                }
                if(tdetail.equals("Hindustan"))
                {
                    Intent icat=new Intent(All_Hindi_News.this,Hindustan.class);
                    startActivity(icat);
                }
                if(tdetail.equals("Amar Ujala"))
                {
                    Intent icat=new Intent(All_Hindi_News.this,Amar_Ujala.class);
                    startActivity(icat);
                }
            }
        });
    }
    class menuAd extends BaseAdapter
    {
        Context context;
        String detail[];

        menuAd(Context context,String detail[])
        {
            this.context=context;
            this.detail=detail;
        }


        @Override
        public int getCount() {
            return detail.length;
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
            View grid;

            if(view==null)
            {
                grid=inflater.inflate(R.layout.hindi_row,null);
                TextView tv=(TextView)grid.findViewById(R.id.tvmenu);
                final ImageView imageViewmenu=(ImageView)grid.findViewById(R.id.imageViewmenu);
                tv.setText(detail[i]);
                final
                String s=detail[i];

                if(s.equals("Dainik Jagran"))
                {
                    imageViewmenu.setImageResource(R.drawable.dainik_jagran);
                }
                if(s.equals("Dainik Bhaskar"))
                {
                    imageViewmenu.setImageResource(R.drawable.dainik);
                }
                if(s.equals("Hindustan"))
                {
                    imageViewmenu.setImageResource(R.drawable.hindustan);
                }
                if(s.equals("Amar Ujala"))
                {
                    imageViewmenu.setImageResource(R.drawable.amar);
                }
            }
            else
            {
                grid=(View)view;
            }
            return grid;
        }
    }
}