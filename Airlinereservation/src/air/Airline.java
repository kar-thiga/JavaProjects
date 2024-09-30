package air;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Airline {
    private AirlineDAO airlineDAO;

    public Airline() {
        this.airlineDAO = new AirlineDAO();
    }

    public void addFlight() throws SQLException {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        System.out.println("Enter Flight ID:");
        String flightId = sc.nextLine();
        System.out.println("Enter Flight Name:");
        String flightName = sc.nextLine();
        System.out.println("Enter Origin:");
        String origin = sc.nextLine();
        System.out.println("Enter Destination:");
        String destination = sc.nextLine();
        System.out.println("Enter Departure (yyyy-MM-dd HH:mm):");
        String departureTime = sc.nextLine();
        LocalDateTime departure = LocalDateTime.parse(departureTime, formatter);
        System.out.println("Enter Arrival (yyyy-MM-dd HH:mm):");
        String arrivalInput = sc.nextLine();
        LocalDateTime arrival = LocalDateTime.parse(arrivalInput, formatter);
        System.out.println("Enter Capacity:");
        int capacity = Integer.parseInt(sc.nextLine());

        airlineDAO.addingFlight(flightId, flightName, origin, destination, departure, arrival, capacity);
    }

    public void removeFlight() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Flight ID:");
        String id = sc.nextLine();
        airlineDAO.removeFlight(id);
    }

   

 void displayAllFlights() throws SQLException {
        List<Flight> flights = airlineDAO.getAllFlights();
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }

}

