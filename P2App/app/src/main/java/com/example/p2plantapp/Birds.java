package com.example.p2plantapp;
import android.graphics.Bitmap;
import java.util.HashMap;

public class Birds {
    //Hashmap for the collection of pictures including their user-inputted names.
    private static HashMap<String, Bitmap> birdMap = new HashMap<>();
    //A hashmap is created with the variable name birdMap
    //with String as its key and Bitmap as its value.
    //The birdMap Hashmap is a private static, meaning it can only be accessed
    //by the methods of this specific class and no other classes.
        //Private: only methods of the same class can access this member.
        //Static: only one instance of this hashmap exists across all instances of the Birds class.
            //I.e multiple instances of the Birds class share the same (this) hashmap named birdMap.

    public static void addBird(String key, Bitmap bitmap) {
        birdMap.put(key, bitmap);
    }
    //A method with the selector "addBird" that has two parameters: a String and a Bitmap variable.
    //When implemented, it takes the String and Bitmap arguments and assigns them to the "key" and
    //"bitmap" variables.
    //In the code block, the .put() method in the hashmap class is used to take the values from
    //the method parameters and add them as a key-value pair entry in the birdMap hashmap.
    //This method is public and static with a return type of void:
        //Public: accessible from anywhere in the program.
            //They can be accessed by objects of the class, as well as objects of other classes
        //Static: method belongs to the class itself rather than instances of the class.
            //Also means the method can be called without creating an instance of the class.
        //Void: the method does not return anything after being executed.

    public static Bitmap getBird(String key) {
        return birdMap.get(key);
    }
    //WIP...

}
