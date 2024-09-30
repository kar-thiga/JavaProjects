package air;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookingDAO {
    public void addBooking(Booking booking) throws SQLException {
        String query = "INSERT INTO bookings (flight_id, passenger_id, payment_amount, booking_time) VALUES (?, ?, ?, ?)";
        
        try (Connection con = DBconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            
            pst.setString(1, booking.getFlight().getFlightId()); 
            pst.setString(2, booking.getPassenger().getPassengerId()); 
            pst.setDouble(3, booking.getPayment().getPaymentAmt());
            pst.setTimestamp(4, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));

            pst.executeUpdate();
        }
    }
}
