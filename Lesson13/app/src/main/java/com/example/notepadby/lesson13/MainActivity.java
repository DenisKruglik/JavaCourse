package com.example.notepadby.lesson13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
//    Button btn;
    MainActivity self = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
//        btn = (Button) findViewById(R.id.btn);
        final ArrayList<Contact> items = new ArrayList<>();
        items.add(new Contact("Вася", "+375296666666"));
        items.add(new Contact("Петя", "+375291234567"));
        items.add(new Contact("Гриша", "+375290000007"));
        final ContactsAdapter adapter = new ContactsAdapter(this, items);
        list.setAdapter(adapter);
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(self, items.get(position), Toast.LENGTH_SHORT).show();
//            }
//        });
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                adapter.add("Elem");
//                Toast.makeText(self, items.size()+"", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
