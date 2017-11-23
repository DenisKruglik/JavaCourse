package com.example.notepadby.homework12;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.notepadby.homework12.Pizza.Order;
import com.example.notepadby.homework12.Pizza.Pizza;
import com.example.notepadby.homework12.Pizza.PizzaSize;

import java.util.ArrayList;

public class ActivityTwo extends AppCompatActivity {

    TextView positions;
    TextView sum;
    Button purchase;
    Button cancel;
    LinearLayout list;
    int positionsCounter = 0;
    double sumCount = 0;
    ActivityTwo self = this;
    ArrayList<Order> orders = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        positions = (TextView) findViewById(R.id.positions);
        sum = (TextView) findViewById(R.id.sum);
        purchase = (Button) findViewById(R.id.purchase);
        cancel = (Button) findViewById(R.id.cancel);
        list = (LinearLayout) findViewById(R.id.pizza_list);

        positions.setText(" " + this.positionsCounter + "");
        sum.setText(" " + this.sumCount + "");

        ArrayList<Pizza> pizzas = new ArrayList<>();
        ArrayList<String> contents = new ArrayList<>();
        contents.add(getResources().getString(R.string.cheese));
        contents.add(getResources().getString(R.string.sausage));
        contents.add(getResources().getString(R.string.ketchup));
        ArrayList<PizzaSize> sizes = new ArrayList<>();
        sizes.add(new PizzaSize(17, 10.0));
        sizes.add(new PizzaSize(20, 15));
        sizes.add(new PizzaSize(23, 20));
        pizzas.add(new Pizza(getResources().getString(R.string.pepperoni), contents, sizes));
        contents = new ArrayList<String>();
        contents.add(getResources().getString(R.string.cheese));
        contents.add(getResources().getString(R.string.ham));
        contents.add(getResources().getString(R.string.mushrooms));
        sizes = new ArrayList<PizzaSize>();
        sizes.add(new PizzaSize(17, 12));
        sizes.add(new PizzaSize(20, 17));
        sizes.add(new PizzaSize(23, 22));
        pizzas.add(new Pizza(getResources().getString(R.string.ham_mushrooms), contents, sizes));
        contents = new ArrayList<String>();
        contents.add(getResources().getString(R.string.pepper));
        contents.add(getResources().getString(R.string.chili));
        contents.add(getResources().getString(R.string.olives));
        sizes = new ArrayList<PizzaSize>();
        sizes.add(new PizzaSize(17, 14));
        sizes.add(new PizzaSize(20, 19));
        sizes.add(new PizzaSize(23, 24));
        pizzas.add(new Pizza(getResources().getString(R.string.super_hot), contents, sizes));

