package com.example.exeriversports;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class F_B_TicketsActivity extends AppCompatActivity {

    // This declares variables for the ticket buttons.
    Button Adult_Ticket_Btn, Child_Ticket_Btn, Member_Ticket_Btn, Front_Row_Btn, Middle_Row_Btn, Back_Row_Btn, Meal_Deal_Btn, VIP_Btn, Tour_Btn, Buy_Btn;

    // This declares variable to hold the decorator pattern results.
    Ticket Custom_Ticket;

    // This declares the String variables for ticket receipt information.
    String TotPrc = "Total Price: £", CusTick = "Custom Football Ticket\n";

    // This declares the Boolean variables for to determine which buttons have been pressed.
    Boolean A_T = false, C_T = false, M_T = false, F_R = false, M_R = false, B_R = false, M_D = false, V_P = false, T_O = false;

    // This declares variable for the Navigation bar.
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb_tickets);

        // This initialises the variables and assigns the values of the buttons to them.
        Adult_Ticket_Btn = findViewById(R.id.btn_adult_ticket);
        Child_Ticket_Btn = findViewById(R.id.btn_child_ticket);
        Member_Ticket_Btn = findViewById(R.id.btn_member_ticket);
        Front_Row_Btn = findViewById(R.id.btn_front_row);
        Middle_Row_Btn = findViewById(R.id.btn_middle_row);
        Back_Row_Btn = findViewById(R.id.btn_back_row);
        Meal_Deal_Btn = findViewById(R.id.btn_meal_deal);
        VIP_Btn = findViewById(R.id.btn_vip);
        Tour_Btn = findViewById(R.id.btn_tour);
        Buy_Btn = findViewById(R.id.btn_purchase);

        // This is the listener for the 'Adult_Ticket_Btn' button
        Adult_Ticket_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // This sets the button clicked as enabled false and two other buttons as enabled true, effectively blanking out the buttons not selected.
                Child_Ticket_Btn.setEnabled(true);
                Member_Ticket_Btn.setEnabled(true);
                Adult_Ticket_Btn.setEnabled(false);
                // This sets the boolean variable that represents the button clicked as true and the boolean variable that represents the two other buttons as false.
                A_T = true;
                C_T = false;
                M_T = false;
            }
        });

        // This is the listener for the 'Child_Ticket_Btn' button
        Child_Ticket_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // This sets the button clicked as enabled false and two other buttons as enabled true, effectively blanking out the buttons not selected.
                Adult_Ticket_Btn.setEnabled(true);
                Member_Ticket_Btn.setEnabled(true);
                Child_Ticket_Btn.setEnabled(false);
                // This sets the boolean variable that represents the button clicked as true and the boolean variable that represents the two other buttons as false.
                A_T = false;
                C_T = true;
                M_T = false;
            }
        });

        // This is the listener for the 'Member_Ticket_Btn' button
        Member_Ticket_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // This sets the button clicked as enabled false and two other buttons as enabled true, effectively blanking out the buttons not selected.
                Adult_Ticket_Btn.setEnabled(true);
                Child_Ticket_Btn.setEnabled(true);
                Member_Ticket_Btn.setEnabled(false);
                // This sets the boolean variable that represents the button clicked as true and the boolean variable that represents the two other buttons as false.
                A_T = false;
                C_T = false;
                M_T = true;
            }
        });

        // This is the listener for the 'Front_Row_Btn' button
        Front_Row_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // This sets the button clicked as enabled false and two other buttons as enabled true, effectively blanking out the buttons not selected.
                Middle_Row_Btn.setEnabled(true);
                Back_Row_Btn.setEnabled(true);
                Front_Row_Btn.setEnabled(false);
                // This sets the boolean variable that represents the button clicked as true and the boolean variable that represents the two other buttons as false.
                F_R = true;
                M_R = false;
                B_R = false;
            }
        });

        // This is the listener for the 'Middle_Row_Btn' button
        Middle_Row_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // This sets the button clicked as enabled false and two other buttons as enabled true, effectively blanking out the buttons not selected.
                Front_Row_Btn.setEnabled(true);
                Back_Row_Btn.setEnabled(true);
                Middle_Row_Btn.setEnabled(false);
                // This sets the boolean variable that represents the button clicked as true and the boolean variable that represents the two other buttons as false.
                F_R = false;
                M_R = true;
                B_R = false;
            }
        });

        // This is the listener for the 'Back_Row_Btn' button
        Back_Row_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // This sets the button clicked as enabled false and two other buttons as enabled true, effectively blanking out the buttons not selected.
                Front_Row_Btn.setEnabled(true);
                Middle_Row_Btn.setEnabled(true);
                Back_Row_Btn.setEnabled(false);
                // This sets the boolean variable that represents the button clicked as true and the boolean variable that represents the two other buttons as false.
                F_R = false;
                M_R = false;
                B_R = true;
            }
        });

        // This is the listener for the 'Meal_Deal_Btn' button
        Meal_Deal_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // This sets the button clicked as enabled false blanking it out.
                Meal_Deal_Btn.setEnabled(false);
                // This sets the boolean variable that represents the button clicked as true.
                M_D = true;
            }
        });

        // This is the listener for the 'VIP_Btn' button
        VIP_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // This sets the button clicked as enabled false blanking it out.
                VIP_Btn.setEnabled(false);
                // This sets the boolean variable that represents the button clicked as true.
                V_P = true;
            }
        });

        // This is the listener for the 'Tour_Btn' button
        Tour_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // This sets the button clicked as enabled false blanking it out.
                Tour_Btn.setEnabled(false);
                // This sets the boolean variable that represents the button clicked as true.
                T_O = true;
            }
        });

        // Below is the onclick listener for the buy button, here is where the decorator pattern is implemented.
        // The Decorator pattern enables the changing of an object’s behaviour at runtime, this design pattern enables the assembly of fully customisable tickets through a process of ‘wrapping’,
        // where one object wraps around another object such as the ‘Front_Row_Section’ object wrapping around the ‘Adult_Ticket’ object effectively creating a ‘Front_Row_Section_Adult_Ticket’ at run time.
        // Each object is of a class, and each class has its own set description and cost along with its own ‘getDescription’ and ‘getCost’ methods. As each object is called and ‘wrapped’ its individual
        // description and cost values are concatenated within the respective method, enabling the final method call to produce the total value of both the String ‘description’ from all the objects called
        // and the total Integer ‘cost’ from all the objects called with the integer value being combined through addition rather than concatenation resulting in the total price of all the objects combined.

         //This is the listener for the 'Buy_Btn' button
        Buy_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Decorators
                // Adult ticket decorator, front row section, no add ons.

                // Adult ticket / front row section.
                if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Front_Row_Section(new Adult_Ticket());
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket decorator, front row section, one add on.

                // Adult ticket / front row section / meal deal.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Front_Row_Section(new Adult_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket / front row section / vip.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Front_Row_Section(new Adult_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket / front row section / grounds tour.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Front_Row_Section(new Adult_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket decorator, front row section, two add ons.

                // Adult ticket / front row section / meal deal / VIP.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Meal_Deal(new Front_Row_Section(new Adult_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket / front row section / meal deal / tour.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Meal_Deal(new Front_Row_Section(new Adult_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket / front row section / vip / tour.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new VIP_Access(new Front_Row_Section(new Adult_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket decorator, front row section, three add ons.

                // Adult ticket / front row section / meal deal / vip / tour
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Grounds_Tour(new VIP_Access(new Front_Row_Section(new Adult_Ticket()))));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket decorator, middle row section, no add ons.

                // Adult ticket / middle row section.
                if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Middle_Row_Section(new Adult_Ticket());
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket decorator, middle row section, one add on.

                // Adult ticket / middle row section / meal deal.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Middle_Row_Section(new Adult_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket / middle row section / vip.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Middle_Row_Section(new Adult_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket / middle row section / grounds tour.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Middle_Row_Section(new Adult_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket decorator, middle row section, two add ons.

                // Adult ticket / middle row section / meal deal / VIP.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Meal_Deal(new Middle_Row_Section(new Adult_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket / middle row section / meal deal / tour.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Meal_Deal(new Middle_Row_Section(new Adult_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket / middle row section / vip / tour.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new VIP_Access(new Middle_Row_Section(new Adult_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket decorator, middle row section, three add ons.

                // Adult ticket / middle row section / meal deal / vip / tour
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Grounds_Tour(new VIP_Access(new Middle_Row_Section(new Adult_Ticket()))));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket decorator, back row section, no add ons.

                // Adult ticket / back row section.
                if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Back_Row_Section(new Adult_Ticket());
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket decorator, back row section, one add on.

                // Adult ticket / back row section / meal deal.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Back_Row_Section(new Adult_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket / back row section / vip.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Back_Row_Section(new Adult_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket / back row section / grounds tour.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Back_Row_Section(new Adult_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket decorator, back row section, two add ons.

                // Adult ticket / back row section / meal deal / VIP.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Meal_Deal(new Back_Row_Section(new Adult_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket / back row section / meal deal / tour.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Meal_Deal(new Back_Row_Section(new Adult_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket / back row section / vip / tour.
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new VIP_Access(new Back_Row_Section(new Adult_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Adult ticket decorator, back row section, three add ons.

                // Adult ticket / back row section / meal deal / vip / tour
                else if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Grounds_Tour(new VIP_Access(new Back_Row_Section(new Adult_Ticket()))));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Decorators
                // Child ticket decorator, front row section, no add ons.

                // Child ticket / front row section.
                if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Front_Row_Section(new Child_Ticket());
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket decorator, front row section, one add on.

                // Child ticket / front row section / meal deal.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Front_Row_Section(new Child_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket / front row section / vip.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Front_Row_Section(new Child_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket / front row section / grounds tour.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Front_Row_Section(new Child_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket decorator, front row section, two add ons.

                // Child ticket / front row section / meal deal / VIP.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Meal_Deal(new Front_Row_Section(new Child_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket / front row section / meal deal / tour.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Meal_Deal(new Front_Row_Section(new Child_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket / front row section / vip / tour.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new VIP_Access(new Front_Row_Section(new Child_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket decorator, front row section, three add ons.

                // Child ticket / front row section / meal deal / vip / tour
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Grounds_Tour(new VIP_Access(new Front_Row_Section(new Child_Ticket()))));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket decorator, middle row section, no add ons.

                // Child ticket / middle row section.
                if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Middle_Row_Section(new Child_Ticket());
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket decorator, middle row section, one add on.

                // Child ticket / middle row section / meal deal.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Middle_Row_Section(new Child_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket / middle row section / vip.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Middle_Row_Section(new Child_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket / middle row section / grounds tour.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Middle_Row_Section(new Child_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket decorator, middle row section, two add ons.

                // Child ticket / middle row section / meal deal / VIP.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Meal_Deal(new Middle_Row_Section(new Child_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket / middle row section / meal deal / tour.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Meal_Deal(new Middle_Row_Section(new Child_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket / middle row section / vip / tour.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new VIP_Access(new Middle_Row_Section(new Child_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket decorator, middle row section, three add ons.

                // Child ticket / middle row section / meal deal / vip / tour
                else if (((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(true) ))))))))))){
                    Custom_Ticket = new Meal_Deal(new Grounds_Tour(new VIP_Access(new Middle_Row_Section(new Child_Ticket()))));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket decorator, back row section, no add ons.

                // Child ticket / back row section.
                if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Back_Row_Section(new Child_Ticket());TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket decorator, back row section, one add on.

                // Child ticket / back row section / meal deal.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Back_Row_Section(new Child_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket / back row section / vip.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Back_Row_Section(new Child_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket / back row section / grounds tour.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Back_Row_Section(new Child_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket decorator, back row section, two add ons.

                // Child ticket / back row section / meal deal / VIP.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Meal_Deal(new Back_Row_Section(new Child_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket / back row section / meal deal / tour.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Meal_Deal(new Back_Row_Section(new Child_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket / back row section / vip / tour.
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new VIP_Access(new Back_Row_Section(new Child_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Child ticket decorator, back row section, three add ons.

                // Child ticket / back row section / meal deal / vip / tour
                else if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Grounds_Tour(new VIP_Access(new Back_Row_Section(new Child_Ticket()))));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Decorators
                // Member ticket decorator, front row section, no add ons.

                // Child ticket / front row section.
                if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Front_Row_Section(new Child_Ticket());
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket / front row section.
                if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Front_Row_Section(new Member_Ticket());
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket decorator, front row section, one add on.

                // Member ticket / front row section / meal deal.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Front_Row_Section(new Member_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket / front row section / vip.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Front_Row_Section(new Member_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket / front row section / grounds tour.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Front_Row_Section(new Member_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket decorator, front row section, two add ons.

                // Member ticket / front row section / meal deal / VIP.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Meal_Deal(new Front_Row_Section(new Member_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket / front row section / meal deal / tour.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Meal_Deal(new Front_Row_Section(new Member_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket / front row section / vip / tour.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new VIP_Access(new Front_Row_Section(new Member_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket decorator, front row section, three add ons.

                // Member ticket / front row section / meal deal / vip / tour
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Grounds_Tour(new VIP_Access(new Front_Row_Section(new Member_Ticket()))));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket decorator, middle row section, no add ons.

                // Member ticket / middle row section.
                if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Middle_Row_Section(new Member_Ticket());
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket decorator, middle row section, one add on.

                // Member ticket / middle row section / meal deal.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Middle_Row_Section(new Member_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket / middle row section / vip.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Middle_Row_Section(new Member_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket / middle row section / grounds tour.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Middle_Row_Section(new Member_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket decorator, middle row section, two add ons.

                // Member ticket / middle row section / meal deal / VIP.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Meal_Deal(new Middle_Row_Section(new Member_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket / middle row section / meal deal / tour.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Meal_Deal(new Middle_Row_Section(new Member_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket / middle row section / vip / tour.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new VIP_Access(new Middle_Row_Section(new Member_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket decorator, middle row section, three add ons.

                // Member ticket / middle row section / meal deal / vip / tour
                else if (((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(true) ))))))))))){
                    Custom_Ticket = new Meal_Deal(new Grounds_Tour(new VIP_Access(new Middle_Row_Section(new Member_Ticket()))));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket decorator, back row section, no add ons.

                // Member ticket / back row section.
                if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Back_Row_Section(new Member_Ticket());
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket decorator, back row section, one add on.

                // Member ticket / back row section / meal deal.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Back_Row_Section(new Member_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket / back row section / vip.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Back_Row_Section(new Member_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket / back row section / grounds tour.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Back_Row_Section(new Member_Ticket()));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket decorator, back row section, two add ons.

                // Member ticket / back row section / meal deal / VIP.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(false) )))))))))){
                    Custom_Ticket = new VIP_Access(new Meal_Deal(new Back_Row_Section(new Member_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket / back row section / meal deal / tour.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(false) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new Meal_Deal(new Back_Row_Section(new Member_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket / back row section / vip / tour.
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(false) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Grounds_Tour(new VIP_Access(new Back_Row_Section(new Member_Ticket())));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Member ticket decorator, back row section, three add ons.

                // Member ticket / back row section / meal deal / vip / tour
                else if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true) && (M_D.equals(true) && (V_P.equals(true) && (T_O.equals(true) )))))))))){
                    Custom_Ticket = new Meal_Deal(new Grounds_Tour(new VIP_Access(new Back_Row_Section(new Member_Ticket()))));
                    TextView desc = findViewById(R.id.desc);
                    TextView cost = findViewById(R.id.cost);
                    desc.setText(CusTick + Custom_Ticket.getDescription());
                    cost.setText(TotPrc + Custom_Ticket.getCost());
                }

                // Invalid ticket selections.

                // Adult ticket / no section.
                if ((A_T.equals(true) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(false)))))))){
                    Toast.makeText(F_B_TicketsActivity.this, "Select a Section", Toast.LENGTH_SHORT).show();
                }

                // Child ticket / no section.
                if ((A_T.equals(false) && (C_T.equals(true) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(false)))))))){
                    Toast.makeText(F_B_TicketsActivity.this, "Select a Section", Toast.LENGTH_SHORT).show();
                }

                // Member ticket / no section.
                if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(true) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(false)))))))){
                    Toast.makeText(F_B_TicketsActivity.this, "Select a Section", Toast.LENGTH_SHORT).show();
                }

                // No ticket / front section
                if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(true) && (M_R.equals(false) && (B_R.equals(false)))))))){
                    Toast.makeText(F_B_TicketsActivity.this, "Select ticket type", Toast.LENGTH_SHORT).show();
                }

                // No ticket / middle section
                if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(true) && (B_R.equals(false)))))))){
                    Toast.makeText(F_B_TicketsActivity.this, "Select ticket type", Toast.LENGTH_SHORT).show();
                }

                // No ticket / back section
                if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(true)))))))){
                    Toast.makeText(F_B_TicketsActivity.this, "Select ticket type", Toast.LENGTH_SHORT).show();
                }

                // Addon selected but no other properties
                if ((A_T.equals(false) && (C_T.equals(false) && (M_T.equals(false) && (F_R.equals(false) && (M_R.equals(false) && (B_R.equals(false) && (M_D.equals(true) || (V_P.equals(true) || (T_O.equals(true) )))))))))){
                    Toast.makeText(F_B_TicketsActivity.this, "Select Ticket Type", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // This initialises a variable and assigns the values of the navigation bar to it to.
        bottomNavigationView = findViewById(R.id.bottom_navigator);
        // This sets the events item in the navigation bar to 'selected'
        bottomNavigationView.setSelectedItemId(R.id.Events);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                // This determines wht happens when each navigation bar button is pressed
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
    }}