package Railway;

public class Passenger {

	private int passengerId;
	private String name;
	private int age;
	private String gender;
	private String email;
	private String seatNumber;
	
	public Passenger(int passengerId,String name,int age,String gender,String email) {
		this.passengerId = passengerId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.seatNumber = ""; 
	}
	
	public String getPassengerDetails() {
        return String.format("Passenger ID: %s, Name: %s, Age: %d, Gender: %s, Email: %s, Seat: %s", 
                             passengerId, name, age, gender, email, seatNumber);
    }

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSeatNumber() {
	return seatNumber;
	}
	
	public void setSeatNumber(String seatNumber) {
	    this.seatNumber = seatNumber; 
	}

	
}
