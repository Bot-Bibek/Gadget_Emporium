package ControllerServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.AdminController;
import Model.Admin;
import Model.Message;
import Controller.DB_Connection;

/**
 * Servlet implementation class Admin_Servlet
 */
@WebServlet("/Admin_Servlet")
public class Admin_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Admin_Servlet() {
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

		String operation = request.getParameter("operation");
		AdminController adminController = new AdminController(DB_Connection.getConnection());
		HttpSession session = request.getSession();
		Message message = null;

		if (operation.trim().equals("save")) {

			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone_number");

			Admin admin = new Admin(name, email, phone, password);
			boolean flag = adminController.saveAdmin(admin);

			if (flag) {
				message = new Message("New admin register successfully!", "success", "alert-success");
			} else {
				message = new Message("Sorry! Something went wrong", "error", "alert-danger");
			}

		} else if (operation.trim().equals("delete")) {

			int id = Integer.parseInt(request.getParameter("id"));
			boolean flag = adminController.deleteAdmin(id);
			if (flag) {
				message = new Message("Admin deleted successfully!", "success", "alert-success");
			} else {
				message = new Message("Sorry! Something went wrong", "error", "alert-danger");
			}
		}
		session.setAttribute("message", message);
		response.sendRedirect("display_admin.jsp");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		

	}}

