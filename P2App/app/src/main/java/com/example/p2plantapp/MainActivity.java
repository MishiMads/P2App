package com.example.p2plantapp;

import static android.content.ContentValues.TAG;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.provider.MediaStore;
import android.util.Log;
import android.view.View;


import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {



    private Button Next;
    Button camera;
    ImageView ImageDisplay;
    public static final int CAMERA_ACTION_CODE =1;

    //Declaring a value "final" means that the value becomes immutable and constant, which means
    //that the value cannot be changed after being initialized.
    //The "final" keyword also applies to methods and classes.
        //Final methods cannot be overriden by a subclass.
        //Final classes cannot be subclassed.

    private Bitmap finalPhoto;

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private HashMap<String, Bitmap> catalog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camera = (Button)findViewById(R.id.PicBut);
        ImageDisplay = findViewById(R.id.Image1);


        catalog = new HashMap<>();
        catalog.put("image1", BitmapFactory.decodeResource(getResources(), R.drawable.anders));
        catalog.put("image2", BitmapFactory.decodeResource(getResources(), R.drawable.anders));
        catalog.put("image3", BitmapFactory.decodeResource(getResources(), R.drawable.anders));
        catalog.put("image4", BitmapFactory.decodeResource(getResources(), R.drawable.anders));
        catalog.put("image5", BitmapFactory.decodeResource(getResources(), R.drawable.anders));
        catalog.put("image6", BitmapFactory.decodeResource(getResources(), R.drawable.anders));

        Button takePictureButton = findViewById(R.id.PicBut);
        takePictureButton.setOnClickListener(new View.OnClickListener() {

            //OnClickListener() is an event.
            //An event triggers the software program to respond or behave in a specific way.

            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }

            private void dispatchTakePictureIntent() {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                //The "intent" keyword is a messaging object used to communicate between
                //components such as activities, services and broadcast receivers.

                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });


        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Log.d(TAG, "Catalog.put not working?");
                if (intent.resolveActivity(getPackageManager()) !=null){
                    startActivityForResult(intent, CAMERA_ACTION_CODE);
                    Log.i(TAG, "onClick: aksjd");
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
            Bitmap birdImage = (Bitmap) bundle.get("data");


            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Enter a name for the bird");
            final EditText input = new EditText(this);
            builder.setView(input);
            Log.d(TAG, "Picture taken");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String birdName = input.getText().toString();
                    // Add the bird picture to the catalog with the entered name
                    catalog.put(birdName, birdImage);
                    Log.d(TAG, "Catalog.put not working?");
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
            Log.d(TAG, "Code finish");
        }
    }

}

