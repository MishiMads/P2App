package com.example.p2plantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private Button Front;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Front = (Button) findViewById(R.id.FrontPage);
        Front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Buttons","To page 3!");
                Openpage2();
                Toast.makeText(SecondActivity.this, "Loading page 3",Toast.LENGTH_SHORT).show();


            }
        });
    }


    public void Openpage2(){
        Intent Open = new Intent(this, MainActivity.class);
        startActivity(Open);
    }
}