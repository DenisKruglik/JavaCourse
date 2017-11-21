package com.example.notepadby.lesson12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

//    private TextView tv2;
    private EditText firstName;
    private EditText lastName;
    private EditText middleName;
    private Button ok;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        tv2 = (TextView) findViewById(R.id.tv2);
//        Bundle data = getIntent().getExtras();
//        tv2.setText(data.getString("message"));

        firstName = (EditText) findViewById(R.id.first_name);
        lastName = (EditText) findViewById(R.id.last_name);
        middleName = (EditText) findViewById(R.id.middle_name);
        ok = (Button) findViewById(R.id.ok);
        cancel = (Button) findViewById(R.id.cancel);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("firstName", firstName.getText().toString());
                intent.putExtra("lastName", lastName.getText().toString());
                intent.putExtra("middleName", middleName.getText().toString());
                setResult(0, intent);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(1);
                finish();
            }
        });
    }
}
