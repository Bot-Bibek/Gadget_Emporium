package ControllerServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.WishlistController;
import Model.Wishlist;
import Controller.DB_Connection;

/**
 * Servlet implementation class Wishlist_Servlet
 */
@WebServlet("/Wishlist_Servlet")
public class Wishlist_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Wishlist_Servlet() {
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

		int user_id = Integer.parseInt(request.getParameter("user_id"));
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		String op = request.getParameter("op");

		WishlistController wishlistController = new WishlistController(DB_Connection.getConnection());
		if (op.trim().equals("add")) {
			Wishlist wishlist = new Wishlist(user_id, product_id);
			wishlistController.addToWishlist(wishlist);
			response.sendRedirect("products.jsp");
		} else if (op.trim().equals("remove")) {
			wishlistController.deleteWishlist(user_id, product_id);
			response.sendRedirect("products.jsp");
		} else if (op.trim().equals("delete")) {
			wishlistController.deleteWishlist(user_id, product_id);
			response.sendRedirect("profile.jsp");
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
