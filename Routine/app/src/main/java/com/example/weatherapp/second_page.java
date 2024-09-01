package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondPage extends AppCompatActivity {

    private TextView weatherTextView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second_page);

        // Initialize the TextView and Button
        weatherTextView = findViewById(R.id.weather_text_view);
        backButton = findViewById(R.id.back_button);

        // Apply insets for edge-to-edge support
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Retrieve the data passed from MainActivity
        String selectedDay = getIntent().getStringExtra("selectedDay");
        if (selectedDay == null) {
            selectedDay = "No day selected";
        }

        // Get weather info based on the selected day and display it
        String weatherInfo = getWeather(selectedDay);
        weatherTextView.setText(weatherInfo);

        // Set up Back button click listener
        backButton.setOnClickListener(v -> finish()); // Ends the current activity and returns to the previous one
    }

    // Method to get weather information based on the location
    private String getWeather(String location) {
        switch (location) {
            case "Sunday":
                return "1) Digital Image Processing (Room-102, Time-9:00)\n" +
                        "2) DIP Lab (Room-203, Time-10:25)\n" +
                        "3) Wireless-Networking (Room-102, Time-14:00)";
            case "Monday":
                return "No class on this day.";
            case "Tuesday":
                return "1) DIP (Room-103, Time-9:00)\n" +
                        "2) SE (Room-101, Time-10:25)\n" +
                        "3) Mobile App (Room-302, Time-14:00)";
            case "Wednesday":
                return "1) Theory of Computation (Room-202, Time-10:25)\n";
            case "Thursday":
                return "1) SW (Room-101, Time-9:15)\n" +
                        "2) SE Lab (Room-201, Time-10:25)\n" +
                        "3) WN (Room-102, Time-14:00)\n";
            default:
                return "No class available.";
        }
    }
}
