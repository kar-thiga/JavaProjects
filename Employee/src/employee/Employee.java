package employee;

public class Employee {

	String employeeId;
	String employeeName;
	double salary;
	int contractIdCounter;
	int permanentIdCounter;
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getContractIdCounter() {
		return contractIdCounter;
	}
	public void setContractIdCounter(int contractIdCounter) {
		this.contractIdCounter = contractIdCounter;
	}
	public int getPermanentIdCounter() {
		return permanentIdCounter;
	}
	public void setPermanentIdCounter(int permanentIdCounter) {
		this.permanentIdCounter = permanentIdCounter;
	}
	public int getAllocatedAssetIds(String lastDate) throws InvalidAssetsException {
		return 3;
	}
	
	public String[] getAllocatedAssetIds() {
        return new String[] {"DSK-123456H", "LTP-654321L"};
    }
	
	
}
