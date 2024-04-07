package TranVietHoang.servlet.login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONObject;

import TranVietHoang.Utils.tvhAccountUtil;
import TranVietHoang.beans.tvhAccount;
import TranVietHoang.conn.TranVietHoangConnection;

/**
 * Servlet implementation class TVH_RegisterServlet
 */
@WebServlet("/signup")
public class TVH_RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TVH_RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/gues/_register.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PrintWriter out = response.getWriter();
		
		try {
			conn = TranVietHoangConnection.getMSSQLConnection();
            bufferedReader =  new BufferedReader(new InputStreamReader(request.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            JSONObject jsonObject = new JSONObject(sb.toString());

            String userAccount = jsonObject.getString("userAccount");
            String password = jsonObject.getString("password");
            String nameUser = jsonObject.getString("nameUser");
            String emailUser = jsonObject.getString("emailUser");
            
         // Kiểm tra xem tên người dùng đã tồn tại hay chưa
            stmt = conn.prepareStatement("SELECT userAccount FROM tvhUserAccount WHERE userAccount = ? ");
            stmt.setString(1, userAccount);
            rs = stmt.executeQuery();

            if (rs.next()) {
                // Tên người dùng đã tồn tại
                JSONObject responseJson = new JSONObject();
                responseJson.put("message", "Username đã tồn tại");
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // Set status code to 400
                out.print(responseJson.toString()); 
            }else {

    			try {
    				
                    tvhAccount account = new tvhAccount(0,userAccount,nameUser,password,emailUser,false,false);
                    tvhAccountUtil.Register(conn, account);
                    response.setStatus(HttpServletResponse.SC_OK); // Set status code to 200
				} catch (Exception e) {
					 // Tên người dùng đã tồn tại
	                JSONObject responseJson = new JSONObject();
	                responseJson.put("message", e.getMessage());
	                response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // Set status code to 400
	                out.print(responseJson.toString()); 
				}
            }
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
		    // Đóng kết nối và các tài nguyên
		    try {
		        if (rs != null) rs.close();
		        if (stmt != null) stmt.close();
		        if (conn != null) conn.close();
		        if (out != null) out.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
	}
	}


