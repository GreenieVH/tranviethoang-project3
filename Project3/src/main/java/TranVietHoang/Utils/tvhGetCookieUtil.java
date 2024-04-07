package TranVietHoang.Utils;

import java.sql.Connection;
import java.sql.SQLException;

import TranVietHoang.beans.UserCookie;
import TranVietHoang.conn.TranVietHoangConnection;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class tvhGetCookieUtil {
	public static String GetUserCookieUser(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String usernameCookie = null;
		boolean isLoggedIn = false;
		if (cookies != null) {
		    for (Cookie cookie : cookies) {
		        if (cookie.getName().equals("userAccount")) {
		        	usernameCookie = cookie.getValue();
		            // Sử dụng giá trị của cookie username ở đây
		        }
		    }
		}
		
		try {
			Connection conn = TranVietHoangConnection.getMSSQLConnection();
			String cookie = tvhCookieUserUtil.getAdminAccount(conn, usernameCookie);
			return cookie;
		} catch (ClassNotFoundException e) {
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return null;
	}
}
