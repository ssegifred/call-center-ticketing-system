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
    public String client;
    public String contact;
    public String category;
    public String description;
    public TicketStatus status;
    public String priorityLevel;

    public Ticket() {
    }

    public Ticket(String client, String contact, String category, String description, String priorityLevel,
            TicketStatus stat) {
        this.client = client;
        this.contact = contact;
        this.category = category;
        this.description = description;
        this.priorityLevel = priorityLevel;
        this.status = stat;
    }

}
