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

public class All_English_News extends AppCompatActivity {
    GridView gvamain;
    public String pages_detail[]=new String[]{"The Tribune","The Indian Express","The Hindu","The Times Of india","Hindustan Times","The Economic Times"};

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__english__news);
        this.setTitle("English");



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

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        gvamain=(GridView)findViewById(R.id.gvmain);
        gvamain.setAdapter(new menuAd(this,pages_detail));
        gvamain.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tdetail=((TextView)view.findViewById(R.id.tvmenu)).getText().toString();
                if(tdetail.equals("The Tribune"))
                {
                    Intent icat=new Intent(All_English_News.this,The_Tribune.class);
                    startActivity(icat);
                }
                if(tdetail.equals("The Indian Express"))
                {
                    Intent icat=new Intent(All_English_News.this,The_Indian_Express.class);
                    startActivity(icat);
                }
                if(tdetail.equals("The Hindu"))
                {
                    Intent icat=new Intent(All_English_News.this,The_Hindu.class);
                    startActivity(icat);
                }
                if(tdetail.equals("The Times Of india"))
                {
                    Intent icat=new Intent(All_English_News.this,The_Times_Of_india.class);
                    startActivity(icat);
                }
                if(tdetail.equals("Hindustan Times"))
                {
                    Intent icat=new Intent(All_English_News.this,Hindustan_Times.class);
                    startActivity(icat);
                }
                if(tdetail.equals("The Economic Times"))
                {
                    Intent icat=new Intent(All_English_News.this,The_Economic_Times.class);
//                    https://www.cricbuzz.com/
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
                grid=inflater.inflate(R.layout.menu_row,null);
                TextView tv=(TextView)grid.findViewById(R.id.tvmenu);
                final ImageView imageViewmenu=(ImageView)grid.findViewById(R.id.imageViewmenu);
                tv.setText(detail[i]);
                final
                String s=detail[i];

                if(s.equals("The Tribune"))
                {
                    imageViewmenu.setImageResource(R.drawable.the_tribune);
                }
                if(s.equals("The Indian Express"))
                {
                    imageViewmenu.setImageResource(R.drawable.theindianexpress);
                }
                if(s.equals("The Hindu"))
                {
                    imageViewmenu.setImageResource(R.drawable.the_hindu);
                }
//                if(s.equals("Times of India"))
//                {
//                    imageViewmenu.setImageResource(R.drawable.the_times_of_india);
//                }
                if(s.equals("The Times Of india"))
                {
                    imageViewmenu.setImageResource(R.drawable.tio);
                }
                if(s.equals("Hindustan Times"))
                {
                    imageViewmenu.setImageResource(R.drawable.hindu);
                }
                if(s.equals("The Economic Times"))
                {
                    imageViewmenu.setImageResource(R.drawable.et);
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