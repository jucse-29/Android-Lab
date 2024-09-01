package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast; // Use Toast for displaying information
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner locationSpinner;
    private Button getWeatherButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        locationSpinner = findViewById(R.id.location_spinner);
        getWeatherButton = findViewById(R.id.get_weather_button);

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

                // Display the selected day using a Toast (Optional)
                Toast.makeText(MainActivity.this, "Selected: " + selectedLocation, Toast.LENGTH_LONG).show();

                // Create an intent to start SecondPage activity
                Intent intent = new Intent(MainActivity.this, SecondPage.class);
                intent.putExtra("selectedDay", selectedLocation); // Pass data to SecondPage
                startActivity(intent);
            }
        });
    }
}
