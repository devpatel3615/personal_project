package com.example.all_e_paper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.material.navigation.NavigationView;

public class Choise_Language_Paper extends AppCompatActivity {
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    public static NavigationView navigationView;
    GridView gvamain;
    public String pages_detail[]=new String[]{"Gujarati News","English News","Hindi News"};

    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choise__language__paper);
        setTitle("Menu");


//     AdMobe
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
            private void createPersonalizead() {
            }
        });

        mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
//        mAdView.setAdListener(new AdListener() {
//            @Override
//            public void onAdLoaded()
//            {
//                // Code to be executed when an ad finishes loading.
//                super.onAdLoaded();
//                Toast.makeText(Choise_Language_Paper.this, "Add load", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onAdFailedToLoad(LoadAdError adError) {
//                // Code to be executed when an ad request fails.
//                super.onAdFailedToLoad(adError);
//                mAdView.loadAd(adRequest);
//
//            }
//
//            @Override
//            public void onAdOpened() {
//                // Code to be executed when an ad opens an overlay that
//                // covers the screen.
//                super.onAdOpened();
//            }
//
//            @Override
//            public void onAdClicked() {
//                // Code to be executed when the user clicks on an ad.
//                super.onAdClicked();
//            }
//
//            @Override
//            public void onAdClosed() {
//                // Code to be executed when the user is about to return
//                // to the app after tapping on an ad.
//            }
//        });




        gvamain=(GridView)findViewById(R.id.gvmain);
        gvamain.setAdapter(new menuAd(this,pages_detail));
        gvamain.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tdetail=((TextView)view.findViewById(R.id.tvmenu)).getText().toString();
                if(tdetail.equals("Gujarati News"))
                {
                    Intent icat=new Intent(Choise_Language_Paper.this,Menu_list.class);
                    startActivity(icat);
                }
                if(tdetail.equals("English News"))
                {
                    Intent icat=new Intent(Choise_Language_Paper.this,All_English_News.class);
                    startActivity(icat);
                }
                if(tdetail.equals("Hindi News"))
                {
                    Intent icat=new Intent(Choise_Language_Paper.this,All_Hindi_News.class);
                    startActivity(icat);
                }
//                if(tdetail.equals("Magazine"))
//                {
//                    Intent icat=new Intent(Choise_Language_Paper.this,All_Magazine.class);
////                  https://timesofindia.indiatimes.com/
//                    startActivity(icat);
//                }
            }
        });
        Toolbar toolbar=findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        drawer=(DrawerLayout)findViewById(R.id.drawer);
        navigationView=(NavigationView)findViewById(R.id.nv);
        toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                int id=menuItem.getItemId();
                switch (id)
                {
                    case R.id.nav_english:
                        Intent i_pass=new Intent(Choise_Language_Paper.this,All_English_News.class);
                        startActivity(i_pass);
                        break;

                    case R.id.nav_gujarati:
                        Intent i_bategory=new Intent(Choise_Language_Paper.this, Menu_list.class);
                        startActivity(i_bategory);
                        break;

                    case R.id.nav_hindi:
                        Intent i_category=new Intent(Choise_Language_Paper.this, All_Hindi_News.class);
                        startActivity(i_category);
                        break;
                    case R.id.nav_developer:
                        Intent i_vategory=new Intent(Choise_Language_Paper.this, Developer_contact.class);
                        startActivity(i_vategory);
                        break;

                    case R.id.nav_share:
                    {
                        Intent i_share = new Intent(Choise_Language_Paper.this, Choise_Language_Paper.class);
                        Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
                        shareIntent.setType("text/plain");
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Insert Subject here");
                        String app_url = "https://drive.google.com/file/d/1Ab-BuZ5TMrrVKdN2ba9kJFW4dbTw1geV/view?usp=drivesdk";
                        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, app_url);
                        startActivity(Intent.createChooser(shareIntent, "Share via"));
                    };
                    break;
                    default:
                    return true;
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
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
                grid=inflater.inflate(R.layout.choise_language_paper_row,null);
                TextView tv=(TextView)grid.findViewById(R.id.tvmenu);
                final ImageView imageViewmenu=(ImageView)grid.findViewById(R.id.imageViewmenu);
                tv.setText(detail[i]);
                final
                String s=detail[i];

                if(s.equals("Gujarati News"))
                {
                    imageViewmenu.setImageResource(R.drawable.guj);
                }
                if(s.equals("English News"))
                {
                    imageViewmenu.setImageResource(R.drawable.english);
                }
                if(s.equals("Hindi News"))
                {
                    imageViewmenu.setImageResource(R.drawable.hindi);
                }
//                if(s.equals("Magazine"))
//                {
//                    imageViewmenu.setImageResource(R.drawable.magazine);
//                }
            }
            else
            {
                grid=(View)view;
            }
            return grid;
        }
    }
}