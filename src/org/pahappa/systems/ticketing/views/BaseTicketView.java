package org.pahappa.systems.ticketing.views;

public interface BaseTicketView {

    // Display the menu for the view
    void displayMenu();

    // Create a new ticket
    void createTicket();

    // Get all tickets
    void getAllTickets();

    // Get tickets based on their status
    void getTicketsOfStatus();

    // Update an existing ticket
    void updateTicket();

    // Delete a ticket
    void deleteTicket();
}
