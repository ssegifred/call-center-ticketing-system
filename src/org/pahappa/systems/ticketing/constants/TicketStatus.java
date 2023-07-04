package org.pahappa.systems.ticketing.constants;

/**
 * The current state of the ticket, which may include open, in progress, resolved.
 */
public enum TicketStatus {
    /**
     * The ticket is newly created and awaiting action or assignment.
     */
    OPEN,

    /**
     * The ticket is actively being worked on by a team member.
     */
    INPROGRESS,

    /**
     * The issue or task associated with the ticket has been completed or resolved.
     */
    RESOLVED;
}
