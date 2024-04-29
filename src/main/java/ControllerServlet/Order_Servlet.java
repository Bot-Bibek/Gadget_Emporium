package ControllerServlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.CartController;
import Controller.OrderContoller;
import Controller.OrderProductController;
import Controller.ProductController;
import Model.Cart;
import Model.Order;
import Model.Order_Product;
import Model.Product;
import Model.User;
import Controller.DB_Connection;
import Controller.OrderID;


/**
 * Servlet implementation class Order_Servlet
 */
@WebServlet("/Order_Servlet")
public class Order_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Order_Servlet() {
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

		HttpSession session = request.getSession();
		String from = (String) session.getAttribute("from");
		String paymentType = request.getParameter("payementMode");
		User user = (User) session.getAttribute("activeUser");
		String orderId = OrderID.getOrderId();
		String status = "Order Placed";

		if (from.trim().equals("cart")) {
			try {

				Order order = new Order(status, paymentType, user.getUser_Id()); //Order_ID Not Fix
				OrderContoller orderContoller = new OrderContoller(DB_Connection.getConnection());
				int id = orderContoller.insertOrder(order);

				CartController cartContoller = new CartController(DB_Connection.getConnection());
				List<Cart> listOfCart = cartContoller.getCartListByUserId(user.getUser_Id());
				OrderProductController orderProductController = new OrderProductController(DB_Connection.getConnection());
				ProductController productController = new ProductController(DB_Connection.getConnection());
				for (Cart item : listOfCart) {

					Product prod = productController.getProductsByProductId(item.getProduct_Id());
					String prodName = prod.getName();
					int prodQty = item.getQuantity();
					float price = prod.getProductPriceAfterDiscount();
					String image = prod.getImages();

					Order_Product orderedProduct = new Order_Product(prodName, prodQty, price, image, id);
					orderProductController.insertOrderedProduct(orderedProduct);
				}
				session.removeAttribute("from");
				session.removeAttribute("totalPrice");

				// removing all product from cart after successful order
				cartContoller.removeAllProduct();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (from.trim().equals("buy")) {

			try {

				int pid = (int) session.getAttribute("pid");
				Order order = new Order(status, paymentType, user.getUser_Id()); //Oreder ID Not Fix
				OrderContoller orderController = new OrderContoller(DB_Connection.getConnection());
				int id = orderController.insertOrder(order);
				OrderProductController orderProductController = new OrderProductController(DB_Connection.getConnection());
				ProductController productController = new ProductController(DB_Connection.getConnection());

				Product prod = productController.getProductsByProductId(pid);
				String prodName = prod.getName();
				int prodQty = 1;
				float price = prod.getProductPriceAfterDiscount();
				String image = prod.getImages();

				Order_Product orderedProduct = new Order_Product(prodName, prodQty, price, image, id);
				orderProductController.insertOrderedProduct(orderedProduct);

				// updating(decreasing) quantity of product in database
				productController.updateQuantity(pid, productController.getProductQuantityById(pid) - 1);

				session.removeAttribute("from");
				session.removeAttribute("pid");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		session.setAttribute("order", "success");
		response.sendRedirect("index.jsp");
	}
}
