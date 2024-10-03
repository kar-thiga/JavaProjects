package Railway;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        Schedule schedule = new Schedule(new Date(), new Date(System.currentTimeMillis() + 3600000), "Mon-Sun");
        Train train = new Train(101, "Express Train", "City A", "City B", schedule);

        Availability availability = new Availability(train, new Date());

        System.out.println("Train Details: " + train.getDetails());

       
        System.out.print("Enter number of tickets you want to book: ");
        int numberOfTickets = scanner.nextInt();
        scanner.nextLine(); 

        
        List<Passenger> passengers = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            System.out.println("Entering details for Passenger " + (i + 1) + ":");
            System.out.print("Passenger ID: ");
            int passengerId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Gender: ");
            String gender = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();

            Passenger passenger = new Passenger(passengerId, name, age, gender, email);
            passengers.add(passenger);
        }

        Chart chart = new Chart(train, passengers);
        chart.prepareChart();

        Booking booking = new Booking("BKG" + System.currentTimeMillis(), passengers.get(0), train, numberOfTickets);
        booking.createBooking(availability);

        System.out.println("\nBooking Details:");
        System.out.println(booking.getDetails());

        scanner.close();
    }
}
