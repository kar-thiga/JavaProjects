package Railway;


import java.util.List;

public class Chart {
    private Train train; 
    private List<Passenger> passengers; 

    
    public Chart(Train train, List<Passenger> passengers) {
        this.train = train;
        this.passengers = passengers;
    }

    public void prepareChart() {
        System.out.println("Preparing chart for train: " + train.getTrainName());
        char seatLetter = 'A'; 
        
        for (int i = 0; i < passengers.size(); i++) {
            int seatRow = (i / 4) + 1;
            seatLetter = (char) ('A' + (i % 4)); 

            String seatNumber = seatRow + "" + seatLetter; 
            passengers.get(i).setSeatNumber(seatNumber); 
            System.out.println(passengers.get(i).getPassengerDetails());
        }
        
    }

    
    public String getDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Train: ").append(train.getTrainName()).append("\nPassengers:\n");
        for (Passenger passenger : passengers) {
            details.append(passenger.getPassengerDetails()).append("\n");
        }
        return details.toString();
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
