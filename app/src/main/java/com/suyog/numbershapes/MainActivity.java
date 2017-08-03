package com.suyog.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    class Number {
        int number;

        public boolean isSquare(){

            double squareroot=Math.sqrt(number);

            if(squareroot==Math.floor(squareroot)){
                return true;
            }else{
                return false;
            }
        }

        public boolean isTriangular() {

            int x =1;
            int triangularnumber=1;

            while (triangularnumber < number){
                x++;
                triangularnumber=triangularnumber + x;
            }
            if(triangularnumber==number){
                return true;
            }else{
                return false;
            }
        }
    }


    public void clickFunction(View view){
        String message ="";
        EditText usernumber =(EditText) findViewById(R.id.usernumber);
        if(usernumber.getText().toString().isEmpty())
        {
            message="Please enter a number!";
        }
        else {
            Number mynumber = new Number();
            mynumber.number = Integer.parseInt(usernumber.getText().toString());


            if (mynumber.isSquare()) {
                if (mynumber.isTriangular()) {
                    message = mynumber.number + ",is both Square and Triangular";
                } else {
                    message = mynumber.number + ", is Square but not Triangular";
                }

            } else {
                if (mynumber.isTriangular()) {
                    message = mynumber.number + ",is not Square but it is Triangular";
                } else {
                    message = mynumber.number + ", is neither Square  nor Triangular";
                }

            }
        }
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
