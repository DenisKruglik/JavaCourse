package com.example.notepadby.lesson11_practicum;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notepadby.lesson11_practicum.Ticket.Ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner outgoCity;
    Spinner arrivalCity;
    Spinner sorting;
    Button outgoDateBtn;
    Button classesBtn;
    Button search;
    LinearLayout list;
    TextView selectedDateTv;
    TextView selectedClassesTv;

    String selectedOutgoCity = "";
    String selectedArrivalCity = "";
    Date selectedOutgoDate;
    ArrayList<Ticket.TicketClass> selectedClasses = new ArrayList<>();
    ArrayList<Ticket> tickets = new ArrayList<>();
    ArrayList<String> cities = new ArrayList<>();
    MainActivity self = this;
    boolean selectedSort = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outgoCity = (Spinner) findViewById(R.id.outgo_city);
        arrivalCity = (Spinner) findViewById(R.id.arrival_city);
        outgoDateBtn = (Button) findViewById(R.id.outgo_date_btn);
        classesBtn = (Button) findViewById(R.id.classes_btn);
        search = (Button) findViewById(R.id.search);
        list = (LinearLayout) findViewById(R.id.list);
        selectedDateTv = (TextView) findViewById(R.id.selected_date_tv);
        selectedClassesTv = (TextView) findViewById(R.id.selected_classes_tv);
        sorting = (Spinner) findViewById(R.id.sort);

