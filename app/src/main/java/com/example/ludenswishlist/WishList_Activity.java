package com.example.ludenswishlist;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.icu.text.CaseMap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class WishList_Activity extends AppCompatActivity {

    private List<Game> games;
    private GamesAdapter gamesAdapter;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference AddToWishList = database.getReference("AddtoWishList");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Luden's Wishlist - WISHLIST");
        getIntent();

        initialData();

        RecyclerView recyclerView =(RecyclerView)findViewById(R.id.Recycler_View);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        gamesAdapter = new GamesAdapter(games, this);
        recyclerView.setAdapter(gamesAdapter);
    }

    private void initialData() {
        games = new ArrayList<>();
        Intent receivedIntent=getIntent();
//        final String title=receivedIntent.getStringExtra("KEY_NAME_W");
//        String platform = receivedIntent.getStringExtra("KEY_PLATFORM_W");
//        String studio = receivedIntent.getStringExtra("KEY_STUDIO_W");
//        String genre=receivedIntent.getStringExtra("KEY_GENRE_W");
//        String date=receivedIntent.getStringExtra("KEY_DATE_W");
//        String bio=receivedIntent.getStringExtra("KEY_BIO_W");
//        int pic=receivedIntent.getIntExtra("KEY_PIC_W",0);
        AddToWishList = database.getReference("AddtoWishList");
        AddToWishList.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Game loadedData = dataSnapshot.getValue(Game.class);
               // valueField.setText(loadedData);
               // Log.e("Count " ,""+dataSnapshot.getChildrenCount());
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Game post = postSnapshot.getValue(Game.class);
                    //Log.e("Get Data", post.<YourMethod>());
                    games.add(new Game(post.getGameName(), post.getGenre(), post.getPlatform(), post.getStudio(), post.getReleaseDate(), post.getBio(), post.getGameId()));
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(WishList_Activity.this, "Error loading Firebase", Toast.LENGTH_SHORT).show();
            }
        });





    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.Home:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                return true;
            case R.id.Wishlist:
                Toast.makeText(this,"This is your Wishlist", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.News:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.android.com"));

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }


                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
