package employee;

public class Main {
    public static void main(String[] args) throws InvalidAssetsException {
        Asset[] assets = {
            new Asset("DSK-876761L", "Dell-Desktop", "2020-Dec-01"),
            new Asset("DSK-876762L", "Acer-Desktop", "2021-Mar-31"),
            new Asset("DSK-876763L", "Dell-Desktop", "2022-Jun-12"),
            new Asset("LTP-987123H", "Dell-Laptop", "2021-Dec-31"),
            new Asset("LTP-987124h", "Dell-Laptop", "2021-Sep-20"),
            new Asset("LTP-987125L", "HP-Laptop", "2022-Oct-25"),
            new Asset("LTP-9871261", "HP-Laptop", "2021-Oct-02"),
            new Asset("IPH-110110h", "VoIP", "2021-Dec-12"),
            new Asset("IPH-110130h", "VoIP", "2020-Dec-31"),
            new Asset("IPH-110130h", "VoIP", "2020-Nov-30")
        };

        assets[8] = new Asset("IPH-110120h", "VoIP", "2020-Dec-31");

        String[] salaryComponents1 = {"DA-10", "HRA-20"};
        PermanentEmployee permanentEmployee1 = new PermanentEmployee("Roger Fed", 32000, salaryComponents1, assets);

        String[] salaryComponents2 = {"DA-15", "HRA-25"};
        PermanentEmployee permanentEmployee2 = new PermanentEmployee("null", 25200, salaryComponents2, new Asset[] {
            assets[5], assets[8]
        });

        PermanentEmployee permanentEmployee3 = new PermanentEmployee("James Peter", 41075, salaryComponents2, new Asset[] {
            assets[3]
        });

        PermanentEmployee permanentEmployee4 = new PermanentEmployee("Catherine Maria", 47750, salaryComponents2, new Asset[] {
            assets[1], assets[4] 
        });

        PermanentEmployee permanentEmployee5 = new PermanentEmployee("Jobin Nick", 0, salaryComponents2, new Asset[] {});

        ContractEmployee contractEmployee1 = new ContractEmployee("null", 13195);
        ContractEmployee contractEmployee2 = new ContractEmployee("Ricky Neol", 15298);

        Employee[] employees = {
            permanentEmployee1,
            permanentEmployee2,
            permanentEmployee3,
            permanentEmployee4,
            permanentEmployee5,
            contractEmployee1,
            contractEmployee2
        };

        Admin admin = new Admin();
        
        System.out.println("Initiating salary calculation...");
        float[] salaryFactors = {3.9f, 2.3f, 4.0f, 8.1f, 12.5f, 40.0f, 35.0f};
        admin.generateSalarySlip(employees, salaryFactors);

        System.out.println("\nReports:");
        String lastDate = "2021-Dec-31";
        int totalAssets = admin.generateAssetsReport(employees, lastDate);
        System.out.println("Number of allocated assets expiring on or before " + lastDate + ": " + totalAssets);

        System.out.println("All the allocated desktop assets:");
        printAssetsByPrefix(assets, "DSK");

        System.out.println("All the allocated laptop assets:");
        printAssetsByPrefix(assets, "LTP");

        System.out.println("All the allocated VoIP assets:");
        printAssetsByPrefix(assets, "IPH");
    }

    private static void printAssetsByPrefix(Asset[] assets, String prefix) {
        for (Asset asset : assets) {
            if (asset.getAssetId().startsWith(prefix)) {
                System.out.println(asset.getAssetId());
            }
        }
    }
}


