package com.example.all_e_paper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class Menu_list extends AppCompatActivity {

    GridView gvamain;
    public String pages_detail[]=new String[]{"Divya bhaskar","Gujarat Samachar","Sandesh","Zee24kalak","ABP Asmita","Cricket","Gujarati News","Sanj Samachar","Aajkaal"};
    private Object binding;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);
        this.setTitle("Gujarati");

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
                if(tdetail.equals("Divya bhaskar"))
                {
                    Intent icat=new Intent(Menu_list.this,Divya_bhaskar.class);
                    startActivity(icat);
                }
                if(tdetail.equals("Gujarat Samachar"))
                {
                    Intent icat=new Intent(Menu_list.this,Gujarat_Samachar.class);
                    startActivity(icat);
                }
                if(tdetail.equals("Sandesh"))
                {
                    Intent icat=new Intent(Menu_list.this,Sandesh.class);
                    startActivity(icat);
                }
                if(tdetail.equals("Sanj Samachar"))
                {
                    Intent icat=new Intent(Menu_list.this,Sanj_Samachar.class);
                    startActivity(icat);
                }
                if(tdetail.equals("Aajkaal"))
                {
                    Intent icat=new Intent(Menu_list.this,Aajkaal.class);
                    startActivity(icat);
                }
                if(tdetail.equals("Cricket"))
                {
                    Intent icat=new Intent(Menu_list.this,Cricket.class);
                    startActivity(icat);
                }
                if(tdetail.equals("Gujarati News"))
                {
                    Intent icat=new Intent(Menu_list.this,News_Gujarati.class);
                    startActivity(icat);
                }
                if(tdetail.equals("Zee24kalak"))
                {
                    Intent icat=new Intent(Menu_list.this,Zee_24_kalak.class);
                    startActivity(icat);
                }
                if(tdetail.equals("ABP Asmita"))
                {
                    Intent icat=new Intent(Menu_list.this,ABP_Asmita.class);
                    startActivity(icat);
                }
                if(tdetail.equals("Navgujarat"))
                {
                    Intent icat=new Intent(Menu_list.this,Nav_Gujaratsamay.class);
                    startActivity(icat);
                }
//                if(tdetail.equals("Mumbai Samachar"))
//                {
//                    Intent icat=new Intent(Menu_list.this,Bombay_samachar.class);
////                    Mumbai e-paper "https://www.bombaysamachar.com/frmEPShow.aspx"
////                    news "https://www.bombaysamachar.com/frmHomeA.aspx?City=1"
////                    Marathi news "https://lokmat.news18.com/category/mumbai/"
//                    startActivity(icat);
//                }
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

                if(s.equals("Divya bhaskar"))
                {
                    imageViewmenu.setImageResource(R.drawable.divya_logo);
                }
                if(s.equals("Gujarat Samachar"))
                {
                    imageViewmenu.setImageResource(R.drawable.gujarat_samachar);
                }
                if(s.equals("Sandesh"))
                {
                    imageViewmenu.setImageResource(R.drawable.sandesh);
                }
//                if(s.equals("Times of India"))
//                {
//                    imageViewmenu.setImageResource(R.drawable.the_times_of_india);
//                }
                if(s.equals("Sanj Samachar"))
                {
                    imageViewmenu.setImageResource(R.drawable.sanjsamachar);
                }
                if(s.equals("Aajkaal"))
                {
                    imageViewmenu.setImageResource(R.drawable.aajkaal);
                }
                if(s.equals("Cricket"))
                {
                    imageViewmenu.setImageResource(R.drawable.cricbuzz);
                }
                if(s.equals("Gujarati News"))
                {
                    imageViewmenu.setImageResource(R.drawable.news_gujarati);
                }
                if(s.equals("Zee24kalak"))
                {
                    imageViewmenu.setImageResource(R.drawable.zee24kalak);
                }
                if(s.equals("ABP Asmita"))
                {
                    imageViewmenu.setImageResource(R.drawable.abp_asmita);
                }
                if(s.equals("Navgujarat"))
                {
                    imageViewmenu.setImageResource(R.drawable.navgujaratsamay);
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