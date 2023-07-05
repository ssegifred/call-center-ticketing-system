package org.pahappa.systems.ticketing.views;

import org.pahappa.systems.ticketing.models.Ticket;
import org.pahappa.systems.ticketing.services.TicketService;
import org.pahappa.systems.ticketing.services.impl.TicketServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketView implements BaseTicketView {

    private final TicketService ticketService;
    private final Scanner scanner;

    public TicketView() {
        this.ticketService = new TicketServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayMenu() {
        System.out.println("********* Call Center Ticket System *********\n\n");
        boolean running = true;
        while (running) {
            try {
                System.out.println("Choose an operation:");
                System.out.println("1. Create Ticket");
                System.out.println("2. Get All Tickets");
                System.out.println("3. Get Tickets of Status");
                System.out.println("4. Update Ticket");
                System.out.println("5. Delete Ticket");
                System.out.println("6. Exit");
                System.out.println();

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        createTicket();
                        break;
                    case 2:
                        getAllTickets();
                        break;
                    case 3:
                        getTicketsOfStatus();
                        break;
                    case 4:
                        updateTicket();
                        break;
                    case 5:
                        deleteTicket();
                        break;
                    case 6:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");

                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();

            }

        }
    }

    @Override
    public void createTicket() {
        Ticket obj = new Ticket();
        // Prompt the user for input
        System.out.print("Enter Ticket Category: ");
        obj.Category = scanner.nextLine();

        System.out.print("Enter Ticket Description: ");
        obj.Description = scanner.nextLine();

        System.out.print("Enter Ticket priority on the scale of 5 with 5 being the highest and 1 lowest: ");
        obj.PriorityLevel = scanner.nextInt();

        // Create a new User object with the captured information
        Ticket ticket = new Ticket(obj.Category, obj.Description, obj.PriorityLevel);

        // Add the user to the list
        TicketServiceImpl objService = new TicketServiceImpl();

        objService.createTicket(ticket);

    }

    @Override
    public void getAllTickets() {

    }

    @Override
    public void getTicketsOfStatus() {

    }

    @Override
    public void updateTicket() {

    }

    @Override
    public void deleteTicket() {

    }
}