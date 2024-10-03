package Railway;

import java.util.Date;

public class Booking {
    private String bookingId;
    private Passenger passenger;
    private Train train;
    private int numberOfSeats;
    private Date bookingDate;
    private String status; 

    
    public Booking(String bookingId, Passenger passenger, Train train, int numberOfSeats) {
        this.bookingId = bookingId;
        this.passenger = passenger;
        this.train = train;
        this.numberOfSeats = numberOfSeats;
        this.bookingDate = new Date(); 
        this.status = "Confirmed"; 
    }

    public void createBooking(Availability availability) {
        if (availability.checkAvailability(numberOfSeats)) {
            availability.updateAvailability(numberOfSeats); 
            System.out.println("Booking created successfully!");
        } else {
            System.out.println("Booking failed: Not enough available seats.");
            status = "Failed";
        }
    }

  
    public void cancelBooking(Availability availability) {
        if (status.equals("Confirmed")) {
            availability.updateAvailability(-numberOfSeats); 
            status = "Cancelled"; 
            System.out.println("Booking cancelled successfully!");
        } else {
            System.out.println("Cannot cancel: Booking is already cancelled or failed.");
        }
    }

   
    public String getDetails() {
        return String.format("Booking ID: %s, Passenger: %s, Train: %s, Number of Seats: %d, Booking Date: %s, Status: %s",
                             bookingId, passenger.getPassengerDetails(), train.getTrainName(), numberOfSeats, bookingDate.toString(), status);
    }

    
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public String getStatus() {
        return status;
    }
}
