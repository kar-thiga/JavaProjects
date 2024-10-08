package employee;
public class PermanentEmployee extends Employee{

	double basicPay;
	String[] salaryComponents;
	float Experience;
	Asset[] assets;
	
	public PermanentEmployee(String employeeName,double basicPay,String[] salaryComponents,Asset[] assets) {
		this.employeeName = employeeName; 
        this.basicPay = basicPay;
        this.salaryComponents = salaryComponents;
        this.assets = assets;
	}
	
	public void calculateSalary(float experience) {
		double salary =0;
		double bonus = 0;
        try {
            bonus = calculateBonus(experience);
        } catch (InvalidExperienceException e) {
            System.out.println(e.getMessage());
            bonus =0;
        }
        double daComponent = 0;
        double hraComponent =0;
        
        for(String component : salaryComponents) {
        	String[] parts = component.split("-");
        	String type = parts[0];
        	double percentage = Double.parseDouble(parts[1])/100;
        	if(type.equals("DA")) {
        		daComponent = basicPay * percentage;
        	}else if(type.equals("HRA")) {
        		hraComponent = basicPay * percentage;
            	
        	}
        }
		salary = Math.round( basicPay + daComponent +hraComponent+  bonus);
		
		
	}
	
	public double calculateBonus(float experience) throws InvalidExperienceException{
		if(experience < 2.5) {
		 throw new InvalidExperienceException("A minimum of 2.5 years is required for bonus!");
		}
		int bonus =0;
		
		if(experience >= 2.5 && experience < 4) {
			bonus = 2550;
		}
		else if(experience >= 4 && experience < 8) {
			bonus= 5000;
		}
		else if(experience >= 8 && experience < 12) {
			bonus= 8750;
		}
		else if(experience >=12) {
		 bonus = 13000;
		}
		return bonus ;
		
	}
	public double getBasicPay() {
		return basicPay;
	}
	public void setBasicPay(double basicPay) {
		this.basicPay = basicPay;
	}
	public String[] getSalaryComponents() {
		return salaryComponents;
	}
	public void setSalaryComponents(String[] salaryComponents) {
		this.salaryComponents = salaryComponents;
	}
	public float getExperience() {
		return Experience;
	}
	public void setExperience(float experience) {
		Experience = experience;
	}
	public Asset[] getAsset() {
		return assets;
	}
	public void setAsset(Asset[] asset) {
		this.assets = asset;
	}

	public int getAssetsByDate(String lastDate) {
		return 0;
	}
}

class InvalidExperienceException extends Exception {
	    public InvalidExperienceException(String message) {
	        super(message);
	    }
	}

	
	
