package com.example.exeriversports;
import androidx.annotation.NonNull;
import  androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    // This declares variable for the Logout Button.
    Button Logout;

    // This declares variable for the Navigation bar.
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // This initialises the variable and assigns the values of the button to it.
        Logout = findViewById(R.id.btn_logout);

        // This is the listener for the 'Logout' button.
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            // This will remove all values saved in session and redirect to the login screen
            SessionManagement sessionManagement = new SessionManagement(HomeActivity.this);
            sessionManagement.removeSession();
            // This will navigate to the Login Activity page.
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            }
        });

        // This initialises a variable and assigns the values of the navigation bar to it to.
        bottomNavigationView = findViewById(R.id.bottom_navigator);
        // This sets the events item in the navigation bar to 'selected'
        bottomNavigationView.setSelectedItemId(R.id.Home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.Home:
                        return true;

                    case R.id.Profile:
                        // This navigates to the Profile Activity page
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Events:
                        // This navigates to the Events Activity page
                        startActivity(new Intent(getApplicationContext(), EventsActivity.class));
                        overridePendingTransition(0,0);
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