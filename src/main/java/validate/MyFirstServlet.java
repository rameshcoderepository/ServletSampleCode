package validate;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyFirstServlet")
public class MyFirstServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try (PrintWriter out = response.getWriter();) {

			response.setContentType("text/html");

			String username = request.getParameter("user1");
			String pass = request.getParameter("p1");

			if ("admin".equals(username) && "admin123".equals(pass)) {

				out.println("Welcome MyFirstServlet" + " " + username);

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("AdminHome.jsp");
				requestDispatcher.include(request, response);
			} else {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/maybatch", "root", "admin");
				Statement stmt = con.createStatement();

				ResultSet rs = stmt.executeQuery("select * from userregister");
				System.out.println(rs);
				int flag = 0;
				while (rs.next()) {
					String user = rs.getString("username");
					String password = rs.getString("password");

					if (username.equals(user) && pass.equals(password)) {
						out.println("welcome MyFirstServlet" + " " + username);
						flag = 1;

						RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserHome.jsp");
						requestDispatcher.forward(request, response);

						flag = 1;
					}

				}
				if (flag == 0) {

					out.println("Sorry Username password is incorrect");

					RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
					requestDispatcher.include(request, response);

				}
			}

		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}
}
