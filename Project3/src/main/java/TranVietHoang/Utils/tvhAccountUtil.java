package TranVietHoang.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TranVietHoang.beans.tvhAccount;
import TranVietHoang.beans.tvhProduct;

public class tvhAccountUtil {
	//Đọc danh sách 
		public static List<tvhAccount> queryAccount(Connection conn) throws SQLException{
			String sql = "Select userId,userAccount,userName,userPassword,userEmail,isAdmin,isBan from tvhUserAccount";
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			List<tvhAccount> list = new ArrayList<tvhAccount>();
			
			while (rs.next()) {
				int userId = rs.getInt("userId");
				String userAccount = rs.getString("userAccount");
				String userName = rs.getString("userName");
				String userPassword = rs.getString("userPassword");
				String userEmail = rs.getString("userEmail");
				Boolean isAdmin = rs.getBoolean("isAdmin");
				Boolean isBan = rs.getBoolean("isBan");
				tvhAccount acc = new tvhAccount();
				acc.setUserId(userId);
				acc.setUserAccount(userAccount);
				acc.setUserName(userName);
				acc.setUserPassword(userPassword);
				acc.setUserEmail(userEmail);
				acc.setIsAdmin(isAdmin);
				acc.setIsBan(isBan);
				list.add(acc);
				System.out.println(acc);
			}
			return list;
		}
		// dang ky tai khoan
		public static void Register(Connection conn, tvhAccount account) throws SQLException {
			String sql = "insert into tvhUserAccount( userAccount, userName, userPassword, userEmail,isAdmin,isBan) values(?,?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, account.getUserAccount());
			pstm.setString(2, account.getUserName());
			pstm.setString(3, account.getUserPassword());
			pstm.setString(4, account.getUserEmail());
			pstm.setBoolean(5, false);
			pstm.setBoolean(6, false);
			
			pstm.executeUpdate();
		}
}
