package employee;

public class ContractEmployee extends Employee{
	double wagePerHour;
	
	public ContractEmployee(String employeeName,double wagePerHour){
		this.employeeName = employeeName;
		this.wagePerHour=wagePerHour;
	}
	
	public double getWagePerHour() {
		return wagePerHour;
	}

	public void setWagePerHour(double wagePerHour) {
		this.wagePerHour = wagePerHour;
	}

	

	public void calculateSalary(float hoursWorked) {
		
		double salary =0;
		salary = wagePerHour * hoursWorked;
		System.out.println("Salary for " + employeeName + salary);
	}
	
	
}