//        Toast.makeText(this, "abc".compareToIgnoreCase("abc")+"", Toast.LENGTH_SHORT).show();

        String[] s = getResources().getStringArray(R.array.cities);

        for(String city: s){
            cities.add(city);
        }

        for(String onset: cities){
            int onsetInd = cities.indexOf(onset);
            for (String destination: cities){
                if (cities.indexOf(destination) != onsetInd){
                    int randHour = (int)Math.floor(Math.random() * 24);
                    int randMinute = (int)Math.floor(Math.random() * 60);
                    double randPrice = Math.round(Math.random()*5) + 5;
                    int classNumber = (int)Math.ceil(Math.random()*3);
                    Ticket.TicketClass tc;
                    switch (classNumber){
                        case 1:
                            tc = Ticket.TicketClass.ECONOM;
                            break;
                        case 2:
                            tc = Ticket.TicketClass.BUSINESS;
                            break;
                        case 3:
                            tc = Ticket.TicketClass.LUXE;
                            break;
                        default:
                            tc = Ticket.TicketClass.ECONOM;
                            break;
                    }
                    tickets.add(new Ticket(onset, destination, new Date(2017, 10, 10, randHour, randMinute), new Date(2017, 11, 10, randHour+2, randMinute), randPrice, "Белорусская железная дорога", tc));
                }
            }
        }

        tickets.add(new Ticket("Минск", "Барановичи", new Date(2017, 10, 15,0,0), new Date(2017,10,15,4,0), 10, "Qfnwjkn", Ticket.TicketClass.ECONOM));
        tickets.add(new Ticket("Минск", "Барановичи", new Date(2017, 10, 15,0,0), new Date(2017,10,15,2,0), 13, "Aasdas", Ticket.TicketClass.ECONOM));

        sorting.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    selectedSort = true;
                }else{
                    selectedSort = false;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        outgoCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(self, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                selectedOutgoCity = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        arrivalCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedArrivalCity = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        outgoDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date d = new Date();
                DatePickerDialog dpd = new DatePickerDialog(self, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        selectedOutgoDate = new Date(year, month, dayOfMonth);
                        setDateText();
                    }
                }, d.getYear()+1900, d.getMonth(), d.getDate());
                dpd.create();
                dpd.show();
            }
        });

        classesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(self);
                String classes[] = {getResources().getString(R.string.econom), getResources().getString(R.string.business), getResources().getString(R.string.luxe)};
                boolean b[] = {false, false, false};
                final ArrayList<Ticket.TicketClass> classes1 = new ArrayList<Ticket.TicketClass>();
                dialog.setMultiChoiceItems(classes, b, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Ticket.TicketClass tc;
                        switch (which){
                            case 0:
                                tc = Ticket.TicketClass.ECONOM;
                                break;
                            case 1:
                                tc = Ticket.TicketClass.BUSINESS;
                                break;
                            case 2:
                                tc = Ticket.TicketClass.LUXE;
                                break;
                            default:
                                tc = Ticket.TicketClass.ECONOM;
                                break;
                        }
                        if (isChecked && !classes1.contains(tc)){
                            classes1.add(tc);
                        }else if(!isChecked && classes1.contains(tc)){
                            classes1.remove(tc);
                        }
                    }
                });
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedClasses = classes1;
                        setClassesText();
                    }
                });
                dialog.create().show();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            ArrayList<Ticket> res = new ArrayList<Ticket>();

            @Override
            public void onClick(View v) {
                res.clear();
                if (!selectedOutgoCity.isEmpty() && !selectedArrivalCity.isEmpty() && selectedOutgoDate != null){
                    for (Ticket t: tickets){
                        if(t.getOnset().compareToIgnoreCase(selectedOutgoCity) == 0 &&
                                t.getDestination().compareToIgnoreCase(selectedArrivalCity) == 0 &&
                                t.getOutgoDate().getYear() == selectedOutgoDate.getYear() &&
                                t.getOutgoDate().getMonth() == selectedOutgoDate.getMonth() &&
                                t.getOutgoDate().getDate() == selectedOutgoDate.getDate()){
                            if (selectedClasses.isEmpty()){
                                res.add(t);
                            }else{
                                if(selectedClasses.contains(t.getTicketClass())){
                                    res.add(t);
                                }
                            }
                        }
                    }
                    if (res.isEmpty()){
                        Toast.makeText(self, getResources().getString(R.string.not_found), Toast.LENGTH_SHORT).show();
                    }else{
                        if(selectedSort){
                            Collections.sort(res, Ticket.priceComparator);
                        }else{
                            Collections.sort(res, Ticket.durationComparator);
                        }
                        generateView(res);
                    }
                }else {
                    Toast.makeText(self, getResources().getString(R.string.fill_required), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void generateView(ArrayList<Ticket> res){
        list.removeAllViewsInLayout();
        for(final Ticket t: res){
            final int p = (int)getResources().getDimension(R.dimen.padd);
            LinearLayout tl = new LinearLayout(self);
            LinearLayout.LayoutParams tlp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tlp.setMargins(0,0,0,p);
            tl.setLayoutParams(tlp);
            tl.setBackgroundColor(getResources().getColor(R.color.grey));
            tl.setPadding(p,p,p,p);
            tl.setOrientation(LinearLayout.VERTICAL);
            TextView title = new TextView(self);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0,0,0,p);
            title.setLayoutParams(lp);
            title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            title.setText(t.getOnset() + "-" + t.getDestination());
            tl.addView(title);
            LinearLayout info = new LinearLayout(self);
            info.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            info.setOrientation(LinearLayout.VERTICAL);
            LinearLayout price = new LinearLayout(self);
            price.setOrientation(LinearLayout.HORIZONTAL);
            price.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            TextView w = new TextView(self);
            w.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            w.setText(getResources().getString(R.string.price) + " " + t.getPrice() + " " + getResources().getString(R.string.rub));
            price.addView(w);
            info.addView(price);
            tl.addView(info);
            list.addView(tl);
            tl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(self);
                    LinearLayout tl = new LinearLayout(self);
                    LinearLayout.LayoutParams tlp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    tl.setLayoutParams(tlp);
                    tl.setPadding(p,p,p,p);
                    tl.setOrientation(LinearLayout.VERTICAL);
                    TextView title = new TextView(self);
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    lp.setMargins(0,0,0,p);
                    title.setLayoutParams(lp);
                    title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    title.setText(t.getOnset() + "-" + t.getDestination());
                    tl.addView(title);
                    LinearLayout info = new LinearLayout(self);
                    info.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    info.setOrientation(LinearLayout.VERTICAL);

                    LinearLayout price = new LinearLayout(self);
                    price.setOrientation(LinearLayout.HORIZONTAL);
                    price.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    TextView w = new TextView(self);
                    w.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    w.setText(getResources().getString(R.string.price) + " " + t.getPrice() + " " + getResources().getString(R.string.rub));
                    price.addView(w);

                    LinearLayout outgo = new LinearLayout(self);
                    outgo.setOrientation(LinearLayout.HORIZONTAL);
                    outgo.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    TextView w1 = new TextView(self);
                    w1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    w1.setText(getResources().getString(R.string.outgo) + " " + formatDateTime(t.getOutgoDate()));
                    outgo.addView(w1);

                    LinearLayout arrival = new LinearLayout(self);
                    arrival.setOrientation(LinearLayout.HORIZONTAL);
                    arrival.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    TextView w2 = new TextView(self);
                    w2.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    w2.setText(getResources().getString(R.string.arrival) + " " + formatDateTime(t.getArrivalDate()));
                    arrival.addView(w2);

                    info.addView(price);
                    info.addView(outgo);
                    info.addView(arrival);
                    TextView type = new TextView(self);
                    type.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    Ticket.TicketClass tc = t.getTicketClass();
                    String tcs = "";
                    switch (tc){
                        case ECONOM:
                            tcs += getResources().getString(R.string.econom);
                            break;
                        case BUSINESS:
                            tcs += getResources().getString(R.string.business);
                            break;
                        case LUXE:
                            tcs += getResources().getString(R.string.luxe);
                            break;
                        default:
                            tcs += getResources().getString(R.string.econom);
                            break;
                    }
                    type.setText(tcs);
                    info.addView(type);
                    TextView company = new TextView(self);
                    company.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    company.setText(t.getTransferCompany());
                    info.addView(company);
                    tl.addView(info);
                    dialog.setView(tl);
                    dialog.create().show();
                }
            });
        }
    }

    public void setClassesText(){
        String res = getResources().getString(R.string.chosen_classes) + ": ";
        int len = selectedClasses.size(), ind = 0;
        for(Ticket.TicketClass tc: selectedClasses){
            switch (tc){
                case ECONOM:
                    res += getResources().getString(R.string.econom);
                    break;
                case BUSINESS:
                    res += getResources().getString(R.string.business);
                    break;
                case LUXE:
                    res += getResources().getString(R.string.luxe);
                    break;
                default:
                    res += getResources().getString(R.string.econom);
                    break;
            }
            if (ind < len-1){
                res += ", ";
            }
            ind++;
        }
        selectedClassesTv.setText(res);
    }

    public void setDateText(){
        selectedDateTv.setText(getResources().getString(R.string.chosen_date) + formatDate(selectedOutgoDate));
    }

    public String formatDate(Date d){
        int fullYear = d.getYear();
        int month = d.getMonth() + 1;
        String monthStr = month < 10 ? "0"+month : month+"";
        int day = d.getDate();
        String dayStr = day < 10 ? "0"+day : day+"";
        return fullYear + "-" + monthStr + "-" + dayStr;
    }

    public String formatDateTime(Date d){
        int hours = d.getHours();
        String hoursStr = hours < 10 ? "0"+hours : hours+"";
        int minutes = d.getMinutes();
        String minutesStr = minutes < 10 ? "0"+minutes : minutes+"";
        return formatDate(d) + " " + hoursStr + ":" + minutesStr;
    }
}