        for (final Pizza p: pizzas
                ) {
            final LinearLayout pizzaLayout = new LinearLayout(this);
            pizzaLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            pizzaLayout.setOrientation(LinearLayout.VERTICAL);
            TextView title = new TextView(this);
            title.setText(getResources().getString(R.string.pizza) + " '" + p.getTitle() + "'");
            title.setTextSize(20);
            TextView tv = new TextView(this);
            String contentString = "";
            contents = p.getContents();
            int len = contents.size(), counter = 0;

            for (String c: contents){
                contentString += " " + c;
                if (counter != len - 1){
                    contentString += ",";
                }
                counter++;
            }
            tv.setText(getResources().getString(R.string.contents) + contentString);
            pizzaLayout.addView(title);
            pizzaLayout.addView(tv);
            pizzaLayout.setBottom(1);
            pizzaLayout.setPadding(20,35,20,35);
            list.addView(pizzaLayout);

            pizzaLayout.setOnClickListener(new View.OnClickListener() {
                boolean isClicked = false;
                boolean isButtonPut = false;
                PizzaSize chosen = null;
                @Override
                public void onClick(View v) {
                    if (!isClicked){
                        final LinearLayout extra = new LinearLayout(self);
                        extra.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                        extra.setOrientation(LinearLayout.VERTICAL);
                        RadioGroup l = new RadioGroup(self);
                        final Button b = new Button(self);
                        b.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                orders.add(new Order(p, chosen));
                                positionsCounter++;
                                sumCount += chosen.getPrice();
                                redraw();
                            }
                        });

                        for (final PizzaSize ps: p.getSizes()){
                            RadioButton rb = new RadioButton(self);
                            rb.setText(ps.getSize() + " " + getResources().getString(R.string.cm));
                            l.addView(rb);
                            rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                    if (isChecked){
                                        b.setText(getResources().getString(R.string.buy_for) + " " + ps.getPrice());
                                        if (!isButtonPut){
                                            extra.addView(b);
                                            isButtonPut = true;
                                        }
                                        chosen = ps;
                                    }
                                }
                            });

                        }
                        extra.addView(l);
                        pizzaLayout.addView(extra);
                        isClicked = true;
                    }
                }
            });
        }

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positionsCounter = 0;
                sumCount = 0;
                orders.clear();
                redraw();
            }
        });

        purchase.setOnClickListener(new View.OnClickListener() {
            int selectedYear, selectedMonth, selectedDay, selectedHour, selectedMinute;

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (orders.isEmpty()){
                    Toast.makeText(self, getResources().getString(R.string.empty_order), Toast.LENGTH_SHORT).show();
                }else{
                    DatePickerDialog dpd = new DatePickerDialog(self, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            selectedYear = year;
                            selectedMonth = month;
                            selectedDay = dayOfMonth;
                            TimePickerDialog tpd = new TimePickerDialog(self, new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                    selectedHour = hourOfDay;
                                    selectedMinute = minute;
                                    AlertDialog.Builder dialog = new AlertDialog.Builder(self);
                                    dialog.setTitle(getResources().getString(R.string.apply_order));
                                    LinearLayout dialogLayout = new LinearLayout(self);
                                    dialogLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                                    dialogLayout.setOrientation(LinearLayout.VERTICAL);
                                    double totalSum = 0;
                                    for (Order o: orders){
                                        totalSum += o.getSize().getPrice();
                                        LinearLayout orderLayout = new LinearLayout(self);
                                        orderLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                                        orderLayout.setOrientation(LinearLayout.VERTICAL);
                                        TextView title = new TextView(self);
                                        title.setText(getResources().getString(R.string.pizza) + " '" + o.getPizza().getTitle() + "'");
                                        title.setTextSize(20);
                                        TextView tv = new TextView(self);
                                        String contentString = "";
                                        ArrayList<String> contents = o.getPizza().getContents();
                                        int len = contents.size(), counter = 0;

                                        for (String c: contents){
                                            contentString += " " + c;
                                            if (counter != len - 1){
                                                contentString += ",";
                                            }
                                            counter++;
                                        }
                                        tv.setText(getResources().getString(R.string.contents) + contentString);
                                        TextView size = new TextView(self);
                                        size.setText(getResources().getString(R.string.size) + " " + o.getSize().getSize());
                                        TextView price = new TextView(self);
                                        price.setText(getResources().getString(R.string.price) + " " + o.getSize().getPrice());
                                        orderLayout.addView(title);
                                        orderLayout.addView(tv);
                                        orderLayout.addView(size);
                                        orderLayout.addView(price);
                                        orderLayout.setBottom(1);
                                        orderLayout.setPadding(20,35,20,35);
                                        dialogLayout.addView(orderLayout);
                                    }
                                    TextView total = new TextView(self);
                                    total.setText(getResources().getString(R.string.for_payment) + " " + totalSum);
                                    total.setTextSize(30);
                                    TextView date = new TextView(self);
                                    date.setText(selectedDay + "." + selectedMonth + "." + selectedYear + " " + selectedHour + ":" + selectedMinute);
                                    dialogLayout.addView(total);
                                    dialogLayout.addView(date);
                                    dialog.setView(dialogLayout);
                                    dialog.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Toast.makeText(self, getResources().getString(R.string.success), Toast.LENGTH_SHORT).show();
                                            positionsCounter = 0;
                                            sumCount = 0;
                                            orders.clear();
                                            redraw();
                                        }
                                    });
                                    dialog.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            positionsCounter = 0;
                                            sumCount = 0;
                                            orders.clear();
                                            redraw();
                                        }
                                    });
                                    dialog.create().show();
                                }
                            }, 12, 0 ,true);
                            tpd.create();
                            tpd.show();
                        }
                    }, 2017, 11, 9);
                    dpd.create();
                    dpd.show();


                }
            }
        });
    }

    public void redraw(){
        positions.setText(" " + this.positionsCounter);
        sum.setText(" " + this.sumCount);
    }
}
