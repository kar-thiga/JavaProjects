package employee;

public class Asset {
    private String assetId;
    private String assetName;
    private String validTill;

    public Asset(String assetId, String assetName, String validTill) {
        if (!isValidAssetId(assetId)) {
            throw new IllegalArgumentException("Invalid Asset ID format");
        }
        this.assetId = assetId;
        this.assetName = assetName;
        this.validTill = validTill;
    }

    private boolean isValidAssetId(String assetId) {
        return assetId != null && assetId.matches("^(DSK|LTP|IPH)-\\w+$");
    }

    public String getAssetId() {
        return assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public String getValidTill() {
        return validTill;
    }
}
