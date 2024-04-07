package TranVietHoang.servlet.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import TranVietHoang.Utils.tvhCookieUserUtil;
import TranVietHoang.Utils.tvhGetCookieUtil;
import TranVietHoang.Utils.tvhProductUtil;
import TranVietHoang.beans.tvhProduct;

/**
 * Servlet implementation class AD_HomeServlet
 */
@WebServlet("/adhome")
public class AD_HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AD_HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		String errorString = null;
		try {
			conn = TranVietHoang.conn.TranVietHoangConnection.getMSSQLConnection();
			
			String isAdmin = tvhGetCookieUtil.GetUserCookieUser(request);
			if(isAdmin == null || isAdmin == "") {
				 response.sendRedirect("adads"); // Chuyển hướng đến trang error.jsp
			        return;
			} else if (isAdmin.equals("OK")) {
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/admin/adhome.jsp");
				dispatcher.forward(request, response);
				
				
			}
		} catch	(ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
			errorString = e1.getMessage();
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/public/home.jsp");
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
