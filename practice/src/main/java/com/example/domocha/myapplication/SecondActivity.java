package com.example.domocha.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by DoMoCha on 2015-11-17.
 */
public class SecondActivity extends AppCompatActivity {
    int value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("세컨드 액티비티");

        Intent inIntent = getIntent();

        switch (inIntent.getIntExtra("Operation", 0)) {
            case R.id.rdoAdd:
                value = inIntent.getIntExtra("Num1", 0) + inIntent.getIntExtra("Num2", 0);
                break;
            case R.id.rdoSub:
                value = inIntent.getIntExtra("Num1", 0) - inIntent.getIntExtra("Num2", 0);
                break;
            case R.id.rdoMul:
                value = inIntent.getIntExtra("Num1", 0) * inIntent.getIntExtra("Num2", 0);
                break;
            case R.id.rdoDiv:
                value = inIntent.getIntExtra("Num1", 0) / inIntent.getIntExtra("Num2", 0);
                break;
        }

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
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
