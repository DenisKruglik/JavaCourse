package com.example.notepadby.homework9.Pizza;

/**
 * Created by NotePad.by on 02.11.2017.
 */

public class PizzaSize {
    private int size;
    private double price;

    public PizzaSize(int size, double price){
        this.size = size;
        this.price = price;
    }

    public int getSize(){
        return this.size;
    }

    public double getPrice(){
        return this.price;
    }
}
