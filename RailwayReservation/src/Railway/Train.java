package Railway;

public class Train {

	private int trainNumber;
	private String trainName;
	private String source;
	private String destination;
	private Schedule schedule;

	public Train(int trainNumber,String trainName,String source,String destination,Schedule schedule) {
		this.trainNumber = trainNumber;
		this.trainName = trainName;
		this.source = source;
		this.destination = destination;
		this.schedule = schedule;
		
	}
	
	public String getDetails() {
        return String.format("Train ID: %d, Train Name: %s, Source: %s, Destination: %s, Schedule: %s",
                             trainNumber, trainName, source, destination, schedule.toString());
    }

	
	

	public int getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
}

//+-------------------+
//|      Train        |
//+-------------------+
//| - trainId         |
//| - trainName       |
//| - source          |
//| - destination     |
//| - schedule        |
//+-------------------+
//| + getDetails()    |
//| + getAvailability()|
//+-------------------+