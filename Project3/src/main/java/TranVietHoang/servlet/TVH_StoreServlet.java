package TranVietHoang.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TranVietHoang.Utils.tvhProductUtil;
import TranVietHoang.beans.ManufacturerProductCount;
import TranVietHoang.beans.tvhProduct;

/**
 * Servlet implementation class TVH_StoreServlet
 */
@WebServlet("/store")
public class TVH_StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TVH_StoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		String errorString = null;
		List<tvhProduct> list = null;
		List<ManufacturerProductCount> productCounts = null;
		try {
			conn = TranVietHoang.conn.TranVietHoangConnection.getMSSQLConnection();
			
			try {
				list = tvhProductUtil.queryProduct(conn);
				productCounts = tvhProductUtil.findProductbyManufacturer(conn);
				
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
			int totalProducts = tvhProductUtil.getTotalProductsCount(conn);
			int productsPerPage = 2;
			int totalPages = (int) Math.ceil((double) totalProducts / productsPerPage);
			String pageParam = request.getParameter("page");
			int currentPage = (pageParam != null) ? Integer.parseInt(pageParam) : 1;
			int offset = (currentPage - 1) * productsPerPage;

			request.setAttribute("errorString", errorString);
			request.setAttribute("productList", list);
			request.setAttribute("totalPages", totalPages);
		    request.setAttribute("currentPage", currentPage);
		    request.setAttribute("productCounts", productCounts);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/public/productStore.jsp");
			dispatcher.forward(request, response);
		} catch	(ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
			errorString = e1.getMessage();
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/public/productStore.jsp");
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
