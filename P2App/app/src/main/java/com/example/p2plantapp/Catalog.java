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
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.HashMap;
import android.widget.LinearLayout.LayoutParams;

public class Catalog extends AppCompatActivity {



    private Button Next;
    Button camera;

    public static final int CAMERA_ACTION_CODE =1;

    //Declaring a value "final" means that the value becomes immutable and constant, which means
    //that the value cannot be changed after being initialized.
    //The "final" keyword also applies to methods and classes.
    //Final methods cannot be overriden by a subclass.
    //Final classes cannot be subclassed.

    private Bitmap finalPhoto;

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private HashMap<String, Bitmap> catalog;
    private Bitmap test1;
    private Bitmap test2;
    private Bitmap test3;
    private Bitmap test4;
    private Bitmap test5;
    private Bitmap test6;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        camera = (Button)findViewById(R.id.PicBut);

        Log.i("mytag", "onCreate: function ");

        catalog = new HashMap<>();
        //test1 = catalog.put("image1", BitmapFactory.decodeResource(getResources(), R.drawable.anders));
        //test2 = catalog.put("image2", BitmapFactory.decodeResource(getResources(), R.drawable.anders));
        //test3 = catalog.put("image3", BitmapFactory.decodeResource(getResources(), R.drawable.anders));
        //test4 = catalog.put("image4", BitmapFactory.decodeResource(getResources(), R.drawable.anders));
        //test5 = catalog.put("image5", BitmapFactory.decodeResource(getResources(), R.drawable.anders));
        //test6 = catalog.put("image6", BitmapFactory.decodeResource(getResources(), R.drawable.anders));

        Button takePictureButton = findViewById(R.id.PicBut);

        LinearLayout catalogLayout = findViewById(R.id.catalog_layout);
        for (String name : catalog.keySet()) {
            Log.d("myTag", "Forloop");
            Bitmap image = catalog.get(name);
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(image);
            catalogLayout.addView(imageView);
            Log.d("myTag", "Forloop ended");
        }
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
                Log.d("myTag", "Camera opens");
                if (intent.resolveActivity(getPackageManager()) !=null){
                    startActivityForResult(intent, CAMERA_ACTION_CODE);
                    Log.i("myTag", "if function in camera");
                }
                else {
                    Toast.makeText(Catalog.this, "how the fuck do you not have a camera", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Next = (Button) findViewById(R.id.Next);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("myTag","button click");
                Intent intent = new Intent(Catalog.this, Search.class);
                startActivity(intent);
                // Toast.makeText(MainActivity.this, "Loading Catalog",Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_ACTION_CODE && resultCode == RESULT_OK && data != null){
            Bundle bundle = data.getExtras();
            Bitmap birdImage = (Bitmap) bundle.get("data");

            Log.d("myTag", "bitmaps");

            String name = "image" + (catalog.size() + 1);
            Log.d("myTag", "+1 size");
            catalog.put(name, birdImage);
            LinearLayout catalogLayout = findViewById(R.id.catalog_layout);
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(birdImage);
            imageView.setMinimumHeight(500);
            imageView.setMinimumWidth(500);
            catalogLayout.addView(imageView);



            Log.d("myTag", "added bitmap to cataloglayout");

            Log.d("myTag", "alertdialog created");
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Enter a name for the bird");
            final EditText input = new EditText(this);
            builder.setView(input);




            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Log.d("myTag", "ok button to name");
                    String birdName = input.getText().toString();
                    // Add the bird picture to the catalog with the entered name
                    catalog.put(birdName, birdImage);
                    Log.d("myTag", "onclick name ended");
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
