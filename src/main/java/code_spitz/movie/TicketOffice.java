package code_spitz.movie;

import java.util.ArrayList;
import java.util.List;

/**
 * 티켓오피스는 씨어터를 모른다.
 * getTicketWithFee
 * getTicketWithNoFee
 * 를 결정하는 역할은 Seller
 *
 * TicketOffice는 많은 정보를 모른다.
 */
public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount) {
        this.amount = amount;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public Ticket getTicketWithFee(){
        if(tickets.size() == 0) return Ticket.EMPTY;
        else{
            Ticket ticket = tickets.remove(0);
            amount+= ticket.getFee();
            return ticket;
        }
    }

    public Ticket getTicketWithNoFee(){
        if(tickets.size() == 0) return Ticket.EMPTY;
        else return tickets.remove(0);
    }

    public Long getTicketPrice(){
        if(tickets.size() == 0) return 0L;
        else return tickets.get(0).getFee();
    }
}
