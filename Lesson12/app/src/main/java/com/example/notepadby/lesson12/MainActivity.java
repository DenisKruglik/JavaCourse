package com.example.notepadby.lesson12;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    private TextView tv;
//    private EditText et;
//    private Button btn;
//    private Button second;
//    private MainActivity self = this;
    private Button add;
    private LinearLayout list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        tv = (TextView) findViewById(R.id.tv);
//        et = (EditText) findViewById(R.id.et);
//        btn = (Button) findViewById(R.id.btn);
//        second = (Button) findViewById(R.id.second);
        add = (Button) findViewById(R.id.add);
        list = (LinearLayout) findViewById(R.id.list);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//
//        second.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(getApplicationContext(), SecondActivity.class);
//                intent.putExtra("message", "4 8 15 16 23 42");
//                startActivity(intent);
//            }
//        });
//
//        tv.append("OnCreate\n");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), SecondActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public void onActivityResult(int pid, int code, Intent intent){
        if(pid == 1 && code == 0){
            TextView tv = new TextView(this);
            tv.setText(intent.getStringExtra("lastName") + " " + intent.getStringExtra("firstName") + " " + intent.getStringExtra("middleName"));
            list.addView(tv);;
        }
    }

    @Override
    public void onStart(){
        super.onStart();
//        tv.append("OnStart\n");
    }

    @Override
    public void onStop(){
        super.onStop();
//        tv.append("onStop\n");
    }

    @Override
    public void onPause(){
        super.onPause();
//        tv.append("onPause\n");
    }

    @Override
    public void onResume(){
        super.onResume();
//        tv.append("onResume\n");
    }

    @Override
    public void onRestart(){
        super.onRestart();
//        tv.append("onRestart\n");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
//        tv.append("onDestroy\n");
    }

    @Override
    public void onSaveInstanceState(Bundle bundle){
        super.onSaveInstanceState(bundle);
//        bundle.putString("Text", tv.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle bundle){
        super.onRestoreInstanceState(bundle);
//        tv.setText(bundle.getString("Text"));
    }

    @Override
    public void onBackPressed(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Are you sure you want to quit?");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.create().show();
    }
}
