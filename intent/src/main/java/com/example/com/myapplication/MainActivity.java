package com.example.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtNum1, edtNum2;
    RadioGroup rdg;
    RadioButton rdbAdd, rdbSub, rdbMul, rdbDiv;
    Button btnNewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");

        edtNum1 = (EditText) findViewById(R.id.EdtNum1);
        edtNum2 = (EditText) findViewById(R.id.EdtNum2);
        rdg = (RadioGroup) findViewById(R.id.Rdg);
        rdbAdd = (RadioButton) findViewById(R.id.RdbAdd);
        rdbSub = (RadioButton) findViewById(R.id.RdbSub);
        rdbMul = (RadioButton) findViewById(R.id.RdbMul);
        rdbDiv = (RadioButton) findViewById(R.id.RdbDiv);
        btnNewActivity = (Button) findViewById(R.id.BtnNewActivity);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNum1 = edtNum1.getText().toString();
                String strNum2 = edtNum2.getText().toString();
                if ("".equals(strNum1) || strNum1 == null || "".equals(strNum2) || strNum2 == null){
                    Toast.makeText(getApplicationContext(), "값이 입력되지 않음", Toast.LENGTH_LONG).show();
                }

                else if (Double.parseDouble(strNum2) == 0.0 && rdg.getCheckedRadioButtonId() == R.id.RdbDiv) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다", Toast.LENGTH_LONG).show();
                    edtNum2.setText("");
                }

                else {
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    intent.putExtra("Num1", Double.parseDouble(strNum1));
                    intent.putExtra("Num2", Double.parseDouble(strNum2));
                    intent.putExtra("Operation", rdg.getCheckedRadioButtonId());
                    startActivityForResult(intent, 0);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            double result = data.getDoubleExtra("Value", 0);
            Toast.makeText(getApplicationContext(), "계산 결과 : " + result, Toast.LENGTH_LONG).show();
        }
    }
}
