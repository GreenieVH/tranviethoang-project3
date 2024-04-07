package TranVietHoang.servlet.login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
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

import org.json.JSONObject;

import TranVietHoang.conn.TranVietHoangConnection;

/**
 * Servlet implementation class TVH_LoginServlet
 */
@WebServlet("/login")
public class TVH_LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TVH_LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/gues/_login.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
		Connection conn = null;
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

            String sql = "SELECT userAccount,userName,userPassword,userEmail,isAdmin,isBan FROM tvhUserAccount WHERE userAccount=? AND userPassword=?";
          PreparedStatement statement = conn.prepareStatement(sql);
          statement.setString(1, userAccount);
          statement.setString(2, password);
          ResultSet result = statement.executeQuery();
          
          if (result.next()) {
              // Username and password are correct
              Cookie cookie = new Cookie("userAccount", userAccount);
              cookie.setMaxAge(60 * 60 * 24); // Cookie lives for 24 hours
              response.addCookie(cookie);
              response.setStatus(HttpServletResponse.SC_OK); // Set status code to 200
          } else {
              // Username or password is incorrect
              response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // Set status code to 400
          }
            
            statement.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }

}
