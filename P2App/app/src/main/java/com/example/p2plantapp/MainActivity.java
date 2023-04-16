package com.example.p2plantapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.fragment.app.FragmentTransaction;



import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Next = (Button) findViewById(R.id.Next);


        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Openpage2();
                Log.d("Buttons","To page 2!");
                Toast.makeText(MainActivity.this, "Loading page 2",Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void Openpage2(){
        Intent Open = new Intent(this, SecondActivity.class);
        startActivity(Open);
    }

}