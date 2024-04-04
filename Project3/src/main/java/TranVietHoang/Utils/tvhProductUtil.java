package TranVietHoang.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TranVietHoang.beans.tvhProduct;



public class tvhProductUtil {
	//Đọc danh sách 
	public static List<tvhProduct> queryProduct(Connection conn) throws SQLException{
		String sql = "Select a.productId, a.productName, a.productDetail,a.productPrice,a.categoryLowId,a.manufacturerId,a.productImg from tvhProduct a";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<tvhProduct> list = new ArrayList<tvhProduct>();
		
		while (rs.next()) {
			int productId = rs.getInt("productId");
			String productName = rs.getString("productName");
			String productDetail = rs.getString("productDetail");
			float productPrice = rs.getFloat("productPrice");
			int categoryLowId = rs.getInt("categoryLowId");
			int manufacturerId = rs.getInt("manufacturerId");
			String productImg = rs.getString("productImg");
			tvhProduct product = new tvhProduct();
			product.setProductId(productId);
			product.setProductName(productName);
			product.setProductDetail(productDetail);
			product.setProductPrice(productPrice);
			product.setCategoryLowId(categoryLowId);
			product.setManufacturerId(manufacturerId);
			product.setProductImg(productImg);
			list.add(product);
			System.out.println(product);
		}
		return list;
	}
}
