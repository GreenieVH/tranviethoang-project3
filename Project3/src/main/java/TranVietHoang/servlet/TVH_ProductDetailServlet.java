package TranVietHoang.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import TranVietHoang.Utils.tvhProductUtil;
import TranVietHoang.beans.tvhProduct;
import TranVietHoang.conn.TranVietHoangConnection;

/**
 * Servlet implementation class TVH_ProductDetailServlet
 */
@WebServlet("/productDetail")
public class TVH_ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TVH_ProductDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		String productid = (String) request.getParameter("productId");
		if(productid == null || productid == "") {
			errorString = "loi";
			request.setAttribute("errorString", errorString);
			return;
		}
		Connection conn = null;
		errorString = null;
		List<tvhProduct> list = null;
		tvhProduct procduct = null;
		try {
			conn = TranVietHoang.conn.TranVietHoangConnection.getMSSQLConnection();
			procduct = tvhProductUtil.findProductById(conn, productid);
			list = tvhProductUtil.queryProduct(conn);
			if(procduct == null) {
				errorString = "Không tìm thấy sản phẩm có mã" + productid;
			}
		} catch(Exception e ) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		if(errorString != null || productid == null) {
			request.setAttribute("errorString", errorString);
			return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("productDetail", procduct);
		request.setAttribute("productList", list);
		RequestDispatcher dispatcher2 = request.getServletContext().getRequestDispatcher("/WEB-INF/views/public/productDetail.jsp");
		dispatcher2.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
