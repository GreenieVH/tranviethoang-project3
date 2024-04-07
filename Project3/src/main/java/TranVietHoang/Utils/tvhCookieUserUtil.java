package TranVietHoang.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TranVietHoang.beans.tvhAccount;

public class tvhCookieUserUtil {
	
	public static String getAdminAccount(Connection conn,String userAccount) throws SQLException{
		String sql = "Select isAdmin from tvhUserAccount where userAccount =?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userAccount);
		ResultSet rs = pstm.executeQuery();
		tvhAccount acc = new tvhAccount();
		
		while (rs.next()) {
			
			Boolean isAdmin = rs.getBoolean("isAdmin");
			if(isAdmin) {
				return "OK";
			}
		}
		return null;
	}
}
