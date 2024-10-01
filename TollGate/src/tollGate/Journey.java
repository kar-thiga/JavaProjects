package tollGate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Journey {

	private Vehicle vehicle;
	private String startPoint;
	private String endPoint;
	private List<TollBooth> tollsPassed;
	private double totalAmountPaid;
	
	public Journey(Vehicle vehicle, String startPoint, String endPoint, List<TollBooth> tollsPassed) {
	    this.vehicle = vehicle;
	    this.startPoint = startPoint;
	    this.endPoint = endPoint;
	    this.tollsPassed = tollsPassed;
	    this.totalAmountPaid = calculateTotalAmount(tollsPassed); 
	}

	
	public double calculateTotalAmount(List<TollBooth> tollsPassed) {
		double totalAmount =0;
		for(TollBooth passed : tollsPassed) {
			totalAmount += passed.calculateToll(vehicle) ;
		}
		return totalAmount;
	}
	
	public Map<String, Object> getDetails() {
		Map<String,Object> details = new HashMap<>();
		details.put("Vehicle",vehicle);
		details.put("StartPoint", startPoint);
		details.put("EndPoint", endPoint);
		details.put("TollPasses",tollsPassed);
		details.put("TotalAmountPaid", totalAmountPaid);
		
		return details;
	}
	public Vehicle getVehicle() {
        return vehicle; 
    }
	
	public String getStartPoint() {
		return startPoint;
	}


	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}


	public String getEndPoint() {
		return endPoint;
	}


	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}


	public List<TollBooth> getTollsPassed() {
		return tollsPassed;
	}


	public void setTollsPassed(List<TollBooth> tollsPassed) {
		this.tollsPassed = tollsPassed;
	}


	public double getTotalAmountPaid() {
		return totalAmountPaid;
	}


	public void setTotalAmountPaid(double totalAmountPaid) {
		this.totalAmountPaid = totalAmountPaid;
	}


	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
