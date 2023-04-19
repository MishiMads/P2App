package com.example.p2plantapp;
import android.graphics.Bitmap;
import java.util.HashMap;

public class Birds {
    private static HashMap<String, Bitmap> birdMap = new HashMap<>();

    public static void addBird(String key, Bitmap bitmap) {
        birdMap.put(key, bitmap);
    }

    public static Bitmap getBird(String key) {
        return birdMap.get(key);
    }

}
