package com.example.exeriversports;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class WeatherActivity extends AppCompatActivity {

    // This declares the string variable 'API_KEY' and then assigns the value of the 'openweathermap.org' API key to it.
    final String API_KEY = "6f30bb3503381e3c9e2a3ee939e17d8a";

    // This declares the string variable 'WEATHER_URL' and then assigns the value of the URL of 'https://api.openweathermap.org/data/2.5/weather' to it.
    final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather";

    // This declares the long variable 'MIN_TIME' and then assigns the value of the '5000' to it.
    final long MIN_TIME = 5000;

    // This declares the float variable 'MIN_DISTANCE' and then assigns the value of the '1000' to it.
    final float MIN_DISTANCE = 1000;

    // This declares the int variable 'REQUEST_CODE' and then assigns the value of the '101' to it.
    final int REQUEST_CODE = 101;

    // This declares the String variable 'Location_Provider' and then assigns the value of the object 'LocationManager.GPS_PROVIDER' to it.
    // This is used to pass the GPS location of the users device to weather function.
    String Location_Provider = LocationManager.GPS_PROVIDER;

    // This declares the TextView variables 'Name_of_city', 'Weather_State', and 'Temperature';
    TextView Name_of_city, Weather_State, Temperature;

    // This declares the ImageView variable 'mWeather_Icon';
    ImageView mWeather_Icon;

    // This declares the LocationManager variable 'mLocationManager';
    LocationManager mLocationManager;

    // This declares the LocationListener variable 'mLocationListener';
    LocationListener mLocationListener;


    // This declares variable for the Navigation bar.
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        final EditText editText=findViewById(R.id.search_city);

        // This initialises the variables and assigns their values using 'findViewById'.
        Weather_State = findViewById(R.id.weather_condition);
        Temperature = findViewById(R.id.temp);
        mWeather_Icon = findViewById(R.id.weather_icon);
        Name_of_city = findViewById(R.id.city_name);

        // This is the editText action listener. It enables the input to be executed without needing to click a button.
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            // This is the method 'onEditorAction'.
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                // This assigns the edit.text user input to the String variable 'newCity'
                String newCity= editText.getText().toString();
                // This refreshes the page.
                Intent intent=new Intent(WeatherActivity.this,WeatherActivity.class);
                // Using 'intent.putExtra' this adds the value of the variable 'newCity' to the name 'City'.
                intent.putExtra("City",newCity);
                // This starts the intent
                startActivity(intent);
                return false;
            }
        });


        // This initialises a variable and assigns the values of the navigation bar to it to.
        bottomNavigationView = findViewById(R.id.bottom_navigator);
        // This sets the events item in the navigation bar to 'selected'
        bottomNavigationView.setSelectedItemId(R.id.Weather);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.Home:
                        // This navigates to the Home Activity page
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.Profile:
                        // This navigates to the Profile Activity page
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.Events:
                        // This navigates to the Events Activity page
                        startActivity(new Intent(getApplicationContext(), EventsActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.About:
                        // This navigates to the About Activity page
                        startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.Weather:
                        return true;
                }
                return false;
            }
        });
    }

    // When this activity is loaded or returned to this code will execute.
    @Override
    protected void onResume() {
        super.onResume();
        Intent mIntent=getIntent();
        String city= mIntent.getStringExtra("City");
        // If the value of the variable 'city' is null execute the code within the 'IF' statement.
        if(city!=null)
        {
            // This will update the weather details based of the location of the users entered city.
            getWeatherForNewCity(city);
        }
        /// If the value of the variable 'city' is not null execute the code within the 'ELSE' statement.
        else
        {
            // This will update the weather details based of the users current location.
            getWeatherForCurrentLocation();
        }
    }

    // This is the 'getWeatherForNewCity'
    private void getWeatherForNewCity(String city)
    {
        // This declares a new Parameter object 'params' from 'RequestParams' using the 'com.loopj.android:android-async-http:1.4.11' implementation in the build gradle.
        RequestParams params=new RequestParams();
        // This adds the value of the variable 'city' to the name 'q' changing the target of the weather application.
        params.put("q",city);
        // This adds the value of the variable 'API_KEY' to the name 'appid' passing the API key to the weather application.
        params.put("appid",API_KEY);
        // This calls the method 'Networking' which contains the object 'params' in its parenthesis.
        Networking(params);
    }

    // This is the method 'getWeatherForCurrentLocation'
    private void getWeatherForCurrentLocation() {
        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        mLocationListener = new LocationListener() {

            // If the user moves from their location execute this method.
            @Override
            public void onLocationChanged(Location location) {

                // This declares the String variable 'Latitude' then  retrieves the users actual latitude as a string value and assigns it to the String variable 'Latitude'.
                String Latitude = String.valueOf(location.getLatitude());

                // This declares the String variable 'Longitude' then  retrieves the users actual Longitude as a string value and assigns it to the String variable 'Longitude'.
                String Longitude = String.valueOf(location.getLongitude());

                // This declares a new Parameter object 'params' from 'RequestParams' using the 'com.loopj.android:android-async-http:1.4.11' implementation in the build gradle.
                RequestParams params = new RequestParams();
                // This stores the value of the variable 'Latitude' into the RequestParams object 'params' as 'lat'
                params.put("lat" ,Latitude);
                // This stores the value of the variable 'Longitude' into the RequestParams object 'params' as 'lon'
                params.put("lon" , Longitude);
                // This stores the value of the variable 'API_KEY' into the RequestParams object 'params' as 'app_api'
                params.put("appid" , API_KEY);
                Networking(params);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            // If the user enables location services granting access to the GPS data execute this method.
            @Override
            public void onProviderEnabled(String provider) {
                // Produce 'Toast' message "Location services enabled".
                Toast.makeText(WeatherActivity.this, "Location services enabled", Toast.LENGTH_SHORT).show();
            }

            // If the user allows location services blocking access to the GPS data execute this method.
            @Override
            public void onProviderDisabled(String provider) {
                // Produce 'Toast' message "Location services disabled".
                Toast.makeText(WeatherActivity.this, "Location services disabled", Toast.LENGTH_SHORT).show();
            }
        };

        // This is the permission checks to determine if the application has the authority to access potentially sensitive information. The permission where given in the 'AndroidManifest.xml' file
        // using 'uses-permission android:name="android.permission.INTERNET"', 'uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"' and 'uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"'
        // which grant the application permission to access the internet, sim card data and GPS data.
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this,new String[] {android.Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);
           // ActivityCompat.requestPermissions(this,new String[] {android.Manifest.permission.ACCESS_COARSE_LOCATION},REQUEST_CODE);
            return;
        }

        // This sets the minimum time passed and the minimum distance the user has traveled for application update intervals.
        mLocationManager.requestLocationUpdates(Location_Provider, MIN_TIME, MIN_DISTANCE, mLocationListener);
    }

    // The method 'onRequestPermissionsResult' requests the device GPS location data.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permission, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permission, grantResults);

        // If the requestCode equals the value of the variable 'REQUEST_CODE' execute the code in the 'IF' statement.
        if(requestCode==REQUEST_CODE)
        {
            // If the results are greater than zero and grant results element is zero permission is granted so execute the code in the 'IF' statement.
            if(grantResults.length > 0 && grantResults [0] == PackageManager.PERMISSION_GRANTED)
            {
                // Produce 'Toast' message "Location data retrieved".
                Toast.makeText(this, "Location data retrieved", Toast.LENGTH_SHORT).show();
                // execute the 'getWeatherForCurrentLocation' method.
                getWeatherForCurrentLocation();
            }
            // If the above requirements are not met execute the code in the 'ELSE' statement.
            else
            {
                // Produce 'Toast' message "Failed to retrieve location data".
                Toast.makeText(this, "Failed to retrieve location data", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // The method 'Networking 'retrieves the weather data from 'openweathermap.org' by requesting the Params object 'params' which contains the API key and the latitude and longitude of the device.
    // This is then passed to the 'client.get' function along with the variable 'WEATHER_URL' which contains the URL for the open weather map and a new JsonHttpResponseHandler is created.
    private void Networking(RequestParams params) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(WEATHER_URL, params, new JsonHttpResponseHandler() {

            // If the Networking method is successful execute the 'onSuccess' method.
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
               // super.onSuccess(statusCode, headers, response);
                Toast.makeText(WeatherActivity.this, "Weather data retrieved", Toast.LENGTH_SHORT).show();

                WeatherData weatherD = WeatherData.fromJson(response);
                updateUI(weatherD);
            }

            // If the Networking method is unsuccessful execute the 'onFailure' method.
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
               // super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(WeatherActivity.this, "Weather data retrieval failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // The 'updateUI' method updates the 'TextViews' and 'ImageViews' on the device by assigning the retrieved weather data to the variables.
    private void updateUI(WeatherData weather){

        Temperature.setText(weather.getmTemperature());
        Name_of_city.setText(weather.getmCity());
        Weather_State.setText(weather.getmWeatherType());
        int resourceID = getResources().getIdentifier(weather.getmIcon(),"drawable", getPackageName());
        mWeather_Icon.setImageResource(resourceID);
    }

    // The 'onPause' method removes the updates from the variable 'mLocationListener'.
    @Override
    protected void onPause() {
        super.onPause();
        if(mLocationManager != null)
        {
            mLocationManager.removeUpdates(mLocationListener);
        }
    }
}