/*package com.example.p2plantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.HashMap;

public class CatalogActivity extends AppCompatActivity {
    private HashMap<String, Bitmap> catalog = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        // Populate catalog with initial images
       // catalog.put("image1", BitmapFactory.decodeResource(getResources(), R.drawable.image1));
       // catalog.put("image2", BitmapFactory.decodeResource(getResources(), R.drawable.image2));

        // Show catalog images

    }

    private void takePicture() {
        // Create intent to open camera app
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Start camera app and wait for result
            //startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // Get image data from camera app
            Bundle bundle = data.getExtras();
            Bitmap imageBitmap = (Bitmap) bundle.get("data");

            // Show image in catalog
            String name = "image" + (catalog.size() + 1);
            catalog.put(name, imageBitmap);
            LinearLayout catalogLayout = findViewById(R.id.catalog_layout);
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(imageBitmap);
            catalogLayout.addView(imageView);
        }
    }
}*/