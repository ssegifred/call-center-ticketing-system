package org.pahappa.systems.ticketing.services.impl;

import org.pahappa.systems.ticketing.constants.TicketStatus;
import org.pahappa.systems.ticketing.models.Ticket;
import org.pahappa.systems.ticketing.services.TicketService;

import java.util.ArrayList;
import java.util.List;

public class TicketServiceImpl implements TicketService {

    List<Ticket> ticketList = new ArrayList<>();

    @Override
    public void createTicket(Ticket ticket) {

        ticketList.add(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketList;
    }

    @Override
    public List<Ticket> getTicketsOfStatus(TicketStatus ticketStatus) {
       
    List<Ticket> sortedTickets = new ArrayList<>();

    for (Ticket ticket : ticketList) {
        if (ticket.getStatus() == ticketStatus) {
            sortedTickets.add(ticket);
        }
    }

    return sortedTickets;
}
    @Override
    public void updateTicket(Ticket updatedTicket) {

    }

    @Override
    public void deleteTicket(int index) {

    }
}
