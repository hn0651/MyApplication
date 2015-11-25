package com.example.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by com on 2015-11-19.
 */
public class SecondActivity extends AppCompatActivity {
    double value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("세컨드 액티비티");

        Intent inIntent = getIntent();

        switch (inIntent.getIntExtra("Operation", 0)) {
            case R.id.RdbAdd:
                value = inIntent.getDoubleExtra("Num1", 0) + inIntent.getDoubleExtra("Num2", 0);
                break;
            case R.id.RdbSub:
                value = inIntent.getDoubleExtra("Num1", 0) - inIntent.getDoubleExtra("Num2", 0);
                break;
            case R.id.RdbMul:
                value = inIntent.getDoubleExtra("Num1", 0) * inIntent.getDoubleExtra("Num2", 0);
                break;
            case R.id.RdbDiv:
                value = inIntent.getDoubleExtra("Num1", 0) / inIntent.getDoubleExtra("Num2", 0);
                break;
        }

        Button btnReturn = (Button) findViewById(R.id.BtnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Value", value);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}
