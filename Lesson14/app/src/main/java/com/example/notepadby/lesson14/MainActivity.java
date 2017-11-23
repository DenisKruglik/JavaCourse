package com.example.notepadby.lesson14;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static MainActivity self;
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        self = this;
        vp = (ViewPager) findViewById(R.id.pager);
        ColorPagerAdapter adapter = new ColorPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);
    }

//    public void openArticle(int position){
//        FragmentManager fm = getSupportFragmentManager();
//        ArticleTextFragment fragment = (ArticleTextFragment) fm.findFragmentById(R.id.text_fragment);
//        fragment.openArticle(position);
//    }
}
