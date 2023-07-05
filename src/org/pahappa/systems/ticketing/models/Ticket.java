package org.pahappa.systems.ticketing.models;

/**
 * A ticket refers to a unit of work or a request that is submitted
 * by a user or customer to seek assistance, report an issue, or request a
 * service.
 * It serves as a record or a container that captures all the relevant
 * information
 * related to the user's request or issue.
 */
public class Ticket {
    public String Category;
    public String Description;
    public int PriorityLevel; // 1-5 scale with 5 being highest priority and 1 lowest

    public Ticket() {
    }

    public Ticket(String category, String description, int priorityLevel) {
        Category = category;
        Description = description;
        PriorityLevel = priorityLevel;
    }

}
