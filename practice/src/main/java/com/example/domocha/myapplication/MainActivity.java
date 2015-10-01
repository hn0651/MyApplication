package com.example.domocha.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    Switch switchAgree;
    RadioGroup rGroup1;
    RadioButton rdoJlb, rdoKtk, rdoLlp;
    Button btnExit, btnReset;
    ImageView imgAdr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("안드로이드 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        switchAgree = (Switch) findViewById(R.id.SwitchAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rdoJlb = (RadioButton) findViewById(R.id.RdoJlb);
        rdoKtk = (RadioButton) findViewById(R.id.RdoKtk);
        rdoLlp = (RadioButton) findViewById(R.id.RdoLlp);

        btnExit = (Button) findViewById(R.id.BtnExit);
        imgAdr = (ImageView) findViewById(R.id.ImgPet);
        btnReset = (Button) findViewById(R.id.BtnReset);


        switchAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switchAgree.isChecked() == true) {
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnExit.setVisibility(View.VISIBLE);
                    btnReset.setVisibility(View.VISIBLE);
                    imgAdr.setVisibility(View.VISIBLE);
                }
                else {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnExit.setVisibility(View.INVISIBLE);
                    btnReset.setVisibility(View.INVISIBLE);
                    imgAdr.setVisibility(View.INVISIBLE);
                }
            }
        });

        rdoJlb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgAdr.setImageResource(R.drawable.jellybean);
            }
        });

        rdoKtk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgAdr.setImageResource(R.drawable.kitkat);
            }
        });

        rdoLlp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgAdr.setImageResource(R.drawable.lollipop);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                switchAgree.setChecked(false);
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
