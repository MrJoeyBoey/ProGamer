package com.example.joey.progamer;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.tablemanager.Connector;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.support.constraint.Constraints.TAG;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {


    private LayoutInflater layoutInflater;
    private Context mContext;
    private String [] mTitle;
    private int [] mPic;
    private ArrayList<String> mContent;

    public RecyclerviewAdapter(Context context,String[] title,int[] pic,ArrayList<String> content){
        mContext=context;
        mTitle=title;
        mPic=pic;
        mContent=content;
        layoutInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerviewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_item_info, parent,false);

        final RecyclerviewAdapter.MyViewHolder holder=new RecyclerviewAdapter.MyViewHolder(inflate);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                switch (position){
                    case 0:
                        Toast.makeText(mContext,"更换头像",Toast.LENGTH_SHORT).show();
                        break;
//                    case 1:
//                        Toast.makeText(mContext,"更换昵称",Toast.LENGTH_SHORT).show();
//                        break;
                    case 2:
                        final String[] sexitem=new String[]{"男","女"};
                        AlertDialog.Builder builder=new AlertDialog.Builder(mContext);
                        builder.setTitle("选择性别")
                                .setItems(sexitem, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        switch (i){
                                            case 0:
                                                mContent.set(1,"男");
                                                notifyItemChanged(2);
                                                Connector.getDatabase();
                                                Acount acount=new Acount();
                                                acount.setMale(true);
                                                acount.save();
                                                break;
                                            case 1:
                                                mContent.set(1,"女");
                                                notifyItemChanged(2);
                                                Connector.getDatabase();
                                                Acount acount1=new Acount();
                                                acount1.setMale(false);
                                                acount1.save();
                                                break;
                                        }
                                    }
                                });
                        builder.create().show();
                        break;
                    case 3:
                        Toast.makeText(mContext,"更换生日",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(mContext,"更换地区",Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(mContext,"更换学校",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        return holder;
//        return new RecyclerviewAdapter.MyViewHolder(layoutInflater.inflate(R.layout.recyclerview_item_info,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewAdapter.MyViewHolder holder, int position) {

            holder.info_id.setText(mTitle[position]);

            if (position == 0) {
                holder.info_image.setBackgroundResource(mPic[position]);
            } else {
                holder.info_detail.setText(mContent.get(position - 1));
            }


    }

    @Override
    public int getItemCount() {
        return mTitle.length;
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView info_id,info_detail;
        CircleImageView info_image;
        public MyViewHolder(View itemView) {
            super(itemView);
            info_id=(TextView)itemView.findViewById(R.id.info_id);
            info_detail=(TextView)itemView.findViewById(R.id.info_detail);
            info_image=(CircleImageView)itemView.findViewById(R.id.info_image);
        }
    }

}
