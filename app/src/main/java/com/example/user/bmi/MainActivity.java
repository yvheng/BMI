package com.example.user.bmi;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    TextView textViewBMI;
    EditText editTextWeight, editTextHeight;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageBMI);
        textViewBMI = (TextView)findViewById(R.id.resultText);
        editTextWeight = (EditText)findViewById(R.id.weightText);
        editTextHeight = (EditText)findViewById(R.id.heightText);
    }

    public void calculateBMI(View v){
        String hString, wString;
        double height, weight,bmi;

        hString = editTextHeight.getText().toString();
        wString = editTextWeight.getText().toString();
        height = Double.parseDouble(hString);
        weight = Double.parseDouble(wString);

        bmi = weight/(height*height);
        if(bmi <= 18.5){
            imageView.setImageResource(R.drawable.under);
            textViewBMI.setText("You're Underweight");
        }else if(bmi >= 25){
            imageView.setImageResource(R.drawable.over);
            textViewBMI.setText("You're Overweight");
        }else{
            imageView.setImageResource(R.drawable.normal);
            textViewBMI.setText("You're Normal weight");
        }
    }

    public void reset(View v){
        imageView.setImageResource(R.drawable.empty);
        textViewBMI.setText("");
        editTextHeight.setText("");
        editTextWeight.setText("");
    }
}
