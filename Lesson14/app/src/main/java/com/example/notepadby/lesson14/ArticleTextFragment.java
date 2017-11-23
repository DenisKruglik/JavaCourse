package com.example.notepadby.lesson14;

import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by NotePad.by on 22.11.2017.
 */

public class ArticleTextFragment extends Fragment {
    private View view;

    public ArticleTextFragment(){}

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle bundle){
        View view = inflater.inflate(R.layout.text, parent, false);
        this.view = view;
        return view;
    }

    public void openArticle(int position){
        TextView tv = (TextView) view.findViewById(R.id.text);
        tv.setText(Data.articles.get(position).content);
    }
}
