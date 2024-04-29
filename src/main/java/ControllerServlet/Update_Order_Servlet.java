package ControllerServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.OrderContoller;
import Controller.UserController;
import Model.Order;
import Controller.DB_Connection;

/**
 * Servlet implementation class Update_Order_Servlet
 */
@WebServlet("/Update_Order_Servlet")
public class Update_Order_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Update_Order_Servlet() {
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
	/**
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		int oid = Integer.parseInt(request.getParameter("oid"));
		String status = request.getParameter("status");
		OrderContoller orderContoller = new OrderContoller(DB_Connection.getConnection());
		orderContoller.updateOrderStatus(oid, status);
		if (status.trim().equals("Shipped") || status.trim().equals("Out For Delivery")) {
			Order order = orderContoller.getOrderById(oid);
			UserController userController = new UserController(DB_Connection.getConnection());
			
		}
		response.sendRedirect("display_orders.jsp");
	}

}
