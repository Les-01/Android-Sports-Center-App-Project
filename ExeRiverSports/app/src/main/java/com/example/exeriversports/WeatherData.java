package com.example.exeriversports;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherData {

    // This declares the private String variables 'mTemperature', 'mIcon', 'mCity' and 'mWeatherType'.
    private String mTemperature, mIcon, mCity, mWeatherType;

    // This declares the private integer variable 'mConditions'.
    private int mCondition;

    public static WeatherData fromJson(JSONObject jsonObject)
        {
            try
            {
                // This declares a new object 'weatherD' from 'WeatherData'.
                WeatherData weatherD = new WeatherData();

                // This retrieves the value stored in 'name' on the weather server using the API key and assigns it to the variable 'mCity' in the object 'weatherD'.
                weatherD.mCity = jsonObject.getString("name");

                // This retrieves the array value stored in 'id' on the weather server using the API key and assigns it to the variable 'mCondition' in the object 'weatherD'.
                weatherD.mCondition = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");

                // This retrieves the array value stored in 'main' on the weather server using the API key and assigns it to the variable 'mWeatherType' in the object 'weatherD'.
                weatherD.mWeatherType = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");

                // This sets uses the retrieved value stored in 'mCondition' to update the weather icon.
                weatherD.mIcon = updateWeatherIcon(weatherD.mCondition);

                // This retrieves the value stored in 'temp' on the weather server using the API key and subtracts 273.15 from it then assigns it to the variable 'tempResult' in the object 'weatherD'.
                double tempResult = jsonObject.getJSONObject("main").getDouble("temp")-273.15;

                // This declares the integer variable 'roundedValue' then uses the java method 'Math.rint' and applies it to the double variable 'tempResult' to round the double value to the closest integer
                // value (either up or down) the result of the method is then assigned to the variable 'roundedValue'.
                int roundedValue = (int)Math.rint(tempResult);

                // This converts the integer 'roundedValue' to a string and then assigns it to the variable 'mTemperature'.
                weatherD.mTemperature = Integer.toString(roundedValue);

                // This will return all of the values saved in the object 'weatherD'.
                return weatherD;
            }
            catch (JSONException e)
            {
                e.printStackTrace();
                return null;
            }
        }

        // This is the 'updateWeatherIcon' method. It execute a specific 'IF' statement based on the value of 'condition' which is retrieved from 'openweathermap.org' using an API.
        private static String updateWeatherIcon(int condition)
        {
            if(condition >= 0 && condition <=299)
            {
                return "thunder_storm";
            }
            else if (condition >= 300 && condition <=499) {

                return "light_rain";
            }
            else if (condition >= 500 && condition <=599) {

                return "shower";
            }
            else if (condition >= 600 && condition <=699) {

                return "snow";
            }
            else if (condition >= 700 && condition <=771) {

                return "fog";
            }
            else if (condition >= 772 && condition <=799) {

                return "overcast";
            }
            else if (condition == 800) {

                return "sunny";
            }
            else if (condition == 801) {

                return "overcast";
            }
            else if (condition == 802) {

                return "littlecloudy";
            }
            else if (condition >= 803 && condition <=804) {

                return "cloudy";
            }
            else if (condition >= 900 && condition <=902) {

                return "thunderstorm";
            }
            else if (condition == 903) {

                return "snow";
            }
            else if (condition == 904) {

                return "sunny";
            }
            else if (condition >= 905 && condition <=1000) {

                return "thunderstorm";
            }
            return "Unknown";
        }

        // This is the getter fro the String variable 'mTemperature'.
    public String getmTemperature() {
        return mTemperature+"°C";
    }

    // This is the getter fro the String variable 'mIcon'.
    public String getmIcon() {
        return mIcon;
    }

    // This is the getter fro the String variable 'getmCity'.
    public String getmCity() {
        return mCity;
    }

    // This is the getter fro the String variable 'getmWeatherType'.
    public String getmWeatherType() {
        return mWeatherType;
    }
}