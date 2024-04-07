package TranVietHoang.beans;

public class UserCookie {
	private String userAccount;
	private String isAdmin;
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public UserCookie(String userAccount, String isAdmin) {
		super();
		this.userAccount = userAccount;
		this.isAdmin = isAdmin;
	}
	public UserCookie() {
		// TODO Auto-generated constructor stub
	}
}
