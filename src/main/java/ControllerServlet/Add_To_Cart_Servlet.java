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
import Model.Cart;
import Model.Message;
import Controller.DB_Connection;


/**
 * Servlet implementation class Add_To_Cart_Servlet
 */
@WebServlet("/Add_To_Cart_Servlet")
public class Add_To_Cart_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Add_To_Cart_Servlet() {
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
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		int pid = Integer.parseInt(request.getParameter("pid"));

		CartController cartController = new CartController(DB_Connection.getConnection());
		int qty = cartController.getQuantity(uid, pid);
		HttpSession session = request.getSession();
		Message message = null;

		if (qty == 0) {
			Cart cart = new Cart(uid, pid, qty + 1);
			cartController.addToCart(cart);
			message = new Message("Product is added to cart successfully!", "success", "alert-success");

		} else {
			int cid = cartController.getIdByUserIdAndProductId(uid, pid);
			cartController.updateQuantity(cid, qty + 1);
			message = new Message("Product quantity is increased!", "success", "alert-success");
		}
		// updating quantity of product in database
		ProductController productController = new ProductController(DB_Connection.getConnection());
		productController.updateQuantity(pid, productController.getProductQuantityById(pid) - 1);
		session.setAttribute("message", message);
		response.sendRedirect("viewProduct.jsp?pid=" + pid);
	}
	}


