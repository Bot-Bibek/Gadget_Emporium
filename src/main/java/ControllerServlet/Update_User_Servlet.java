package ControllerServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.UserController;
import Model.Message;
import Model.User;
import Controller.DB_Connection;

/**
 * Servlet implementation class Update_User_Servlet
 */
@WebServlet("/Update_User_Servlet")
public class Update_User_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Update_User_Servlet() {
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

		String op = request.getParameter("operation");
		HttpSession session = request.getSession();
		User oldUser = (User) session.getAttribute("activeUser");
		UserController userContoller = new UserController(DB_Connection.getConnection());

		if (op.trim().equals("changeAddress")) {
			try {
				String Address = request.getParameter("address");
				String City = request.getParameter("city");
				String Postalcode = request.getParameter("pincode");
				String Province = request.getParameter("state");

				User user = new User();
				user.setUser_Id(oldUser.getUser_Id());
				user.setName(oldUser.getName());
				user.setEmail(oldUser.getEmail());
				user.setPassword(oldUser.getPassword());
				user.setPhone_Number(oldUser.getPhone_Number());
				user.setGender(oldUser.getGender());
				user.setAddress(Address);
				user.setCity(City);
				user.setPostalcode(Postalcode);
				user.setProvince(Province);

				userContoller.updateUserAddresss(user);
				session.setAttribute("activeUser", user);
				response.sendRedirect("checkout.jsp");

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (op.trim().equals("updateUser")) {
			try {
				String Name = request.getParameter("name");
				String Email = request.getParameter("email");
				String Phone = request.getParameter("mobile_no");
				String Gender = request.getParameter("gender");
				String Address = request.getParameter("address");
				String City = request.getParameter("city");
				String Postalcode = request.getParameter("pincode");
				String Province = request.getParameter("state");

				User user = new User(Name, Email, Phone, Gender, Address, City, Postalcode,
						Province);
				user.setUser_Id(oldUser.getUser_Id());
				user.setPassword(oldUser.getPassword());

				userContoller.updateUser(user);
				session.setAttribute("activeUser", user);
				Message message = new Message("User information updated successfully!!", "success", "alert-success");
				session.setAttribute("message", message);
				response.sendRedirect("profile.jsp");

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (op.trim().equals("deleteUser")) {
			int uid = Integer.parseInt(request.getParameter("uid"));
			userContoller.deleteUser(uid);
			response.sendRedirect("display_users.jsp");
		}
	}

}
