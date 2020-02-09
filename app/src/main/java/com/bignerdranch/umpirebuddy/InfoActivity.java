package com.bignerdranch.umpirebuddy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {
    private String mName = "UmpireBuddy v2.0";
    private String mAuthor = "Alex Banning";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }
}
