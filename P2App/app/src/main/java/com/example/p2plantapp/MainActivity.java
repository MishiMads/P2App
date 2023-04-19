package com.example.p2plantapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.provider.MediaStore;
import android.util.Log;
import android.view.View;


import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button Next;
    Button camera;
    ImageView ImageDisplay;
    public static final int CAMERA_ACTION_CODE =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camera = (Button)findViewById(R.id.Quiz);
        ImageDisplay = findViewById(R.id.TestImage);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (intent.resolveActivity(getPackageManager()) !=null){
                    startActivityForResult(intent, CAMERA_ACTION_CODE);
                }
                else {
                    Toast.makeText(MainActivity.this, "how the fuck do you not have a camera", Toast.LENGTH_SHORT).show();
                }

               /* try{
                    Intent intent = new Intent();
                    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);

                }
                catch(Exception e){
                    e.printStackTrace();
                }

                */

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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_ACTION_CODE && resultCode == RESULT_OK && data != null){
            Bundle bundle = data.getExtras();
            Bitmap finalPhoto = (Bitmap) bundle.get("data");
            ImageDisplay.setImageBitmap(finalPhoto);
        }
    }

}