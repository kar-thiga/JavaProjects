package Railway;

import java.util.Date;

public class Schedule {
    private Date departureTime;
    private Date arrivalTime;
    private String daysOfOperation;


    public Schedule(Date departureTime, Date arrivalTime, String daysOfOperation) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.daysOfOperation = daysOfOperation;
    }
    
    @Override
    public String toString() {
        return String.format("Departure: %s, Arrival: %s, Days: %s",
                             departureTime.toString(), arrivalTime.toString(), daysOfOperation);
    }

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDaysOfOperation() {
		return daysOfOperation;
	}

	public void setDaysOfOperation(String daysOfOperation) {
		this.daysOfOperation = daysOfOperation;
	}
}
