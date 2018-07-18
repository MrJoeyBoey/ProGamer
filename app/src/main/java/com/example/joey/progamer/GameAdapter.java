package com.example.joey.progamer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {
    private Context mContext;
    private List<Game> mGameList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView gameImage;
        TextView gameName;

        public ViewHolder(View itemView) {

            super(itemView);
            cardView=(CardView)itemView;
            gameImage=(ImageView)itemView.findViewById(R.id.game_image);
            gameName=(TextView)itemView.findViewById(R.id.game_name);
        }
    }

    public GameAdapter(List<Game> gameList){

        mGameList=gameList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.game_item,parent,false);
        final ViewHolder viewHolder =new ViewHolder(view);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=viewHolder.getAdapterPosition();
                Game games=mGameList.get(position);
                Intent intent=new Intent(mContext,GamesActivity.class);
                intent.putExtra("GameName",games.getGameName());
                intent.putExtra("GameCover",games.getImageId());
                intent.putExtra("EnglishName",games.getEnglishName());
                intent.putExtra("Grade",games.getGrade());
                intent.putExtra("Platform",games.getPlatform());
                intent.putExtra("GameType",games.getGameType());
                intent.putExtra("GameVideo",games.getGameVideo());
                mContext.startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Game game=mGameList.get(position);
        holder.gameName.setText(game.getGameName());
       // holder.gameImage.setImageDrawable(game.getImageDrawable());
        Glide.with(mContext).load(game.getImageId()).into(holder.gameImage);
    }

    @Override
    public int getItemCount() {
        return mGameList.size();
    }


}
