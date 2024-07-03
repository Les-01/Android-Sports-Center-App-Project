package com.example.exeriversports;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AboutActivity extends AppCompatActivity {

    // This declares variable for the Navigation bar.
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // This adds 'Contact Us' email link to the about activity page.
        TextView email = (TextView) findViewById(R.id.about_email);
        // This defines the target destination of the email once the user has clicked the 'Contact Us' link.
        email.setText(Html.fromHtml("<a href=\"mailto:lez-2008@hotmail.co.uk\">Contact Us</a>"));
        email.setMovementMethod(LinkMovementMethod.getInstance());

        // This initialises a variable and assigns the values of the navigation bar to it to.
        bottomNavigationView = findViewById(R.id.bottom_navigator);
        // This sets the events item in the navigation bar to 'selected'
        bottomNavigationView.setSelectedItemId(R.id.About);
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
                        // This navigates to the Events Activity page
                        startActivity(new Intent(getApplicationContext(), EventsActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.About:
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