package tollGate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        VehicleType carType = VehicleType.CAR;
        VehicleType truckType = VehicleType.TRUCK;
        VehicleType motorCycleType = VehicleType.MOTORCYCLE;
        VehicleType busType = VehicleType.BUS;
        VehicleType vanType = VehicleType.VAN;

        // Create vehicles
        Vehicle vehicle1 = new Vehicle("ABC123", carType, true);
        Vehicle vehicle2 = new Vehicle("XYZ456", truckType, false);
        Vehicle vehicle3 = new Vehicle("KLR123", vanType, true);
        Vehicle vehicle4 = new Vehicle("OPS456", motorCycleType, false);
        Vehicle vehicle5 = new Vehicle("ASA123", busType, true);
        Vehicle vehicle6 = new Vehicle("EYZ456", vanType, false);

        // Create a toll manager
        TollManager tollManager = new TollManager();

        // Create toll booths and their charging schemes
        TollBooth tollBooth1 = new TollBooth("Toll1");
        TollBooth tollBooth2 = new TollBooth("Toll2");
        TollBooth tollBooth3 = new TollBooth("Toll3");
        TollBooth tollBooth4 = new TollBooth("Toll4");

        // Adding charging schemes
        for (TollBooth tollBooth : List.of(tollBooth1, tollBooth2, tollBooth3, tollBooth4)) {
            tollBooth.addChargingScheme(carType, 100.0);
            tollBooth.addChargingScheme(truckType, 150.0);
            tollBooth.addChargingScheme(motorCycleType, 50.0);
            tollBooth.addChargingScheme(busType, 200.0);
            tollBooth.addChargingScheme(vanType, 250.0);
        }

        // Add vehicles to toll booths
        tollBooth1.addVehiclesPassed(vehicle1);
        tollBooth1.addVehiclesPassed(vehicle2);
        tollBooth2.addVehiclesPassed(vehicle3);
        tollBooth2.addVehiclesPassed(vehicle4);
        tollBooth3.addVehiclesPassed(vehicle5);
        tollBooth3.addVehiclesPassed(vehicle6);
        tollBooth4.addVehiclesPassed(vehicle1);
        tollBooth4.addVehiclesPassed(vehicle2);

        // Add the toll booths to the toll manager
        tollManager.addTollBooth(tollBooth1);
        tollManager.addTollBooth(tollBooth2);
        tollManager.addTollBooth(tollBooth3);
        tollManager.addTollBooth(tollBooth4);

        // Create and add journeys for each vehicle
        List<TollBooth> vehicle1Tolls = new ArrayList<>();
        vehicle1Tolls.add(tollBooth1);
        vehicle1Tolls.add(tollBooth4);
        Journey journey1 = new Journey(vehicle1, "StartPointA", "EndPointA", vehicle1Tolls);
        tollManager.addJourney(journey1);

        List<TollBooth> vehicle2Tolls = new ArrayList<>();
        vehicle2Tolls.add(tollBooth1);
        vehicle2Tolls.add(tollBooth4);
        Journey journey2 = new Journey(vehicle2, "StartPointB", "EndPointB", vehicle2Tolls);
        tollManager.addJourney(journey2);

        List<TollBooth> vehicle3Tolls = new ArrayList<>();
        vehicle3Tolls.add(tollBooth2);
        Journey journey3 = new Journey(vehicle3, "StartPointC", "EndPointC", vehicle3Tolls);
        tollManager.addJourney(journey3);

        List<TollBooth> vehicle4Tolls = new ArrayList<>();
        vehicle4Tolls.add(tollBooth2);
        Journey journey4 = new Journey(vehicle4, "StartPointD", "EndPointD", vehicle4Tolls);
        tollManager.addJourney(journey4);

        List<TollBooth> vehicle5Tolls = new ArrayList<>();
        vehicle5Tolls.add(tollBooth3);
        Journey journey5 = new Journey(vehicle5, "StartPointE", "EndPointE", vehicle5Tolls);
        tollManager.addJourney(journey5);

        List<TollBooth> vehicle6Tolls = new ArrayList<>();
        vehicle6Tolls.add(tollBooth3);
        Journey journey6 = new Journey(vehicle6, "StartPointF", "EndPointF", vehicle6Tolls);
        tollManager.addJourney(journey6);


        for (int i = 1; i <= 4; i++) {
            Map<String, Object> tollDetails = tollManager.getTollDetails(tollManager.getAllTollBooths().get(i - 1)); // Assuming you have a method to get all toll booths
            System.out.println("Toll Details for Toll " + i + ":");
            System.out.println("Toll ID: " + tollDetails.get("TollId"));
            System.out.println("Charging Scheme: " + tollDetails.get("ChargingScheme"));
            
            List<Map<String, Object>> vehiclesPassed = (List<Map<String, Object>>) tollDetails.get("VehiclesPassed");
            System.out.println("Vehicles Passed:");
            for (Map<String, Object> vehicle : vehiclesPassed) {
                System.out.println("  Vehicle Number: " + vehicle.get("VehicleNumber"));
                System.out.println("  Vehicle Type: " + vehicle.get("VehicleType"));
                System.out.println("  Amount Paid: " + vehicle.get("AmountPaid"));
            }
            System.out.println(); 
        }
        
        List<Journey> journeysForVehicle1 = tollManager.getVehicleJourneyDetails(vehicle1);
        for (Journey journey : journeysForVehicle1) {
            System.out.println("Journey Details for Vehicle " + vehicle1.getVehicleNumber() + ":");
            System.out.println("  Vehicle: " + journey.getVehicle());
            System.out.println("  Start Point: " + journey.getStartPoint());
            System.out.println("  End Point: " + journey.getEndPoint());
            System.out.println("  Total Amount Paid: " + journey.getTotalAmountPaid());
            System.out.println("  Toll Passes:");
            for (TollBooth toll : journey.getTollsPassed()) {
                System.out.println("    " + toll);
            }
            System.out.println();
        }

    }
}


