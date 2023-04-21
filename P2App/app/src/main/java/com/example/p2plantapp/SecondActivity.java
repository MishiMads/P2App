package com.example.p2plantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    ImageButton imageButton;
    Button button;
    private Button Front;
    private ImageButton IP;

    private Button buttonSearch;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Front = (Button) findViewById(R.id.FrontPage);

        //imageButton = findViewById(R.id.imageButton);
        //button = findViewById(R.id.);

        Front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Buttons","To page 3!");
                PHomescreen();
                Toast.makeText(SecondActivity.this, "Loading Frontpage",Toast.LENGTH_SHORT).show();
            }
        });
        IP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PBlank();
            }
        });

        buttonSearch = (Button) findViewById(R.id.buttonSearch);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PSearch();
            }
        });
    }


    public void PHomescreen(){
        Intent Open = new Intent(this, MainActivity.class);
        startActivity(Open);
    }
    public void PBlank(){
        Intent Open3 = new Intent(this, Itempage.class);
        startActivity(Open3);
    }

    public void PSearch(){
        Intent Open4 = new Intent(this, Search.class);
        startActivity(Open4);
    }

}