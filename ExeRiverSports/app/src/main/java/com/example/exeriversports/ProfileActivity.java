package com.example.exeriversports;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    // This declares variables for the users entered text.
    EditText fName, lName, password, rePassword;

    // This declares variables for the buttons entered text.
    Button Update, Delete, Select;
    // This declares variable for the Database.

    // This declares variable for the Database.
    DBFunctions DB;

    // This declares variable for the Navigation bar.
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // This declares a new object called 'sessionManagement' of class 'SessionManagement' on this page.
        SessionManagement sessionManagement = new SessionManagement(ProfileActivity.this);
        // This uses the method 'getSession()' to get the value stored in the object 'sessionManagement' and assigns the value to the String variable 'Email'
        String Email = sessionManagement.getSession();

        // This displays the logged in users email address in the textview called 'test'
        TextView test = findViewById(R.id.test);
        test.setText(Email);

        // This initialises the variables and assigns the values entered by the user to them.
        fName = findViewById(R.id.fName);
        lName = findViewById(R.id.lName);
        password = findViewById(R.id.password);
        rePassword = findViewById(R.id.rePassword);
        Update = findViewById(R.id.btnUpdate);
        Delete = findViewById(R.id.btnDelete);
        Select = findViewById(R.id.btnSelect);
        DB = new DBFunctions(this);

        // This is the listener for the 'Update' button
        Update.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String FirstName = fName.getText().toString();
                String LastName = lName.getText().toString();
                String Password = password.getText().toString();
                String RePassword = rePassword.getText().toString();

                // If any of the string variables are empty, execute the toast message.
                if(FirstName.equals("") || LastName.equals("") || Email.equals("") || Password.equals("") || RePassword.equals(""))
                    Toast.makeText(ProfileActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    // If none of the string variables are empty execute the code in the 'ELSE' statement/
                else
                {
                    // If the values stored in the string variables 'Password' and 'RePassword' match execute the code within the 'IF statement'.
                    if(Password.equals(RePassword))
                    {
                        // The 'checkupdatedata' function will select the record from the database that matches the users email (stored in session) and update the users details
                        Boolean checkupdatedata = DB.updateData(FirstName, LastName, Email, Password);
                        if (checkupdatedata == true) {
                            Toast.makeText(ProfileActivity.this, "Member details updated", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(ProfileActivity.this, "No record found to update", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(ProfileActivity.this, "Passwords don't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // This is the listener for the 'Delete' button
        Delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // The 'checkdeletedata' function will select the record from the database that matches the users email (stored in session) and delete them.
                        Boolean checkdeletedata = DB.deleteData(Email);
                        if (checkdeletedata == true)
                        {
                            Toast.makeText(ProfileActivity.this, "Member details deleted", Toast.LENGTH_SHORT).show();

                            // This will remove all values saved in session and redirect to the login screen
                            SessionManagement sessionManagement = new SessionManagement(ProfileActivity.this);
                            sessionManagement.removeSession();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                        } else
                        {
                            Toast.makeText(ProfileActivity.this, "No record found to delete", Toast.LENGTH_SHORT).show();
                        }
            }
        });

        // This is the listener for the 'Select' button
        Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                // The 'Cursor' interface will select the record from the database that matches the users email (stored in session).
                Cursor res = DB.getdata(Email);
                // If the result equals zero execute the code within the 'IF statement'
                if(res.getCount()==0)
                {
                    Toast.makeText(ProfileActivity.this, "No record found", Toast.LENGTH_SHORT).show();
                    return;
                }
                // This implements the 'StringBuffer' to retrieve and store the result of the 'Cursor' interface if the result is not equal to zero.
                StringBuffer buffer = new StringBuffer();
                // This while loop will loop through each result in numerical order.
                while(res.moveToNext())
                {
                    buffer.append("Email :"+res.getString(0)+"\n");
                    buffer.append("First Name :"+res.getString(1)+"\n");
                    buffer.append("Last name :"+res.getString(2)+"\n");
                    buffer.append("Password :"+res.getString(3)+"\n\n\n");
                }

                // This will implement an 'AlertDialog' box that will pop up and display the data stored in the buffer.
                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Members List");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

            // This initialises a variable and assigns the values of the navigation bar to it to.
            bottomNavigationView = findViewById(R.id.bottom_navigator);
            // This sets the events item in the navigation bar to 'selected'
            bottomNavigationView.setSelectedItemId(R.id.Profile);
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