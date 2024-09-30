package air;
import java.time.LocalDateTime;

public class Flight {
	  private String flightId;
	    private String flightName;
	    private String origin;
	    private String destination;
	    private LocalDateTime departureTime;
	    private LocalDateTime arrivalTime;
	    private int availableSeats;

	    public Flight(String flightId, String flightName, String origin, String destination,
	                  LocalDateTime departureTime, LocalDateTime arrivalTime, int availableSeats) {
	        this.flightId = flightId;
	        this.flightName = flightName;
	        this.origin = origin;
	        this.destination = destination;
	        this.departureTime = departureTime;
	        this.arrivalTime = arrivalTime;
	        this.availableSeats = availableSeats;
	    }

	    // Getters for the fields
	    public String getFlightId() { 
	    	return flightId; }
	    public String getFlightName() { 
	    	return flightName; }
	    public String getOrigin() { 
	    	return origin; }
	    public String getDestination() { 
	    	return destination; }
	    public LocalDateTime getDepartureTime() { 
	    	return departureTime; }
	    public LocalDateTime getArrivalTime() { 
	    	return arrivalTime; }
	    public int getAvailableSeats() { 
	    	return availableSeats; }

    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        }
    }

    public boolean SeatisAvailable() {
        return availableSeats > 0;
    }
    
    public String toString() {
        return "Flight ID: " + flightId + ", Flight Name: " + flightName + ", Origin: " + origin +
               ", Destination: " + destination + ", Departure Time: " + departureTime +
               ", Arrival Time: " + arrivalTime + ", Available Seats: " + availableSeats;
    }
}




