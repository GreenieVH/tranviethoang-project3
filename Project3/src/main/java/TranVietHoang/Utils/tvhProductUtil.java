package TranVietHoang.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TranVietHoang.beans.ManufacturerProductCount;
import TranVietHoang.beans.tvhProduct;
import TranVietHoang.conn.TranVietHoangConnection;



public class tvhProductUtil {
	//Đọc danh sách 
	public static List<tvhProduct> queryProduct(Connection conn) throws SQLException{
		String sql = "Select a.productId, a.productName, a.productDetail,a.productPrice,a.categoryLowId,a.manufacturerId,a.productImg,m.manufacturerName from tvhProduct a INNER JOIN tvhManufacturer m ON a.manufacturerId = m.manufacturerId;";
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
			String manufacturerName = rs.getString("manufacturerName");
			tvhProduct product = new tvhProduct();
			product.setProductId(productId);
			product.setProductName(productName);
			product.setProductDetail(productDetail);
			product.setProductPrice(productPrice);
			product.setCategoryLowId(categoryLowId);
			product.setManufacturerId(manufacturerId);
			product.setProductImg(productImg);
			product.setManufacturerName(manufacturerName);
			list.add(product);
		}
		return list;
	}
	public static int getTotalProductsCount(Connection conn) throws SQLException{
	    int count = 0;
	    try {
	    	
	    	String query = "SELECT COUNT(*) FROM tvhProduct";
	    	PreparedStatement pstm = conn.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
	       
	       
			while (rs.next()) {
	            count = rs.getInt(1);
	        }
//			System.out.println(count);
	        // Đóng kết nối
//	        rs.close();
//	        pstm.close();
//	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return count;
	}
	// Trả về sản phẩm theo ma
	public static tvhProduct findProductById(Connection conn, String id) throws SQLException {
        String sql = "SELECT * FROM tvhProduct a INNER JOIN tvhManufacturer m ON a.manufacturerId = m.manufacturerId WHERE productId = ?";
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
					
					int productId = rs.getInt("productId");
					String productName = rs.getString("productName");
					String productDetail = rs.getString("productDetail");
					float productPrice = rs.getFloat("productPrice");
					int categoryLowId = rs.getInt("categoryLowId");
					int manufacturerId = rs.getInt("manufacturerId");
					String productImg = rs.getString("productImg");
					String manufacturerName = rs.getString("manufacturerName");
					
                    return new tvhProduct(productId, productName,productDetail, productPrice,categoryLowId,manufacturerId,productImg,manufacturerName);
                }
            }
        }
        return null; // Trả về null nếu không tìm thấy sản phẩm
    }  
	//so san pham theo nha san xuat
	public static List<ManufacturerProductCount> findProductbyManufacturer(Connection conn) throws SQLException{
		String query = "SELECT m.manufacturerName, COUNT(p.productId) AS totalProducts  FROM tvhManufacturer m INNER JOIN tvhProduct p ON m.manufacturerId = p.manufacturerId GROUP BY m.manufacturerName ";
		PreparedStatement pstm = conn.prepareStatement(query);
		ResultSet rs = pstm.executeQuery();
		List<ManufacturerProductCount> total = new ArrayList<ManufacturerProductCount>();
		while (rs.next()) {
			String manufacturerName = rs.getString("manufacturerName");
            int totalProducts = rs.getInt("totalProducts");
            ManufacturerProductCount manu = new ManufacturerProductCount();
            manu.setManufacturerName(manufacturerName);
            manu.setTotalProducts(totalProducts);
            System.out.println(totalProducts);
            total.add(manu);
        }
		return total;
	}

}
