package com.example.notepadby.lesson13;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by NotePad.by on 17.11.2017.
 */

public class ContactsAdapter extends ArrayAdapter<Contact> {

    private ArrayList<Contact> list;

    public ContactsAdapter(Context ctx, ArrayList<Contact> contacts){
        super(ctx, R.layout.list_item2, contacts);
        list = contacts;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item2, null);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        name.setText(list.get(position).name);
        TextView phone = (TextView) convertView.findViewById(R.id.phone);
        phone.setText(list.get(position).phone);
        return convertView;
    }
}
