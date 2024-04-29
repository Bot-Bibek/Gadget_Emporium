package ControllerServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Message;


/**
 * Servlet implementation class Logout_Servlet
 */
@WebServlet("/Logout_Servlet")
public class Logout_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Logout_Servlet() {
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

		String user = request.getParameter("user");
		HttpSession session = request.getSession();
		if (user.trim().equals("user")) {
			session.removeAttribute("activeUser");
			Message message = new Message("Logout successfully!!", "success", "alert-success");
			session.setAttribute("message", message);
			response.sendRedirect("login.jsp");
		} else if (user.trim().equals("admin")) {
			session.removeAttribute("activeAdmin");
			Message message = new Message("Logout successfully!!", "success", "alert-success");
			session.setAttribute("message", message);
			response.sendRedirect("adminlogin.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
