package com.example.danial.leveloneapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by danial on 4/26/2016.
 */
public class AddActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);



        Button button2nd = (Button)findViewById(R.id.add_but_2nd);
        final EditText editText = (EditText)findViewById(R.id.EdTxt1_2nd);
        final Intent intent = new Intent(AddActivity.this,MainActivity.class);

        button2nd.setOnClickListener(new View.OnClickListener() {
            public String name = "";

            @Override
            public void onClick(View v) {
                name = editText.getText().toString();
                if(!name.equals("")){
                    intent.putExtra("name",name);
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
                else{
                    Toast.makeText(AddActivity.this, "insert name please !",
                            Toast.LENGTH_SHORT).show();
                    setResult(RESULT_CANCELED,intent);
                }

            }
        });
    }


}
