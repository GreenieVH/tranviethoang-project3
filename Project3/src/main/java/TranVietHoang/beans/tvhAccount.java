package TranVietHoang.beans;

public class tvhAccount {
	private int userId;
	private String userAccount;
	private String userName;
	private String userPassword;
	private String userEmail;
	private Boolean isAdmin;
	private Boolean isBan;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Boolean getIsBan() {
		return isBan;
	}
	public void setIsBan(Boolean isBan) {
		this.isBan = isBan;
	}
	public tvhAccount(int userId, String userAccount, String userName, String userPassword, String userEmail,
			Boolean isAdmin, Boolean isBan) {
		super();
		this.userId = userId;
		this.userAccount = userAccount;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.isAdmin = isAdmin;
		this.isBan = isBan;
	}
	
	public tvhAccount() {
		// TODO Auto-generated constructor stub
	}
}
