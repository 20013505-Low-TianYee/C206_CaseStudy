

public class Promo extends Stall {//YY
	private String PromoName;
	private String Description;
	
	public Promo(String storeName, String ownerName, String operationDate, String PromoName, String Description) {
		super(storeName, ownerName, operationDate  );
		this.PromoName = PromoName;
		this.Description = Description;
	}
	public String getPromoName(){
		return PromoName;
	}
	public String gerDescription() {
		return Description;
	}
	public void setPromoName(String PromoName) {
		this.PromoName = PromoName;
	}
	public void setDescription(String Description) {
		this.Description = Description;
	}
	public void display() {

		System.out.printf("%-30s %-30s %-30s\n",super.getStoreName(), PromoName, Description);

	}
	

}
