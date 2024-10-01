package tollGate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TollBooth {

	private String tollId;
	private Map<VehicleType,Double> chargingScheme;
	private List<Vehicle> vehiclesPassed;
	
	 public TollBooth(String tollId) {
	        this.tollId = tollId;
	        this.chargingScheme = new HashMap<>();
	        this.vehiclesPassed = new ArrayList<>();
	    }
	public String getTollId() {
		return tollId;
	}
	public void setTollId(String tollId) {
		this.tollId = tollId;
	}
	public Map<VehicleType, Double> getChargingScheme() {
        return chargingScheme;
    }
	public void addChargingScheme(VehicleType type , double amount) {
		chargingScheme.put(type,amount);
	}
	public List<Vehicle> getVechiclesPassed() {
		return vehiclesPassed;
	}
	public void addVehiclesPassed(Vehicle vehicle) {
		 vehiclesPassed.add(vehicle);
	}
	
	public double calculateToll(Vehicle vehicle) {
		
		VehicleType type = vehicle.getVehicleType();
		Double baseCharge = chargingScheme.get(type);
		if (baseCharge == null) {
	        throw new IllegalArgumentException("No toll charge found for vehicle type: " + type);
	    }
		
		Double amount = baseCharge;
		if(vehicle.isVip()) {
			amount = vehicle.calculateDiscount(amount);
		}
		return amount;
	}
	public Map<String, Object> getDetails() {
		Map<String,Object> details = new HashMap<>();
		details.put("TollId",tollId );
		details.put("ChargingScheme", chargingScheme);
		details.put("VehiclesPassed", vehiclesPassed);
		
		return details;
	}
	
	@Override
	public String toString() {
	    return "TollBooth ID: " + tollId;
	}

}
