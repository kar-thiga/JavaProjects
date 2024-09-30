package air;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Airline airline = new Airline();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Airline Reservation System ---");
            
            System.out.println("1. Display All Flights");
            System.out.println("2. Add Flight");
            System.out.println("3. Remove Flight");
            System.out.println("4. Book Flight");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            try {
                switch (choice) {
                    case 1:
                        airline.displayAllFlights();
                        break;
                    case 2:
                        airline.addFlight();
                        break;
                    case 3:
                        airline.removeFlight();
                        break;
                    case 4:
                        System.out.print("Enter Flight ID to book: ");
                        String flightId = scanner.nextLine();
                        FlightDAO flightDAO = new FlightDAO();
                        Flight flight = flightDAO.getFlight(flightId);
                        if (flight != null) {
                            Passenger passenger = new Passenger();
                            passenger.addPassengerDetails();
                            passenger.bookFlight(passenger, flight);
                        } else {
                            System.out.println("Flight not found.");
                        }
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (SQLException e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
