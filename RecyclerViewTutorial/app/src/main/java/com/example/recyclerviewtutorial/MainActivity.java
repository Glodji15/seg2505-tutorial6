package com.example.recyclerviewtutorial;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the RecyclerView in the layout.
        recyclerView = findViewById(R.id.recyclerView);

        // Arrange the items vertically
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );
        //Create the data to display
        String [] dataSet = {"Glory",
                "Martine",
                "Joseph",
                "Victo",
                "Sonya",
                "Deo",
                "Hippo",
                "Emma",
                "Dish",
                "Olivia",
                "Noah",
                "Christ"};
        // Connect the data to the RecyclerView.
        adapter = new CustomAdapter(dataSet);
        recyclerView.setAdapter(adapter);

        // Display items in a vertical list.
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
