package air;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AirlineDAO {
    public void addingFlight(String flightId, String flightName, String origin, String destination, 
                             LocalDateTime departure, LocalDateTime arrival, int capacity) throws SQLException {
        String query = "INSERT INTO flights (flight_id, flight_name, origin, destination, departure_time, arrival_time, available_seats) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection con = DBconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            Timestamp depTimestamp = Timestamp.valueOf(departure);
            Timestamp arrTimestamp = Timestamp.valueOf(arrival);
            
            pst.setString(1, flightId);
            pst.setString(2, flightName);
            pst.setString(3, origin);
            pst.setString(4, destination);
            pst.setTimestamp(5, depTimestamp);
            pst.setTimestamp(6, arrTimestamp);
            pst.setInt(7, capacity);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Flight added successfully.");
            } else {
                System.out.println("Failed to add the flight.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error inserting flight data", e);
        }
    }

    public void removeFlight(String flightId) throws SQLException {
        String query = "DELETE FROM flights WHERE flight_id = ?";
        
        try (Connection con = DBconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, flightId);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Flight removed successfully.");
            } else {
                System.out.println("Failed to remove the flight.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error removing flight data", e);
        }
    }

    public List<Flight> getAllFlights() throws SQLException {
        List<Flight> flights = new ArrayList<>();
        String query = "SELECT * FROM flights";
        
        try (Connection con = DBconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                String flightId = rs.getString("flight_id");
                String flightName = rs.getString("flight_name");
                String origin = rs.getString("origin");
                String destination = rs.getString("destination");
                LocalDateTime departureTime = rs.getTimestamp("departure_time").toLocalDateTime();
                LocalDateTime arrivalTime = rs.getTimestamp("arrival_time").toLocalDateTime();
                int availableSeats = rs.getInt("available_seats");

                Flight flight = new Flight(flightId, flightName, origin, destination, departureTime, arrivalTime, availableSeats);
                flights.add(flight);
            }
        }
        
        return flights;
    }

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

