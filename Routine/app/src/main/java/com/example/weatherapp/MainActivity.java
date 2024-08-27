package com.example.weatherapp; // Replace with your actual package name

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner locationSpinner;
    private Button getWeatherButton;
    private TextView weatherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure this matches your XML layout file

        // Initialize UI components
        locationSpinner = findViewById(R.id.location_spinner);
        getWeatherButton = findViewById(R.id.get_weather_button);
        weatherTextView = findViewById(R.id.weather_text_view);

        // Set up Spinner with location options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.days, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(adapter);

        // Set up Button click listener
        getWeatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedLocation = locationSpinner.getSelectedItem().toString();
                String weather = getWeather(selectedLocation);
                weatherTextView.setText(weather);
            }
        });
    }

    // Method to get weather information based on the location
    private String getWeather(String location) {
        switch (location) {
            case "Sunday":
                return " 1)Digital Image Processing(Room-102,Time-9.00)\n2)DIP Lab(Room-203,Time-10:25)\n3)Wireless-Networking(Room-102,Time-2.00)";
            case "Monday":
                return "No class in this day";
            case "Tuesday":
                return "1)DIP(Room-103,time-9.00)\n2)SE(room-101,time-10.25\n3)Mobile App(Room-302,Time-2.00)";
            case "Wednesday":
                return "1)Theory of computation(Room-202,Time-10.25)\n";
            case "Thursday":
                return "1)SW(Room-101,Time-9.15)\n2)SE Lab(Room-201,Time-10.25)\n3)WN(Room-102,Time-2.00)\n";

            default:
                return "No class available.";
        }
    }
}
