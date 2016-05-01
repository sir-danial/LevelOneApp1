package com.example.danial.leveloneapp;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by danial on 4/27/2016.
 */
public class MyAdapter extends ArrayAdapter<User> {
    public MyAdapter(Context context , ArrayList<User> users){
        super(context,0,users);
    }

    private TextView tvName;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = getItem(position);

        if (convertView == null) {
            if (position %2 == 0) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.contact, parent, false);
                this.tvName = (TextView) convertView.findViewById(R.id.TxtName);
                this.tvName.setText(user.name);
            }
            else {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.contact2, parent, false);
                this.tvName = (TextView) convertView.findViewById(R.id.TxtName2);
                this.tvName.setText(user.name);
            }
        }

        return convertView;
    }
}
