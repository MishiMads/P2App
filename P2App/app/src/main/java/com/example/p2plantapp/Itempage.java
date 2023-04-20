package com.example.p2plantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class Itempage extends AppCompatActivity {

    //The Itempage class extends AppCompatActivity which means the Itempage class is a subclass
    //of the AppCompatActivity superclass.
    //Itempage as a subclass therefore inherits all members of the AppCompatActivity superclass.
    //@Override //@ denotes an annotation, telling the compiler that, in this case,
    //a method is being overriden.
    //Method overriding, when a subclass provides its own implementation of a method it
    //inherited from and was already defined in its superclass.
    //Overriding only works when the method signatures are identical.
    //A method's signature includes: access modifier, return type,
    //selector, which is its identifier or name, and parameter type.

    public static ImageView NamePicture;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        //A method with the selector onCreate
        //and has single parameter of type Bundle. When implemented, it takes a Bundle argument and
        //assigns it to the savedInstanceState variable.
        //Bundle is a type of variable used to passed data between activities.
        //A protected method which means
        //that the method is only accessible within the class that defines them and its subclasses.
        //They are not accessible from outside the class hierarchy.

        super.onCreate(savedInstanceState);

        //Calls the superclass implementation of the onCreate()
        //method which it inherits from Itempage's superclass, AppCompatActivity, using the super
        //keyword. The savedInstanceState variable is passed into the onCreate() method, which
        //retrieves previously saved data and restores the activity's state to its previous state.

        setContentView(R.layout.activity_itempage);

        ImageView imageView = (ImageView) findViewById(R.id.Named);

        Bitmap imageBitmap = getIntent().getParcelableExtra("Image");

        imageView.setImageBitmap(imageBitmap);



    }
}