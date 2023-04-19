package com.example.p2plantapp;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SearchView;
import android.graphics.Bitmap;
import java.util.HashMap;

public class Search extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        SearchView searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Perform search operation here
                // if fugle.containsKey(query) {
                //      image = fugle.get(query)
                //       vis billede halløj
                // }
                // else -> hav et tekstfelt der siger ingenting og et placeholderbillede i billedefeltet

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filter the data set based on the search query
                return false;
            }
        });

    }




}