package tollGate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TollManager {
    private List<TollBooth> allTollBooths;
    private List<Journey> allJourneys;

    public TollManager() {
        this.allTollBooths = new ArrayList<>();
        this.allJourneys = new ArrayList<>();
    }

    public void addTollBooth(TollBooth tollBooth) {
        allTollBooths.add(tollBooth);
    }

    public void addJourney(Journey journey) {
        allJourneys.add(journey);
    }

    public Map<String, Object> getTollDetails(TollBooth toll) {
        Map<String, Object> details = new HashMap<>();
        details.put("TollId", toll.getTollId());
        details.put("ChargingScheme", toll.getChargingScheme());

        List<Vehicle> vehiclesPassed = toll.getVechiclesPassed();
        List<Map<String, Object>> vehicleDetails = new ArrayList<>();

        for (Vehicle vehicle : vehiclesPassed){
            Map<String, Object> vehicleDetail = new HashMap<>();
            vehicleDetail.put("VehicleNumber", vehicle.getVehicleNumber());
            vehicleDetail.put("VehicleType", vehicle.getVehicleType().name());
            vehicleDetail.put("AmountPaid", toll.calculateToll(vehicle)); 
            vehicleDetails.add(vehicleDetail);
        }

        details.put("VehiclesPassed", vehicleDetails);
        return details;
    }

    public List<Journey> getVehicleJourneyDetails(Vehicle vehicle) {
        List<Journey> vehicleJourneys = new ArrayList<>();

        for (Journey journey : allJourneys) {
            if (journey.getVehicle().equals(vehicle)) { 
                vehicleJourneys.add(journey);
            }
        }

        return vehicleJourneys;
    }
    
    public List<TollBooth> getAllTollBooths() {
		return allTollBooths;
	}

	public void setAllTollBooths(List<TollBooth> allTollBooths) {
		this.allTollBooths = allTollBooths;
	}

	public List<Journey> getAllJourneys() {
		return allJourneys;
	}

	public void setAllJourneys(List<Journey> allJourneys) {
		this.allJourneys = allJourneys;
	}

	
}

