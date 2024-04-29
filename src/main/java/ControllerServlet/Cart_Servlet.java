package ControllerServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.CartController;
import Controller.ProductController;
import Model.Message;
import Controller.DB_Connection;


/**
 * Servlet implementation class Cart_Servlet
 */
@WebServlet("/Cart_Servlet")
public class Cart_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cart_Servlet() {
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
		CartController cartContoller = new CartController(DB_Connection.getConnection());
		ProductController productController = new ProductController(DB_Connection.getConnection());
		int cid = Integer.parseInt(request.getParameter("cid"));
		int opt = Integer.parseInt(request.getParameter("opt"));

		int qty = cartContoller.getQuantityById(cid);
		int pid = cartContoller.getProductId(cid);
		int quantity = productController.getProductQuantityById(pid);

		if (opt == 1) {
			if (quantity > 0) {
				cartContoller.updateQuantity(cid, qty + 1);
				// updating(decreasing) quantity of product in database
				productController.updateQuantity(pid, productController.getProductQuantityById(pid) - 1);
				response.sendRedirect("cart.jsp");

			} else {
				HttpSession session = request.getSession();
				Message message = new Message("Product out of stock!", "error", "alert-danger");
				session.setAttribute("message", message);
				response.sendRedirect("cart.jsp");
			}

		} else if (opt == 2) {
			cartContoller.updateQuantity(cid, qty - 1);

			// updating(increasing) quantity of product in database
			productController.updateQuantity(pid, productController.getProductQuantityById(pid) + 1);
			response.sendRedirect("cart.jsp");

		} else if (opt == 3) {
			cartContoller.removeProduct(cid);
			HttpSession session = request.getSession();
			Message message = new Message("Product removed from cart!", "success", "alert-success");
			session.setAttribute("message", message);

			// updating quantity of product in database
			// adding all the product qty back to database
			productController.updateQuantity(pid, productController.getProductQuantityById(pid) + qty);
			response.sendRedirect("cart.jsp");
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
