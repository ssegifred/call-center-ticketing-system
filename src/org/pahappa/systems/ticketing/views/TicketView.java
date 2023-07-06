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
    int maxAttempts = 3;// maximumAttempts
    int attempt = 0;// the starting point

    public TicketView() {
        this.ticketService = new TicketServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayMenu() {
        System.out.println("\n********* Call Center Ticket System *********\n\n");
        boolean running = true;
        while (running && (attempt < maxAttempts)) {

            try {
                System.out.println("\nChoose an operation:");
                System.out.println("\n1. Create Ticket");
                System.out.println("\n2. Get All Tickets");
                System.out.println("\n3. Get Tickets of Status");
                System.out.println("\n4. Update Ticket");
                System.out.println("\n5. Delete Ticket");
                System.out.println("\n6. Exit");
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
                        System.out.println("\nInvalid choice. Please try again.");

                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("\nInvalid input. Please try again.");
                scanner.nextLine();
                attempt++;
            }

        }

    }

    @Override
    public void createTicket() {
        Ticket obj = new Ticket();
        // Prompt the user for input
        System.out.print("\nEnter the Client's Name: ");
        obj.client = scanner.nextLine();
        System.out.print("\nEnter Client's Contact: ");
        obj.contact = scanner.nextLine();
        System.out.print("\nEnter Ticket Category: ");
        obj.category = scanner.nextLine();

        System.out.print("\nEnter Ticket Description: ");
        obj.description = scanner.nextLine();

        System.out.print("\nChoose Ticket priority Level ");
        List<String> priority = new ArrayList<>(Arrays.asList("Low", "Medium", "High"));
        System.out.print("Choose Ticket priority Level \n");

        for (int i = 0; i < priority.size(); i++) {
            System.out.println((i + 1) + ": " + priority.get(i));
        }

        String initial = null;
        boolean validInput = false;
        int choices = 0;
        while (choices < maxAttempts) {
            System.out.print("Enter your choice: ");
            initial = scanner.nextLine();

            if (initial.matches("\\d+")) {
                int num = Integer.parseInt(initial);

                if (num >= 1 && num <= priority.size()) {
                    obj.priorityLevel = priority.get(num - 1);
                    validInput = true;
                    break;
                } else {
                    System.out.println("Invalid input.");
                }
            } else {
                System.out.println("\nInvalid Input! Please enter a valid integer.");
            }

            choices++;
        }

        if (!validInput) {
            System.out.println("\nMaximum attempts reached. Main Menu.");
            return; // or perform any necessary action
        }

        System.out.println("Choose the status:");

        for (int j = 0; j < TicketStatus.values().length; j++) {
            System.out.println((j + 1) + ". " + TicketStatus.values()[j]);
        }

        String statusNumb = null;
        validInput = false;
        int trials = 0;

        while (trials < maxAttempts) {
            System.out.print("Enter your choice: ");
            statusNumb = scanner.nextLine();

            if (statusNumb.matches("\\d+")) {
                int num = Integer.parseInt(statusNumb);

                if (num >= 1 && num <= TicketStatus.values().length) {
                    TicketStatus stat = TicketStatus.values()[num - 1];
                    obj.status = stat;
                    validInput = true;

                    break;
                } else {
                    System.out.println("Invalid input.");
                }
            } else {
                System.out.println("\nInvalid Input! Please enter a valid integer.");
            }

            trials++;
        }

        if (!validInput) {
            System.out.println("\nMaximum attempts reached. Main Menu.");
            return;
        } else {
            // Create a new User object with the captured information
            Ticket ticket = new Ticket(obj.client, obj.contact, obj.category, obj.description, obj.priorityLevel,
                    obj.status);

            // Add the user to the list
            ticketService.createTicket(ticket);
        }

    }

    @Override
    public void getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        int size = tickets.size();
        if (size > 0) {
            // Display the tickets to the user

            for (Ticket ticket : tickets) {

                System.out.println(
                        "Client's Name: " + ticket.client + " Contact: " + ticket.contact + " Ticket Category: "
                                + ticket.category + " Ticket Description: " + ticket.description
                                + " Ticket Priority Level: " + ticket.priorityLevel + " Status: " + ticket.status);
                System.out.println();
            }
        } else {
            // no tickets stored
            System.out.println("\nNo Tickets Available..! Create one");
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