package org.pahappa.systems.ticketing.services.impl;

import org.pahappa.systems.ticketing.constants.TicketStatus;
import org.pahappa.systems.ticketing.models.Ticket;
import org.pahappa.systems.ticketing.services.TicketService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TicketServiceImpl implements TicketService {

    List<Ticket> ticketList = new ArrayList<>();

    @Override
    public void createTicket(Ticket ticket) {

        ticketList.add(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketList;
    }

    @Override
    public List<Ticket> getTicketsOfStatus(TicketStatus ticketStatus) {

        List<Ticket> sortedTickets = new ArrayList<>();

        for (Ticket ticket : ticketList) {
            if (ticket.getStatus() == ticketStatus) {
                sortedTickets.add(ticket);
            }
        }

        return sortedTickets;
    }

    @Override
    public void updateTicket(Ticket updatedTicket) {
        Scanner sc = new Scanner(System.in);
        String option;
        int selection = 0, maxSelection = 7; // maximum number of options available in menu
        while (selection < maxSelection) {
            System.out.println("Select the field to update");
            System.out.println(
                    "1: Client's Name\n2: Contact\n3: Category\n4: Description\n5: PriorityLevel\n6: TicketStatus\n 7: Close");
            option = sc.nextLine();
            if (option.matches("\\d+")) {
                int choice = Integer.parseInt(option);
                switch (choice) {
                    case 1:
                        System.out.println("Previous: " + updatedTicket.getClient());
                        System.out.println("New value: ");
                        String clientName = sc.nextLine();
                        updatedTicket.setClient(clientName);
                        ticketList.set(ticketList.indexOf(updatedTicket), updatedTicket);
                        break;
                    case 2:
                        System.out.println("Previous: " + updatedTicket.getContact());
                        System.out.println("New value: ");
                        String clientContact = sc.nextLine();
                        updatedTicket.setContact(clientContact);
                        ticketList.set(ticketList.indexOf(updatedTicket), updatedTicket);
                        break;
                    case 3:
                        System.out.println("Previous: " + updatedTicket.getCategory());
                        System.out.println("New value: ");
                        String ticketCategory = sc.nextLine();
                        updatedTicket.setCategory(ticketCategory);
                        ticketList.set(ticketList.indexOf(updatedTicket), updatedTicket);
                        break;
                    case 4:
                        System.out.println("Previous: " + updatedTicket.getDescription());
                        System.out.println("New value: ");
                        String ticketDesc = sc.nextLine();
                        updatedTicket.setDescription(ticketDesc);
                        ticketList.set(ticketList.indexOf(updatedTicket), updatedTicket);
                        break;
                    case 5:
                        System.out.println("Previous: " + updatedTicket.getPriorityLevel());
                        List<String> priority = new ArrayList<>(Arrays.asList("Low", "Medium", "High"));
                        System.out.print("Choose Ticket priority Level \n");

                        for (int i = 0; i < priority.size(); i++) {
                            System.out.println((i + 1) + ": " + priority.get(i));
                        }

                        System.out.println("New value: ");
                        try {
                            int num = sc.nextInt();
                            sc.nextLine();
                            updatedTicket.setPriorityLevel(priority.get(num - 1));
                            ticketList.set(ticketList.indexOf(updatedTicket), updatedTicket);

                        } catch (Exception e) {
                            System.out.println("Invalid input");
                        }

                        break;
                    case 6:
                        System.out.println("Previous: " + updatedTicket.getStatus());
                        System.out.println("Choose the status:");
                        for (int j = 0; j < TicketStatus.values().length; j++) {
                            System.out.println((j + 1) + ". " + TicketStatus.values()[j]);
                        }
                        System.out.println("New value: ");
                        try {
                            int statusChoice = sc.nextInt();
                            sc.nextLine();
                            TicketStatus nStatus = TicketStatus.values()[statusChoice - 1];
                            updatedTicket.setStatus(nStatus);
                            ticketList.set(ticketList.indexOf(updatedTicket), updatedTicket);
                        } catch (Exception e) {
                            System.out.println("Invalid input");
                        }

                        break;
                    case 7:
                        selection = 7;
                        break;
                    default:
                        System.out.println("\nInvalid choice. Please try again.");

                }
            } else {
                System.out.println("Input a number!..");
            }
            selection++;
        }

    }

    @Override
    public void deleteTicket(int index) {
        ticketList.remove(index);
    }
}
