package com.example.notepadby.lesson9;

import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MainActivity self = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        self = this;

        ArrayList<String> movies = new ArrayList<>();
        movies.add("Inception");
        movies.add("Man in black");
        movies.add("Independence Day");
        movies.add("Hush");
        movies.add("Forrest Gump");
        LinearLayout root = (LinearLayout) findViewById(R.id.root);

        ArrayList<Integer> ids = new ArrayList<>();
        for (String s: movies
             ) {
            LinearLayout layer = new LinearLayout(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layer.setLayoutParams(params);
            layer.setOrientation(LinearLayout.HORIZONTAL);
            TextView text = new TextView(this);
            text.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 5.0f));
            text.setText(s);
            Button b = new Button(this);
            b.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f));
            b.setText("ADD");
            layer.addView(text);
            layer.addView(b);
            final String s1 = s;
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), s1, Toast.LENGTH_SHORT).show();
                }
            });
            layer.setId(View.generateViewId());
            ids.add(layer.getId());
            root.addView(layer);
        }

        final String items[]=new String[movies.size()];
        movies.toArray(items);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(self);
                dialog.setTitle("Dialog title");

//                dialog.setMessage("Sample text");

                LayoutInflater inflater = getLayoutInflater();
                LinearLayout l = (LinearLayout)findViewById(R.id.ll);
                final View view = inflater.inflate(R.layout.dialog_layout, l);
                dialog.setView(view);

                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final EditText login = (EditText) view.findViewById(R.id.login);
                        EditText password = (EditText) view.findViewById(R.id.password);
                        Toast.makeText(self, "Welcome, " + login.getText().toString() + "!", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText login = (EditText) view.findViewById(R.id.login);
                        EditText password = (EditText) view.findViewById(R.id.password);
                        Toast.makeText(self, "We'll tell everyone that your password is " + password.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
//                dialog.setNeutralButton("I don't know", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(self, "(0_0)", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                dialog.setItems(items, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(self, items[which], Toast.LENGTH_SHORT).show();
//                    }
//                });
//                dialog.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(self, items[which], Toast.LENGTH_SHORT).show();
//                    }
//                });
//                dialog.setMultiChoiceItems(items, new boolean[items.length], new DialogInterface.OnMultiChoiceClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//                        Toast.makeText(self, items[which], Toast.LENGTH_SHORT).show();
//                    }
//                });
                dialog.create().show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        switch(id){
            case R.id.main:
                Toast.makeText(self, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.reset:
                Toast.makeText(self, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
