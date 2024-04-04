package TranVietHoang.beans;

public class tvhProduct {
	private int productId;
	private String productName;
	private String productDetail;
	private float productPrice;
	private int categoryLowId;
	private int manufacturerId;
	private String productImg;
	
	public tvhProduct() {
		// TODO Auto-generated constructor stub
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public int getCategoryLowId() {
		return categoryLowId;
	}

	public void setCategoryLowId(int categoryLowId) {
		this.categoryLowId = categoryLowId;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public tvhProduct(int productId, String productName, String productDetail, float productPrice, int categoryLowId,
			int manufacturerId, String productImg) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDetail = productDetail;
		this.productPrice = productPrice;
		this.categoryLowId = categoryLowId;
		this.manufacturerId = manufacturerId;
		this.productImg = productImg;
	}
	
}
