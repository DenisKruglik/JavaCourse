package com.example.notepadby.lesson14;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by NotePad.by on 22.11.2017.
 */

public class ArticleListFragment extends Fragment {
    public ArticleListFragment(){};

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle bundle){
        View view = inflater.inflate(R.layout.list, parent, false);
        ArrayList<String> titles = new ArrayList<>();
        for(Article a: Data.articles){
            titles.add(a.title);
        }
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.article, titles);
        ListView lv = (ListView) view.findViewById(R.id.list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                MainActivity.self.openArticle(position);
            }
        });
        return view;
    }
}
