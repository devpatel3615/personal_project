package com.example.all_e_paper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Contact_us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        setTitle("Contact us");
        getSupportActionBar().hide();
    }
}