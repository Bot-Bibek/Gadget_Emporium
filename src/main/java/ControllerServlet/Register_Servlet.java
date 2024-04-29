package ControllerServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.UserController;
import Model.Message;
import Model.User;
import Controller.DB_Connection;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register_Servlet
 */
@WebServlet("/Register_Servlet")
public class Register_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register_Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		try {
			String Name = request.getParameter("name");
			String Email = request.getParameter("email");
			String Password = request.getParameter("password");
			String Phone_Number = request.getParameter("Phone");
			String Gender = request.getParameter("gender");
			String Address = request.getParameter("address");
			String City = request.getParameter("city");
			String Postal_code = request.getParameter("postalcode");
			String Province = request.getParameter("province");

			User user = new User(Name, Email, Password, Phone_Number, Gender, Address, City, Postal_code, Province);
			UserController userContoller = new UserController(DB_Connection.getConnection());
			boolean flag = userContoller.saveUser(user);

			HttpSession session = request.getSession();
			Message message;
			if (flag) {
				message = new Message("Registration Successful !!", "success", "alert-success");
			} else {
				message = new Message("Something went wrong! Try again!!", "error", "alert-danger");
			}
			session.setAttribute("message", message);
			response.sendRedirect("register.jsp");
			return;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
