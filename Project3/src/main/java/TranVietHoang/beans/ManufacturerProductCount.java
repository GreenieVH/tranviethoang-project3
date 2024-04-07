package TranVietHoang.beans;

public class ManufacturerProductCount {
	private String manufacturerName;
    private int totalProducts;
	public String getManufacturerName() {
		return manufacturerName;
	}
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
	public int getTotalProducts() {
		return totalProducts;
	}
	public void setTotalProducts(int totalProducts) {
		this.totalProducts = totalProducts;
	}
	public ManufacturerProductCount(String manufacturerName, int totalProducts) {
		super();
		this.manufacturerName = manufacturerName;
		this.totalProducts = totalProducts;
	}
    
    public ManufacturerProductCount() {
		// TODO Auto-generated constructor stub
	}
}
