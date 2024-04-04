package TranVietHoang.conn;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import TranVietHoang.Utils.tvhProductUtil;
import TranVietHoang.beans.tvhProduct;

public class TestConn {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		String errorString = null;
		List<tvhProduct> list = null;

		conn = TranVietHoang.conn.TranVietHoangConnection.getMSSQLConnection();
		
		try {
			list = tvhProductUtil.queryProduct(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		System.out.println(list);
	}
}
