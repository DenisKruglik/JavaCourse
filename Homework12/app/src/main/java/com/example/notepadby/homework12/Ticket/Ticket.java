package com.example.notepadby.homework12.Ticket;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by NotePad.by on 08.11.2017.
 */

public class Ticket {
    private String onset;
    private String destination;
    private Date outgoDate;
    private Date arrivalDate;
    private double price;
    private String transferCompany;
    private Ticket.TicketClass ticketClass;

    public Ticket(String onset, String destination, Date outgoDate, Date arrivalDate, double price, String transferCompany, Ticket.TicketClass ticketClass){
        this.onset = onset;
        this.destination = destination;
        this.outgoDate = outgoDate;
        this.arrivalDate = arrivalDate;
        this.price = price;
        this.transferCompany = transferCompany;
        this.ticketClass = ticketClass;
    }

    public String getOnset(){
        return this.onset;
    }

    public String getDestination(){
        return this.destination;
    }

    public Date getOutgoDate(){
        return this.outgoDate;
    }

    public Date getArrivalDate(){
        return this.arrivalDate;
    }

    public double getPrice(){
        return this.price;
    }

    public String getTransferCompany(){
        return this.transferCompany;
    }

    public Ticket.TicketClass getTicketClass(){
        return this.ticketClass;
    }

    public enum TicketClass {
        ECONOM,
        BUSINESS,
        LUXE
    }

    public static Comparator<Ticket> priceComparator = new Comparator<Ticket>() {
        @Override
        public int compare(Ticket o1, Ticket o2) {
            return (int)(o1.getPrice() - o2.getPrice());
        }
    };

    public static Comparator<Ticket> durationComparator = new Comparator<Ticket>() {
        @Override
        public int compare(Ticket o1, Ticket o2) {
            return (int)((o1.getArrivalDate().getTime() - o1.getOutgoDate().getTime()) - (o2.getArrivalDate().getTime() - o2.getOutgoDate().getTime()));
        }
    };
}
