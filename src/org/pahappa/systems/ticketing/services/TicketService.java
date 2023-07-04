package org.pahappa.systems.ticketing.services;

import org.pahappa.systems.ticketing.constants.TicketStatus;
import org.pahappa.systems.ticketing.models.Ticket;

import java.util.List;

public interface TicketService {
    /**
     * Create new tickets by entering the necessary details, such ticket name and description.
     *
     * @param ticket
     */
    void createTicket(Ticket ticket);

    /**
     * View of all existing tickets, displaying relevant information about each ticket.
     *
     * @return
     */
    List<Ticket> getAllTickets();

    /**
     * View of existing tickets based on the ticketStatus, displaying relevant information about each ticket.
     *
     * @param ticketStatus
     * @return
     */
    List<Ticket> getTicketsOfStatus(TicketStatus ticketStatus);

    /**
     * Update ticket attributes, such as the name, status.
     *
     * @param updatedTicket
     */
    void updateTicket(Ticket updatedTicket);

    /**
     * Remove a ticket from the system if it's no longer relevant or resolved
     * @param index
     */
    void deleteTicket(int index);
}
