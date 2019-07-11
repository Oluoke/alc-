package com.xheghun.alcchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyProfileActivity extends AppCompatActivity {

    Toolbar toolbar;
    CircleImageView profile_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        toolbar = findViewById(R.id.toolbar);
        profile_img = findViewById(R.id.profile_img);

        Glide.with(this).load(R.drawable.profil).override(profile_img.getWidth(),profile_img.getHeight())
                .into(profile_img);

        toolbar.setNavigationOnClickListener (view -> onBackPressed());
    }
}
