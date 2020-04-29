package com.example.ludenswishlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Game_Activity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference AddToWishList = database.getReference("test-01");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_);


        Intent receivedIntent=getIntent();
        final String title=receivedIntent.getStringExtra("KEY_NAME");
        final String platform = receivedIntent.getStringExtra("KEY_PLATFORM");
        final String studio = receivedIntent.getStringExtra("KEY_STUDIO");
        String console=receivedIntent.getStringExtra("KEY_CONSOLE");
        final String genre=receivedIntent.getStringExtra("KEY_GENRE");
        final String date=receivedIntent.getStringExtra("KEY_DATE");
        final String bio=receivedIntent.getStringExtra("KEY_BIO");
        final int pic=receivedIntent.getIntExtra("KEY_PIC",0);

        TextView gameTitle= findViewById(R.id.gameTitle);
        gameTitle.setText(title);
        TextView gamePlatform= findViewById(R.id.gamePlatform);
        gamePlatform.setText(console);
        TextView gameGenre=findViewById(R.id.gameGenre);
        gameGenre.setText(genre);
        TextView gameRelease=findViewById(R.id.gameReleaseDate);
        gameRelease.setText(date);
        TextView gameBio = findViewById(R.id.bio);
        gameBio.setText(bio);
        ImageView gameImage=findViewById(R.id.gameImage);
        Drawable icon=getResources().getDrawable(pic, getTheme());
        gameImage.setImageDrawable(icon);



        //set listener to the addToWishList Button

        Button button = (Button) findViewById(R.id.addWishlist);

        final String game_Title=title;
        final String game_platform=platform;
        final String game_genre=genre;
        final String game_releaseDate=date;
        final String game_studio=studio;
        final String game_bio=bio;
        final int image=pic;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent (Game_Activity.this, WishList_Activity.class);
                intent.putExtra("KEY_NAME_W", game_Title);
                intent.putExtra("KEY_PLATFORM_W", game_platform);
                intent.putExtra("KEY_GENRE_W", game_genre);
                intent.putExtra("KEY_DATE_W", game_releaseDate);
                intent.putExtra("KEY_PIC_W", image);
                intent.putExtra("KEY_STUDIO_W", game_studio);
                intent.putExtra("KEY_BIO_W",game_bio);

//                Game g = new Game(title, genre, platform,studio,date,bio,pic);
//                database.getReference("999").push().setValue("123")
//                        .addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                System.out.println(e);
//                            }
//                        })
//                        .addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                System.out.println(task);
//                            }
//                        });
//                System.out.println(AddToWishList.getKey());
//                AddToWishList.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });
                startActivity(intent);
            }
        });

    }

}

//intent.putExtra("KEY_NAME", gameTitle);
//                intent.putExtra("KEY_CONSOLE", console);
//                intent.putExtra("KEY_GENRE", type);
//                intent.putExtra("KEY_DATE", when);
//                intent.putExtra("KEY_STUDIO", creator);
//                intent.putExtra("KEY_PIC", image);