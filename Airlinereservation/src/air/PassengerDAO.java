package air;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PassengerDAO {
    public void addPassenger(Passenger passenger) throws SQLException {
        String query = "INSERT INTO passengers (passenger_id, name, email, contact_number, passport_number) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = DBconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            
            pst.setString(1, passenger.getPassengerId());
            pst.setString(2, passenger.getName());
            pst.setString(3, passenger.getEmail());
            pst.setString(4, passenger.getContactNumber());
            pst.setString(5, passenger.getPassportNumber());
            
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Passenger added successfully.");
            } else {
                System.out.println("Failed to add the passenger.");
            }
        }
    }
}
