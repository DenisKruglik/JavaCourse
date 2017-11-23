package com.example.notepadby.homework12.Pizza;

import java.util.ArrayList;

/**
 * Created by NotePad.by on 02.11.2017.
 */

public class Pizza {
    private String title;
    private ArrayList<String> contents;
    private ArrayList<PizzaSize> sizes;

    public Pizza(String title, ArrayList<String> contents, ArrayList<PizzaSize> sizes){
        this.title = title;
        this.contents = contents;
        this.sizes = sizes;
    }

    public String getTitle(){
        return this.title;
    }

    public ArrayList<String> getContents(){
        return this.contents;
    }

    public ArrayList<PizzaSize> getSizes(){
        return this.sizes;
    }
}
