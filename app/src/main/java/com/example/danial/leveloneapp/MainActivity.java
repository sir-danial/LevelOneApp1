package com.example.danial.leveloneapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> usersName = new ArrayList<>();
    ArrayList<User> arrayOfUsers = new ArrayList<User>();
    ListView listView;
    Button button1st;
    MyAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.button1st = (Button)findViewById(R.id.add_but_1st);

        this.adapter = new MyAdapter(this, arrayOfUsers);
        listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
        LoadPreferences();

        button1st.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(i, 1);

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SavePreferences();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                //Intent intent = getIntent();
                //Bundle extras = intent.getExtras();

                if (data != null) {
                    String name = data.getExtras().getString("name");
                    usersName.add(name);
                    User user = new User(name);
                    adapter.add(user);


                }
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(MainActivity.this, "operation canceled !",
                        Toast.LENGTH_SHORT).show();

            }

        }


    }
    protected void SavePreferences() {
        SharedPreferences data = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = data.edit();
        editor.putString("PREF_KEY_STRINGS", TextUtils.join(",", usersName));
        editor.commit();


    }

    protected void LoadPreferences(){

        SharedPreferences data = PreferenceManager.getDefaultSharedPreferences(this);
        String serialized = data.getString("PREF_KEY_STRINGS", null);
        if (serialized != null) {
            List<String> make ;
            make = Arrays.asList(TextUtils.split(serialized, ","));

            for (String string : make) {
                usersName.add(string);
                User oldUser = new User(string);
                adapter.add(oldUser);
            }
            adapter.notifyDataSetChanged();
        }
    }

}