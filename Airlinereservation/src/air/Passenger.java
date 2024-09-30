package air;
import java.sql.SQLException;
import java.util.Scanner;

public class Passenger {
    private String passengerId;
    private String name;
    private String email;
    private String contactNumber;
    private String passportNumber;

    public Passenger() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Passenger ID: ");
        this.passengerId = scanner.nextLine();
        System.out.print("Enter Name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter Email: ");
        this.email = scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        this.contactNumber = scanner.nextLine();
        System.out.print("Enter Passport Number: ");
        this.passportNumber = scanner.nextLine();
    }

    public void addPassengerDetails() throws SQLException {
        PassengerDAO passengerDAO = new PassengerDAO();
        passengerDAO.addPassenger(this);
    }

    // Getters
    public String getPassengerId() { return passengerId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getContactNumber() { return contactNumber; }
    public String getPassportNumber() { return passportNumber; }
    
    public void bookFlight(Passenger passenger,Flight flight) throws SQLException {
    	
		if(flight.SeatisAvailable()) {
			Booking booking = new Booking(passenger,flight);
		    booking.confirmBooking();
		    
		    flight.bookSeat();
		}else {
			System.out.println("Seat is Full try another Flight");
		}
		
		
    }
}
