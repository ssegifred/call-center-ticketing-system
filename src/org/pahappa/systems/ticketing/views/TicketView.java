package org.pahappa.systems.ticketing.views;

import org.pahappa.systems.ticketing.constants.TicketStatus;
import org.pahappa.systems.ticketing.models.Ticket;
import org.pahappa.systems.ticketing.services.TicketService;
import org.pahappa.systems.ticketing.services.impl.TicketServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
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

    TicketServiceImpl objService = new TicketServiceImpl();

    @Override
    public void createTicket() {
        Ticket obj = new Ticket();
        // Prompt the user for input
        System.out.print("Enter the Client's Name: ");
        obj.Client = scanner.nextLine();
        System.out.print("Enter Client's Contact: ");
        obj.Contact = scanner.nextLine();
        System.out.print("Enter Ticket Category: ");
        obj.Category = scanner.nextLine();

        System.out.print("Enter Ticket Description: ");
        obj.Description = scanner.nextLine();

        System.out.print("Choose Ticket priority Level ");
        List<String> priority = new ArrayList<>(Arrays.asList("Low", "Medium", "High"));
        System.out.print("Choose Ticket priority Level \n");
        for (int i = 0; i < priority.size(); i++) {
            System.out.println((i + 1) + ": " + priority.get(i));
        }

        String pri = scanner.nextLine();
        if (pri.matches("\\d+")) {
            int num = Integer.parseInt(pri);

            if (num >= 1 && num <= priority.size()) {
                obj.PriorityLevel = priority.get(num - 1);
            } else {
                System.out.println("Invalid input.");
            }
        } else {
            System.out.println("\nInvalid Input! Please enter a valid integer.");
        }

        System.out.println("Choose the status:");
        for (int j = 0; j < TicketStatus.values().length; j++) {
            System.out.println((j + 1) + ". " + TicketStatus.values()[j]);
        }

        String statusNumb = scanner.nextLine();
        if (statusNumb.matches("\\d+")) {
            int num = Integer.parseInt(statusNumb);

            TicketStatus stat = TicketStatus.values()[num - 1];
            obj.status = stat;
        } else {
            System.out.println("\nInvalid Input! Please enter a valid integer.");
        }

        // Create a new User object with the captured information
        Ticket ticket = new Ticket(obj.Client, obj.Contact, obj.Category, obj.Description, obj.PriorityLevel,
                obj.status);

        // Add the user to the list

        objService.createTicket(ticket);

    }

    @Override
    public void getAllTickets() {
        List<Ticket> tickets = objService.getAllTickets();
        int size = tickets.size();
        if (size > 0) {
            // Display the tickets to the user

            for (Ticket ticket : tickets) {

                System.out.println(
                        "Client's Name: " + ticket.Client + " Contact: " + ticket.Contact + " Ticket Category: "
                                + ticket.Category + " Ticket Description: " + ticket.Description
                                + " Ticket Priority Level: " + ticket.PriorityLevel + " Status: " + ticket.status);
                System.out.println();
            }
        } else {
            System.out.println("\nNo Tickets Found");
        }
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