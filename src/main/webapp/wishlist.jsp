<%@page import="Model.Message"%>
<%@page import="Model.Product"%>
<%@page import="Controller.ProductController"%>
<%@page import="Model.Wishlist"%>
<%@page import="java.util.List"%>
<%@page errorPage="error_exception.jsp"%>
<%@page import="Model.User"%>
<%@page import="Controller.DB_Connection"%>
<%@page import="Controller.WishlistController"%>

<%
User u1 = (User) session.getAttribute("activeUser");
if (u1 == null) {
	Message message = new Message("You are not logged in! Login first!!", "error", "alert-danger");
	session.setAttribute("message", message);
	response.sendRedirect("login.jsp");
	return;  
}
WishlistController wishListDao = new WishlistController(DB_Connection.getConnection());
List<Wishlist> wlist = wishListDao.getListByUserId(u1.getUser_Id());
ProductController productDao = new ProductController(DB_Connection.getConnection());
%>
<div class="container px-3 py-3">
	<%
	if (wlist == null || wlist.size() == 0) {
	%>
	<div class="container mt-5 mb-5 text-center">
		<img src="Images/wishlist.png" style="max-width: 200px;"
			class="img-fluid">
		<h4 class="mt-3">Empty Wishlist</h4>
		You have no items in your wishlist. Start adding!
	</div>
	<%
	} else {
	%>
	<h4>
		My Wishlist (<%=wlist.size()%>)
	</h4>
	<hr>
	<div class="container">
		<table class="table table-hover">
			<%
			for (Wishlist w : wlist) {
				Product p = productDao.getProductsByProductId(w.getProduct_Id());
			%>
			<tr class="text-center">
				<td><img src="Product_imgs\<%=p.getImages()%>"
					style="width: 50px; height: 50px; width: auto;"></td>
				<td class="text-start"><%=p.getName()%></td>
				<td>&#8377;<%=p.getProductPriceAfterDiscount()%></td>
				<td><a
					href="WishlistServlet?uid=<%=u1.getUser_Id()%>&pid=<%=p.getProduct_Id()%>&op=delete"
					class="btn btn-secondary" role="button">Remove</a></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<%
	}
	%>
</div>
