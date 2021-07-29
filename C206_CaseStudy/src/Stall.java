
public class Stall { //Umar

	private String storeName;
	private String ownerName;
	private String operationDate;
	
	public Stall(String storeName, String ownerName, String operationDate) {
		this.storeName = storeName;
		this.ownerName = ownerName;
		this.operationDate = operationDate;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public String getStoreName() {
		return storeName;
	}

	public String getOperationDate() {
		return operationDate;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String toStringStall() {
		String stallInfo = String.format("%-25s %-25s %-25s", storeName, ownerName, operationDate);
		return stallInfo;
	}
}
