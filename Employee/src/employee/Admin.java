package employee;

public class Admin {

	public void generateSalarySlip(Employee[] employees, float[] salaryFactor) {
	    if (employees == null || salaryFactor == null || employees.length != salaryFactor.length) {
	        throw new IllegalArgumentException("Invalid input: Employees and salary factors must have the same length.");
	    }

	    for (int i = 0; i < employees.length; i++) {
	        Employee employee = employees[i];
	        float factor = salaryFactor[i];

	        if (employee instanceof PermanentEmployee) {
	            ((PermanentEmployee) employee).calculateSalary(factor);
	        } else if (employee instanceof ContractEmployee) {
	            ((ContractEmployee) employee).calculateSalary(factor);
	        } else {
	            throw new IllegalArgumentException("Unknown employee type at index " + i);
	        }
	    }
	}

	
	public int generateAssetsReport(Employee[] employees, String lastDate) throws InvalidAssetsException {
	    int totalAssets = 0;

	    for (Employee employee : employees) {
	        if (employee instanceof PermanentEmployee) {
	            PermanentEmployee permEmp = (PermanentEmployee) employee;
	            totalAssets += permEmp.getAssetsByDate(lastDate);
	        }
	    }

	    return totalAssets;
	}
    	 
    public String[] generateAssetsReport(Employee[] employees,char assetCategory) {
    	 if (employees == null) {
             throw new IllegalArgumentException("Employees array cannot be null.");
             
         }
    	 
    	 assetCategory = Character.toLowerCase(assetCategory);
         String[] result = new String[employees.length * 3];
         int index = 0;

         for (Employee employee : employees) {
             String[] assetIds = employee.getAllocatedAssetIds(); 
             if (assetIds != null) {
                 for (String assetId : assetIds) {
                     if (assetId.toLowerCase().charAt(0) == assetCategory && index < result.length) {
                         result[index++] = assetId; 
                     }
                 }
             }
         }
         return result;
     }
}