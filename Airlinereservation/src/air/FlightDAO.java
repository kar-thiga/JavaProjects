package air;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class FlightDAO {

    public Flight getFlight(String flightId) throws SQLException {
        String query = "SELECT * FROM flights WHERE flight_id = ?";
        
        try (Connection con = DBconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, flightId);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                String id = rs.getString("flight_id");
                String flightName = rs.getString("flight_name");
                String origin = rs.getString("origin");
                String destination = rs.getString("destination");
                LocalDateTime departureTime = rs.getTimestamp("departure_time").toLocalDateTime();
                LocalDateTime arrivalTime = rs.getTimestamp("arrival_time").toLocalDateTime();
                int availableSeats = rs.getInt("available_seats");

                return new Flight(id, flightName, origin, destination, departureTime, arrivalTime, availableSeats);
            }
        }
        
        return null; 
    }

   
    
}

