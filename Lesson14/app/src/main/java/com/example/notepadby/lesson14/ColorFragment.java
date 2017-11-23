package com.example.notepadby.lesson14;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by NotePad.by on 22.11.2017.
 */

public class ColorFragment extends Fragment {
    public ColorFragment(){};

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle bundle){
        View view = inflater.inflate(R.layout.page, parent, false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.page);
        layout.setBackgroundColor(Color.rgb((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
        return view;
    }


}
