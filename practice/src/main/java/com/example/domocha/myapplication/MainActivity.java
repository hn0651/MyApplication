package com.example.domocha.myapplication;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    EditText edtNum1, edtNum2;
    RadioGroup rdoGrp;
    RadioButton rdoAdd, rdoSub, rdoMul, rdoDiv;
    Button btnNewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");

        edtNum1 = (EditText) findViewById(R.id.edtNum1);
        edtNum2 = (EditText) findViewById(R.id.edtNum2);
        rdoGrp = (RadioGroup) findViewById(R.id.rdoGrp);
        rdoAdd = (RadioButton) findViewById(R.id.rdoAdd);
        rdoSub = (RadioButton) findViewById(R.id.rdoSub);
        rdoMul = (RadioButton) findViewById(R.id.rdoMul);
        rdoDiv = (RadioButton) findViewById(R.id.rdoDiv);
        btnNewActivity = (Button) findViewById(R.id.btnNewActivity);


        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtNum2.getText().toString().equals("0")) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다", Toast.LENGTH_LONG).show();
                    edtNum2.setText("");
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                    intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));
                    intent.putExtra("Operation", rdoGrp.getCheckedRadioButtonId());
                    startActivityForResult(intent, 0);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            int result = data.getIntExtra("Value", 0);
            Toast.makeText(getApplicationContext(), "계산 결과 : " + result, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
