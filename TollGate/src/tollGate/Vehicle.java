package tollGate;

import java.util.HashMap;
import java.util.Map;

public class Vehicle {

    String vehicleNumber;
  
    public Vehicle(String vehicleNumber, VehicleType vehicleType, boolean isVip) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.isVip = isVip;
    }

    public double calculateDiscount(double amount) { 
        double discount = 0;
        if (isVip) {
            discount = amount * 0.20;
            amount -= discount;
        }
        return amount;
    }

    public Map<String, Object> getDetails() {
        Map<String, Object> details = new HashMap<>();
        details.put("vehicleNumber", vehicleNumber);
        details.put("vehicleType", vehicleType.name()); 
        details.put("isVip", isVip);
        return details;
    }
    public String getVehicleNumber() {
  		return vehicleNumber;
  	}

  	public void setVehicleNumber(String vehicleNumber) {
  		this.vehicleNumber = vehicleNumber;
  	}

  	public VehicleType getVehicleType() {
  		return vehicleType;
  	}

  	public void setVehicleType(VehicleType vehicleType) {
  		this.vehicleType = vehicleType;
  	}

  	public boolean isVip() {
  		return isVip;
  	}

  	public void setVip(boolean isVip) {
  		this.isVip = isVip;
  	}

  	private VehicleType vehicleType; 
      boolean isVip;

      @Override
      public String toString() {
          return "VehicleNumber: " + vehicleNumber + 
                 ", VehicleType: " + vehicleType.name() + 
                 ", VIP: " + isVip;
      }

}


