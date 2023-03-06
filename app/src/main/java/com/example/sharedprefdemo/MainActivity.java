package com.example.sharedprefdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText editText;
    public RadioGroup radioGroup;
    public RadioButton rbSmartCar;
    public RadioButton rbSedan;
    public RadioButton rbMinivan;
    public Button btnEstimate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize variables
        editText = findViewById(R.id.etEnterMiles);
        radioGroup = findViewById(R.id.radioGroupCars);
        rbSmartCar = findViewById(R.id.rbSmartCar);
        rbSedan = findViewById(R.id.rbSedan);
        rbMinivan = findViewById(R.id.rbMinivan);
        btnEstimate = findViewById(R.id.btnEstimate);

        int initialFee = 3;
        double mileageRate = 3.25;


//        View.OnClickListener first_radio_listener = new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                double totalFees = initialFee + 2.0; //plus $2 for smart car
//            }
//        };
//        rbSmartCar.setOnClickListener(first_radio_listener);
//
//        View.OnClickListener second_radio_listener = new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                double totalFees = initialFee; //nothing added in the sedan case
//            }
//        };
//        rbSedan.setOnClickListener(second_radio_listener);
//
//        View.OnClickListener third_radio_listener = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                double totalFees = initialFee + 5.0; //add $5 in minivan case
//            }
//        };
//        rbMinivan.setOnClickListener(third_radio_listener);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup rg, int checkedID){
                RadioButton rb = findViewById(checkedID);
                Toast.makeText(getApplicationContext(), rb.getText(), Toast.LENGTH_SHORT).show();
                double totalFees;

                switch(rb.getText().toString()) {
                    case "Smart Car":
                        totalFees = initialFee + 2.0; //plus $2 for smart car
                        break;
                    case "Sedan":
                        totalFees = initialFee + 0.0; //nothing added in sedan case
                        break;
                    case "Minivan":
                        totalFees = initialFee + 5.0; //plus $5 for minivan
                        break;
                }
            }
        });


        btnEstimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int totalMiles = Integer.parseInt(editText.getText().toString());
                double result = totalMiles * 3.25;
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("myString", "Hello, World");
        editor.apply();



    }


}