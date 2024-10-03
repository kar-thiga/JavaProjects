package Railway;

import java.util.Date;

public class Availability {

	private Train train;
	private Date date;
	private int availableSeats;
	
	public Availability(Train train,Date date) {
		this.train = train;
		this.date = date;
		this.availableSeats = 500;
	}
	
	public boolean checkAvailability(int numberOfTickets) {
	    if (this.availableSeats >= numberOfTickets) {
	        System.out.println("Tickets are Available!");
	        return true;
	    }
	    System.out.println("Tickets Not Available! Check for Other Dates");
	    return false;
	}

	
	public void updateAvailability(int ticketsBooked) {
		availableSeats -= ticketsBooked;
		System.out.println("Updated available seats: " + availableSeats);
	}
	
	 public String getAvailabilityDetails() {
	        return String.format("Train: %s, Date: %s, Available Seats: %d",
	                             train.getTrainName(), date.toString(), availableSeats);
	    }

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
}
