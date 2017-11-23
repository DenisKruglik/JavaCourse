package com.example.notepadby.homework12.Pizza;

/**
 * Created by NotePad.by on 08.11.2017.
 */

public class Order {
    private Pizza pizza;
    private PizzaSize size;

    public Order(Pizza pizza, PizzaSize size){
        this.pizza = pizza;
        this.size = size;
    }

    public Pizza getPizza(){
        return this.pizza;
    }

    public PizzaSize getSize(){
        return this.size;
    }
}
