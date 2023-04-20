package com.example.p2plantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;


//public class Itempage extends AppCompatActivity { //The Itempage class extends AppCompatActivity
    //which means the Itempage class is a subclass of the AppCompatActivity superclass.
    //Itempage as a subclass therefore inherits all members of the AppCompatActivity superclass.
    //@Override //@ denotes an annotation, telling the compiler that, in this case,
    //a method is being overriden.
        //Method overriding, when a subclass provides its own implementation of a method it
        //inherited from and was already defined in its superclass.
            //Overriding only works when the method signatures are identical.
        //A method's signature includes: access modifier, return type,
        //selector, which is its identifier or name, and parameter type.


public class Itempage extends AppCompatActivity {

    public static ImageView NamePicture;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itempage);


        ImageView imageView = (ImageView) findViewById(R.id.Named);

        Bitmap imageBitmap = getIntent().getParcelableExtra("Image");

        imageView.setImageBitmap(imageBitmap);



    }
}