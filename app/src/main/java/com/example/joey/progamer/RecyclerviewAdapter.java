package com.example.joey.progamer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {


    private LayoutInflater layoutInflater;
    private Context mContext;
    private String [] mTitle;
    private int mHeadIconId;
    private ArrayList<String> mContent;

    public RecyclerviewAdapter(Context context,String[] title,int headIconId,ArrayList<String> content){
        mContext=context;
        mTitle=title;
        mHeadIconId=headIconId;
        mContent=content;
        layoutInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerviewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        final View inflate = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_item_info, parent,false);

        final RecyclerviewAdapter.MyViewHolder holder=new RecyclerviewAdapter.MyViewHolder(inflate);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();

                View view1=View.inflate(mContext,R.layout.infochange,null);
                final EditText bornDateChange=(EditText)view1.findViewById(R.id.bornDateChange);
                final EditText areaChange=(EditText)view1.findViewById(R.id.areaChange);
                final EditText schoolChange=(EditText)view1.findViewById(R.id.schoolChange);

                switch (position){
                    case 0:
                        Intent intent=new Intent(mContext,HeadIconChooseActivity.class);
                        intent.putExtra("HeadIconChanged",mHeadIconId);

                        if (Activity.class.isInstance(mContext)) {
                            Activity activity = (Activity)mContext;
                            mContext.startActivity(intent);
                            activity.overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_from_left);
                        }
                     //   Toast.makeText(mContext,"更换头像",Toast.LENGTH_SHORT).show();
                        break;
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
                                                Acount acount=new Acount();
                                                acount.setMale(true);
                                                acount.updateAll("userName=?",LoginActivity.username);
                                                break;
                                            case 1:
                                                mContent.set(1,"女");
                                                notifyItemChanged(2);
                                                Acount acount1=new Acount();
                                                acount1.setMale(false);
                                                acount1.updateAll("userName=?",LoginActivity.username);
                                                break;
                                        }
                                    }
                                });
                        builder.create().show();
                        break;
                    case 3:
                        areaChange.setVisibility(View.GONE);
                        schoolChange.setVisibility(View.GONE);
                        AlertDialog.Builder builder1=new AlertDialog.Builder(mContext);
                        builder1.setTitle("填写生日日期")
                                .setView(view1)
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        mContent.set(2,bornDateChange.getText().toString());
                                        notifyItemChanged(3);
                                        Acount acount2=new Acount();
                                        acount2.setBornDate(bornDateChange.getText().toString());
                                        acount2.updateAll("userName=?",LoginActivity.username);
                                    }
                                })
                                .setNegativeButton("取消",null);
                        builder1.create().show();
                       // Toast.makeText(mContext,"更换生日",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        bornDateChange.setVisibility(View.GONE);
                        schoolChange.setVisibility(View.GONE);
                        AlertDialog.Builder builder2=new AlertDialog.Builder(mContext);
                        builder2.setTitle("填写地区")
                                .setView(view1)
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        mContent.set(3,areaChange.getText().toString());
                                        notifyItemChanged(4);
                                        Acount acount3=new Acount();
                                        acount3.setArea(areaChange.getText().toString());
                                        acount3.updateAll("userName=?",LoginActivity.username);
                                    }
                                })
                                .setNegativeButton("取消",null);
                        builder2.create().show();
                        //Toast.makeText(mContext,"更换地区",Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        areaChange.setVisibility(View.GONE);
                        bornDateChange.setVisibility(View.GONE);
                        AlertDialog.Builder builder3=new AlertDialog.Builder(mContext);
                        builder3.setTitle("填写学校")
                                .setView(view1)
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        mContent.set(4,schoolChange.getText().toString());
                                        notifyItemChanged(5);
                                        Acount acount4=new Acount();
                                        acount4.setSchool(schoolChange.getText().toString());
                                        acount4.updateAll("userName=?",LoginActivity.username);
                                    }
                                })
                                .setNegativeButton("取消",null);
                        builder3.create().show();
                       // Toast.makeText(mContext,"更换学校",Toast.LENGTH_SHORT).show();
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
                switch (mHeadIconId){
                    case 1:
                        holder.info_image.setImageResource(R.drawable.head);
                        break;
                    case 2:
                        holder.info_image.setImageResource(R.drawable.headicon2);
                        break;
                    case 3:
                        holder.info_image.setImageResource(R.drawable.headicon3);
                        break;
                    case 4:
                        holder.info_image.setImageResource(R.drawable.headicon4);
                        break;
                    case 5:
                        holder.info_image.setImageResource(R.drawable.headicon5);
                        break;
                    case 6:
                        holder.info_image.setImageResource(R.drawable.headicon6);
                        break;
                }
            } else {
                holder.info_detail.setText(mContent.get(position - 1));
            }
            if(position==1){
                holder.right_arrow.setVisibility(View.GONE);
            }


    }

    @Override
    public int getItemCount() {
        return mTitle.length;
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView info_id,info_detail;
        CircleImageView info_image;
        ImageView right_arrow;
        public MyViewHolder(View itemView) {
            super(itemView);
            info_id=(TextView)itemView.findViewById(R.id.info_id);
            info_detail=(TextView)itemView.findViewById(R.id.info_detail);
            info_image=(CircleImageView)itemView.findViewById(R.id.info_image);
            right_arrow=(ImageView)itemView.findViewById(R.id.right_arrow);
        }
    }

}
