package com.example.ludenswishlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SharePage_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_page_);

        Intent receivedIntent=getIntent();
        String title=receivedIntent.getStringExtra("KEY_NAME");
        String platform=receivedIntent.getStringExtra("KEY_PLATFORM");
        String genre=receivedIntent.getStringExtra("KEY_GENRE");
        String date=receivedIntent.getStringExtra("KEY_DATE");
        int pic=receivedIntent.getIntExtra("KEY_PIC",0);

        TextView gameTitle= findViewById(R.id.game_name_view);
        gameTitle.setText(title);
        TextView gameGenre=findViewById(R.id.game_genre_view);
        gameGenre.setText(genre);
        TextView gameRelease=findViewById(R.id.game_releaseDate_view);
        gameRelease.setText(date);
        ImageView gameImage=findViewById(R.id.game_image_view);
        Drawable icon=getResources().getDrawable(pic, getTheme());
        gameImage.setImageDrawable(icon);
    }
}
