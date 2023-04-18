package com.example.p2plantapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.FragmentTransaction;



import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button Next;
    Button camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camera = (Button)findViewById(R.id.Quiz);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent();
                    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);
                }
                catch(Exception e){
                    e.printStackTrace();
                }

            }
        });

        Next = (Button) findViewById(R.id.Next);


        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Openpage2();
                Log.d("Buttons","To page 2!");
                Toast.makeText(MainActivity.this, "Loading Catalog",Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void Openpage2(){
        Intent Open = new Intent(this, SecondActivity.class);
        startActivity(Open);
    }

}