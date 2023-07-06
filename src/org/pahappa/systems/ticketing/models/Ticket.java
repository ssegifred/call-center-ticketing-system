package org.pahappa.systems.ticketing.models;

import org.pahappa.systems.ticketing.constants.TicketStatus;

/**
 * A ticket refers to a unit of work or a request that is submitted
 * by a user or customer to seek assistance, report an issue, or request a
 * service.
 * It serves as a record or a container that captures all the relevant
 * information
 * related to the user's request or issue.
 */
public class Ticket {
    public String Client;
    public String Contact;
    public String Category;
    public String Description;
    public TicketStatus status;
    public String PriorityLevel;

    public Ticket() {
    }

    public Ticket(String client, String contact, String category, String description, String priorityLevel,
            TicketStatus stat) {
        Client = client;
        Contact = contact;
        Category = category;
        Description = description;
        PriorityLevel = priorityLevel;
        status = stat;
    }

}
