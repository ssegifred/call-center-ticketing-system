package org.pahappa.systems.ticketing.services.impl;

import org.pahappa.systems.ticketing.constants.TicketStatus;
import org.pahappa.systems.ticketing.models.Ticket;
import org.pahappa.systems.ticketing.services.TicketService;

import java.util.List;

public class TicketServiceImpl implements TicketService {

    @Override
    public void createTicket(Ticket ticket) {

    }

    @Override
    public List<Ticket> getAllTickets() {
        return null;
    }

    @Override
    public List<Ticket> getTicketsOfStatus(TicketStatus ticketStatus) {
        return null;
    }

    @Override
    public void updateTicket(Ticket updatedTicket) {

    }

    @Override
    public void deleteTicket(int index) {

    }
}
