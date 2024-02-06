package ru.netology;

import ru.netology.Ticket;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        if (t1.timeFromTo() < t2.timeFromTo()) {
            return -1;
        } else if (t1.timeFromTo() > t2.timeFromTo()) {
            return 1;
        } else {
            return 0;
        }
    } // ваш код
}
