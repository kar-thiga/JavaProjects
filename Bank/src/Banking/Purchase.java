package Banking;


import java.util.Date;

public class Purchase {
    private int purchaseId;
    private float amount;
    private Date date;
    private String description;
    private int rewardPoints; 


    private static int idCounter = 0;

    public Purchase(float amount, String description) {
        this.purchaseId = ++idCounter;
        this.amount = amount;
        this.date = new Date(); 
        this.description = description;
        this.rewardPoints = calculateRewardPoints(amount); 
    }

    private int calculateRewardPoints(float amount) {
        return (int) (amount / 10);
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public float getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseId=" + purchaseId +
                ", amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", rewardPoints=" + rewardPoints +
                '}';
    }
}
