package com.example.joey.progamer;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RecyclerviewAdapterSetting extends RecyclerView.Adapter<RecyclerviewAdapterSetting.MyViewHolder> {
    private static final String TAG = "RecyclerviewAdapterSett";

   // private LayoutInflater layoutInflater;
    private Context mContext;
    private String[] settingTitle;


    public RecyclerviewAdapterSetting(Context context,String[] mSettingTitle){
        mContext=context;
        settingTitle=mSettingTitle;
       // layoutInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerviewAdapterSetting.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_settingitem, null);

        final MyViewHolder holder=new MyViewHolder(inflate);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int position=holder.getAdapterPosition();
//              switch (position){
//                  case 0:
//                      final String[] size={"小","中","大"};
//                      AlertDialog.Builder builder=new AlertDialog.Builder(mContext);
//                      builder.setItems(size, new DialogInterface.OnClickListener() {
//                          @Override
//                          public void onClick(DialogInterface dialogInterface, int i) {
//                             switch (i){
//                                 case 0:
//                                     Toast.makeText(mContext,"小",Toast.LENGTH_SHORT).show();
//                                     break;
//                                 case 1:
//                                     Toast.makeText(mContext,"中",Toast.LENGTH_SHORT).show();
//                                     break;
//                                 case 2:
//                                     Toast.makeText(mContext,"大",Toast.LENGTH_SHORT).show();
//                                     break;
//                             }
//                          }
//                      });
//                      builder.create().show();
//                      break;
//              }
//            }
//        });

        return holder;
       // return new RecyclerviewAdapterSetting.MyViewHolder(layoutInflater.inflate(R.layout.recyclerview_settingitem,null,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerviewAdapterSetting.MyViewHolder holder, final int position) {
        holder.setting_item_id.setText(settingTitle[position]);
        holder.setting_item_id.setTextColor(Color.BLACK);
    }

    @Override
    public int getItemCount() {
        return settingTitle.length;
    }


    public static class MyViewHolder extends ViewHolder{
        TextView setting_item_id;
        public MyViewHolder(View itemView) {
            super(itemView);
            setting_item_id=(TextView)itemView.findViewById(R.id.setting_id);
        }
    }



}
