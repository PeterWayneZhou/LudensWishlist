package com.example.ludenswishlist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.io.Serializable;
import java.util.List;


public class GamesAdapter extends Adapter<GameViewHolder> implements Serializable {
    private List<Game> games;
    private Context context;


    public GamesAdapter(List<Game> games, Context context) {
        this.games = games;
        this.context = context;
    }

    public GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_game, parent, false);
        Button detail=view.findViewById(R.id.detail_button);
    /*    detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (context, Game_Activity.class);

                context.startActivity(intent);
            }
        }); */
        Button share=view.findViewById(R.id.share_button);
     /*   share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent (context, SharePage_Activity.class);
                context.startActivity(intent);
            }
        }); */
        return new GameViewHolder(view, context);
    }



    public void onBindViewHolder(final GameViewHolder holder, int position) {
        Game game = games.get(position);
        holder.gameName.setText(game.gameName);
        holder.gamePlatform.setText(game.platform);
        holder.gameGenre.setText(game.genre);
        holder.gameReleaseDate.setText(game.releaseDate);
        holder.gameStudio.setText(game.studio);
        holder.gamePhoto.setImageResource(game.gameId);
        final String gameTitle=game.gameName;
        final String console=game.platform;
        final String type=game.genre;
        final String when=game.releaseDate;
        final String studio=game.studio;
        final String platform=game.platform;
        final int image=game.gameId2;
        final String gameBio=game.bio;
        holder.detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (context, Game_Activity.class);
                intent.putExtra("KEY_NAME", gameTitle);
                intent.putExtra("KEY_CONSOLE", console);
                intent.putExtra("KEY_GENRE", type);
                intent.putExtra("KEY_PLATFORM", platform);
                intent.putExtra("KEY_STUDIO", studio);
                intent.putExtra("KEY_DATE", when);
                intent.putExtra("KEY_PIC", image);
                intent.putExtra("KEY_BIO", gameBio);

                context.startActivity(intent);
            }
        });
        holder.shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent (context, SharePage_Activity.class);
                intent.putExtra("KEY_NAME", gameTitle);
               //intent.putExtra("KEY_CONSOLE", console);
                intent.putExtra("KEY_GENRE", type);
                intent.putExtra("KEY_DATE", when);
                intent.putExtra("KEY_PIC", image);
                //intent.putExtra("KEY_BIO", gameBio);
                context.startActivity(intent);
            }
        });
    }



    public int getItemCount() {
        return games.size();
    }
}
