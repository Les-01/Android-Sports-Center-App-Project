package com.example.exeriversports;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EventsActivity extends AppCompatActivity {

    // This declares variables for the Image Buttons.
    ImageButton Football, Rugby, Cricket, Tennis;

    // This declares variable for the Navigation bar.
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        // This initialises the variables and assigns the values of the image buttons to them.
        Football = findViewById(R.id.imageButtonF_ball);
        Rugby= findViewById(R.id.imageButtonR_ball);
        Cricket= findViewById(R.id.imageButtonC_bat);
        Tennis= findViewById(R.id.imageButtonT_racket);

        // This is the listener for the 'Football' image button.
        Football.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), F_B_TicketsActivity.class);
                startActivity(intent);
            }
        });

        // This is the listener for the 'Rugby' image button.
        Rugby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Rugby_TicketsActivity.class);
                startActivity(intent);
            }
        });

        // This is the listener for the 'Cricket' image button.
        Cricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Crick_TicketsActivity.class);
                startActivity(intent);
            }
        });

        // This is the listener for the 'Tennis' image button.
        Tennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Ten_TicketsActivity.class);
                startActivity(intent);
            }
        });

        // This initialises a variable and assigns the values of the navigation bar to it to.
        bottomNavigationView = findViewById(R.id.bottom_navigator);
        // This sets the events item in the navigation bar to 'selected'
        bottomNavigationView.setSelectedItemId(R.id.Events);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.Home:
                        // This navigates to the Home Activity page
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Profile:
                        // This navigates to the Profile Activity page
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Events:
                        return true;

                    case R.id.About:
                        // This navigates to the About Activity page
                        startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Weather:
                        // This navigates to the Weather Activity page
                        startActivity(new Intent(getApplicationContext(), WeatherActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}