package com.example.ludenswishlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Game_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_);
        Intent receivedIntent=getIntent();
        String title=receivedIntent.getStringExtra("KEY_NAME");
        String console=receivedIntent.getStringExtra("KEY_CONSOLE");
        String genre=receivedIntent.getStringExtra("KEY_GENRE");
        String date=receivedIntent.getStringExtra("KEY_DATE");
        int pic=receivedIntent.getIntExtra("KEY_PIC",0);
        TextView gameTitle= findViewById(R.id.gameTitle);
        gameTitle.setText(title);
        TextView gamePlatform= findViewById(R.id.gamePlatform);
        gamePlatform.setText(console);
        TextView gameGenre=findViewById(R.id.gameGenre);
        gameGenre.setText(genre);
        TextView gameRelease=findViewById(R.id.gameReleaseDate);
        gameRelease.setText(date);
        ImageView gameImage=findViewById(R.id.gameImage);
        Drawable icon=getResources().getDrawable(pic, getTheme());
        gameImage.setImageDrawable(icon);
    }

}

//intent.putExtra("KEY_NAME", gameTitle);
//                intent.putExtra("KEY_CONSOLE", console);
//                intent.putExtra("KEY_GENRE", type);
//                intent.putExtra("KEY_DATE", when);
//                intent.putExtra("KEY_STUDIO", creator);
//                intent.putExtra("KEY_PIC", image);