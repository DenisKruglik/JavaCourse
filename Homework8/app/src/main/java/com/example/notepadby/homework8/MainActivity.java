package com.example.notepadby.homework8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText input = null;
    private Button one = null;
    private Button two = null;
    private Button three = null;
    private Button four = null;
    private Button five = null;
    private Button six = null;
    private Button seven = null;
    private Button eight = null;
    private Button nine = null;
    private Button zero = null;
    private Button dot = null;
    private Button equals = null;
    private Button reset = null;
    private Button root = null;
    private Button mem_show = null;
    private Button mem_subtract = null;
    private Button mem_add = null;
    private Button div = null;
    private Button multiply = null;
    private Button minus = null;
    private Button plus = null;
    private double memory = 0;
    private char action = '\0';
    private boolean isNewString = true;
    private double calculated = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText)findViewById(R.id.input);
        one = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
        zero = (Button)findViewById(R.id.zero);
        dot = (Button)findViewById(R.id.dot);
        equals = (Button)findViewById(R.id.equals);
        reset = (Button)findViewById(R.id.reset);
        root = (Button)findViewById(R.id.root);
        mem_show = (Button)findViewById(R.id.mem_show);
        mem_subtract = (Button)findViewById(R.id.mem_subtract);
        mem_add = (Button)findViewById(R.id.mem_add);
        div = (Button)findViewById(R.id.div);
        multiply = (Button)findViewById(R.id.multiply);
        minus = (Button)findViewById(R.id.minus);
        plus = (Button)findViewById(R.id.plus);
        final MainActivity pointer = this;

        input.setText("0");

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputValue(getResources().getString(R.string.one));
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputValue(getResources().getString(R.string.two));
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputValue(getResources().getString(R.string.three));
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean f = isNewString;
                inputValue(getResources().getString(R.string.zero));
                if (f){
                    isNewString = true;
                }
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputValue(getResources().getString(R.string.four));
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputValue(getResources().getString(R.string.five));
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputValue(getResources().getString(R.string.six));
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputValue(getResources().getString(R.string.seven));
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputValue(getResources().getString(R.string.eight));
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputValue(getResources().getString(R.string.nine));
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!input.getText().toString().contains(".")){
                    isNewString = false;
                    inputValue(getResources().getString(R.string.dot));
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isNewString = true;
                input.setText("0");
            }
        });

        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double n = Double.valueOf(input.getText().toString());
                if(n >= 0){
                    input.setText(numberFormat(Math.sqrt(n)));
                    isNewString = true;
                }else{
                    Toast.makeText(pointer, "Cannot find the square root of a negative value!", Toast.LENGTH_LONG).show();
                }
            }
        });

        mem_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isNewString = true;
                input.setText(numberFormat(memory));
                memory = 0;
            }
        });

        mem_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memory -= Double.valueOf(input.getText().toString());
            }
        });

        mem_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memory += Double.valueOf(input.getText().toString());
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAction('+');
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAction('-');
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAction('*');
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAction('/');
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (action){
                    case '+':
                        calculated += Double.valueOf(input.getText().toString());
                        break;
                    case '-':
                        calculated -= Double.valueOf(input.getText().toString());
                        break;
                    case '*':
                        calculated *= Double.valueOf(input.getText().toString());
                        break;
                    case '/':
                        double operand = Double.valueOf(input.getText().toString());
                        if (operand == 0){
                            Toast.makeText(pointer, "Cannot divide by zero!", Toast.LENGTH_LONG).show();
                        }else{
                            calculated /= operand;
                        }
                        break;
                    default:
                        return;
                }
                action = '\0';
                isNewString = true;
                input.setText(numberFormat(calculated));
            }
        });
    }

    public String numberFormat(double n){
        String res = "";
        int round = (int)n;
        double rational = n - round;
        if (rational == 0){
            res = round + "";
        }else{
            res = calculated + "";
        }
        return res;
    }

    public void inputValue(String s){
        if (isNewString){
            input.setText(s);
            isNewString = false;
        }else{
            input.setText(input.getText().toString() + s);
        }
    }

    public void setAction(char c){
        action = c;
        calculated = Double.valueOf(input.getText().toString());
        isNewString = true;
        Toast.makeText(this, c + "", Toast.LENGTH_LONG).show();
    }
}
