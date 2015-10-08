package com.example.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnRem;
    TextView textResult;
    String strResult;
    String num1, num2;
    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("테이블 레이아웃 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnRem = (Button) findViewById(R.id.BtnRem);
        textResult = (TextView) findViewById(R.id.TextResult);

        btnOnclickListener(btnAdd);
        btnOnclickListener(btnSub);
        btnOnclickListener(btnMul);
        btnOnclickListener(btnDiv);
        btnOnclickListener(btnRem);

    }

    public void btnOnclickListener(Button btn) {
        switch (btn.getId()) {
            case R.id.BtnAdd:
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        num1 = edit1.getText().toString();
                        num2 = edit2.getText().toString();
                        if(!isValid())
                            return;
                        result = Double.parseDouble(num1) + Double.parseDouble(num2);
                        strResult = String.format("%.5f", result);
                        textResult.setText("계산 결과 : " + strResult);
                    }
                });
                break;

            case R.id.BtnSub:
                btnSub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        num1 = edit1.getText().toString();
                        num2 = edit2.getText().toString();
                        if(!isValid())
                            return;
                        result = Double.parseDouble(num1) - Double.parseDouble(num2);
                        strResult = String.format("%.5f", result);
                        textResult.setText("계산 결과 : " + strResult);
                    }
                });
                break;

            case R.id.BtnMul:
                btnMul.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        num1 = edit1.getText().toString();
                        num2 = edit2.getText().toString();
                        if(!isValid())
                            return;
                        result = Double.parseDouble(num1) * Double.parseDouble(num2);
                        strResult = String.format("%.5f", result);
                        textResult.setText("계산 결과 : " + strResult);
                    }
                });
                break;

            case R.id.BtnDiv:
                btnDiv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        num1 = edit1.getText().toString();
                        num2 = edit2.getText().toString();
                        if(!isValid())
                            return;
                        if(Double.parseDouble(num2) == 0.0) {
                            Toast.makeText(getApplicationContext(), "0으로 나눌 수 없음", Toast.LENGTH_LONG).show();
                            return;
                        }
                        result = Double.parseDouble(num1) / Double.parseDouble(num2);
                        strResult = String.format("%.5f", result);
                        textResult.setText("계산 결과 : " + strResult);
                    }
                });
                break;

            case R.id.BtnRem:
                btnRem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        num1 = edit1.getText().toString();
                        num2 = edit2.getText().toString();
                        if(!isValid())
                            return;
                        if(Double.parseDouble(num2) == 0.0) {
                            Toast.makeText(getApplicationContext(), "0으로 나눌 수 없음", Toast.LENGTH_LONG).show();
                            return;
                        }
                        result = Double.parseDouble(num1) % Double.parseDouble(num2);
                        strResult = String.format("%.5f", result);
                        textResult.setText("계산 결과 : " + strResult);
                    }
                });
                break;
        }
    }

    public boolean isValid() {
        if(num1.equals("") || num2.equals("")) {
            Toast.makeText(getApplicationContext(), "값이 입력되지 않음", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
            return true;
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
