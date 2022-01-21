package com.aymen.radiotn;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RadioAdapter extends BaseAdapter {
    ArrayList<Radio> listRadio = new ArrayList<Radio>();
    LayoutInflater li ;
    Context context ;
    public RadioAdapter(ArrayList<Radio> listRadio, LayoutInflater li , Context context){
        this.listRadio = listRadio ;
        this.context = context ;
        this.li = li ;
    }
    @Override
    public int getCount() {
        return listRadio.size();
    }

    @Override
    public Radio getItem(int position) {
        return listRadio.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listRadio.get(position).getId();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = li.inflate(R.layout.radio_view,null);


        TextView name = (TextView) v.findViewById(R.id.radioName);
        ImageView play = (ImageView) v.findViewById(R.id.play) ;
        ImageView favorite = (ImageView) v.findViewById(R.id.favorite) ;

        name.setText(listRadio.get(position).getName());

        play.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Bundle b = new Bundle();
                b.putString("audioUrl",listRadio.get(position).getAudioUrl());
                b.putString("name",listRadio.get(position).getImageURL());
                b.putString("imageUrl",listRadio.get(position).getName());
                @SuppressLint("ClickableViewAccessibility") Intent intent = new  Intent(context.getApplicationContext(),Stream.class);
                intent.putExtras(b);

                context.startActivity(intent);

                return false;
            }
        });

        favorite.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(listRadio.get(position).getFavorite() == true){
                    listRadio.get(position).setFavorite(false);
                    @SuppressLint("ClickableViewAccessibility") Toast toast =  Toast.makeText(context,"Remove "+listRadio.get(position).getName()+"\n from favorite", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    listRadio.get(position).setFavorite(true);
                    @SuppressLint("ClickableViewAccessibility") Toast toast =  Toast.makeText(context,"Add "+listRadio.get(position).getName()+"\n to favorite", Toast.LENGTH_SHORT);
                    toast.show();
                }

                return false;
            }
        });



        return v ;
    }
}
