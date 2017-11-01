package com.example.notepadby.lesson8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int percentVal = 0;
    private EditText input = null;
    private SeekBar seek = null;
    private TextView percent = null;
    private TextView tax = null;
    private TextView total = null;
    private Button pay = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.input);
        seek = (SeekBar)findViewById(R.id.seek);
        percent = (TextView)findViewById(R.id.percent);
        tax = (TextView)findViewById(R.id.tax);
        total = (TextView)findViewById(R.id.total);
        pay = (Button)findViewById(R.id.pay);
        input.setText("0");
        seek.setMax(100);
        Toast.makeText(this, "Hello!", Toast.LENGTH_LONG).show();
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                redraw(Integer.valueOf(input.getText().toString()));
                percentVal = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().isEmpty()){
                    return;
                }
                redraw(Integer.valueOf(input.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void redraw(int sum){
        if (sum == 0){
            tax.setVisibility(View.INVISIBLE);
            total.setVisibility(View.INVISIBLE);
        }else{
            tax.setVisibility(View.VISIBLE);
            total.setVisibility(View.VISIBLE);
            percent.setText(percentVal + "%");
            tax.setText(Math.round((float)sum*((double)percentVal/100)*100)/100.0 + "");
            float totalSum = (float)sum + Float.valueOf(tax.getText().toString());
            total.setText(totalSum + "");
            String s = getResources().getString(R.string.pay);
            pay.setText(s + " " + totalSum);
        }
    }
}
