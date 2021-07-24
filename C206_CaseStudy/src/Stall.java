
public class Stall { //Umar
	private int stallNo;
	private String storeName;
	private String operationDate;
	
	public Stall(int stallNo, String storeName, String operationDate) {
		this.stallNo = stallNo;
		this.storeName = storeName;
		this.operationDate = operationDate;
	}

	public int getStallNo() {
		return stallNo;
	}

	public String getStoreName() {
		return storeName;
	}

	public String getOperationDate() {
		return operationDate;
	}
}
