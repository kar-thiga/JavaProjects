package air;
import java.sql.SQLException;
import java.util.Scanner;

public class Booking {
    private Passenger passenger;
    private Flight flight;
    private Payment payment;
    
    // Constructor
    public Booking(Passenger passenger,Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
    	
      }

    public Passenger getPassenger() { return passenger; }
    public Flight getFlight() { return flight; }
    public Payment getPayment() { return payment; }
   
 
    
    public void confirmBooking() throws SQLException {
        BookingDAO bookingDAO = new BookingDAO();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter payment amount: ");
        double amt = sc.nextDouble();
        payment = new Payment(amt);

        if (payment.confirmPayment(amt)) {
            if (flight.SeatisAvailable()) {
                flight.bookSeat();
                bookingDAO.addBooking(this);
                System.out.println("Your booking is confirmed.");
            } else {
                System.out.println("Booking failed. No available seats.");
            }
        } else {
            System.out.println("Your booking failed! Check your payment.");
        }
    }
    }


