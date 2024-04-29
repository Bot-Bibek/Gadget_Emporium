<%@page import="Controller.WishlistController"%>
<%@page import="Model.User"%>
<%@page import="Controller.CategoryController"%>
<%@page import="Model.Product"%>
<%@page import="java.util.List"%>
<%@page import="Controller.DB_Connection"%>
<%@page import="Controller.ProductController"%>
<%
User u = (User) session.getAttribute("activeUser");
WishlistController wishlistDao = new WishlistController(DB_Connection.getConnection());

String searchKey = request.getParameter("search");
String catId = request.getParameter("category");
CategoryController categoryDao = new CategoryController(DB_Connection.getConnection());
String message = "";

ProductController productDao = new ProductController(DB_Connection.getConnection());
List<Product> prodList = null;
if (searchKey != null) {
	if (!searchKey.isEmpty()) {
		message = "Showing results for \"" + searchKey + "\"";
	}else{
		message = "No product found!";
	}
	prodList = productDao.getAllProductsBySearchKey(searchKey);

} else if (category_Id != null && !(category_Id.trim().equals("0"))) {
	prodList = productDao.getAllProductsByCategoryId(Integer.parseInt(catId.trim()));
	message = "Showing results for \"" + categoryDao.getCategoryName(Integer.parseInt(catId.trim())) + "\"";
} else {
	prodList = productDao.getAllProducts();
	message = "All Products";
}

if (prodList != null && prodList.size() == 0) {

	message = "No items are available for \""
	+ (searchKey != null ? searchKey : categoryDao.getCategoryName(Integer.parseInt(catId.trim()))) + "\"";

	prodList = productDao.getAllProducts();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
<%@include file="Components/common_css_js.jsp"%>
<style>
.real-price {
	font-size: 22px !important;
	font-weight: 600;
}

.product-price {
	font-size: 17px !important;
	text-decoration: line-through;
}

.product-discount {
	font-size: 15px !important;
	color: #027a3e;
}

.wishlist-icon {
	cursor: pointer;
	position: absolute;
	right: 10px;
	top: 10px;
	width: 36px;
	height: 36px;
	border-radius: 50%;
	border: 1px solid #f0f0f0;
	box-shadow: 0 1px 4px 0 rgba(0, 0, 0, .1);
	padding-right: 40px;
	background: #fff;
}
</style>
</head>
<body style="background-color: #f0f0f0;">
	<!--navbar -->
	<%@include file="Components/navbar.jsp"%>

	<!--show products-->
	<h4 class="text-center mt-2"><%=message%></h4>
	<div class="container-fluid my-3 px-5">

		<div class="row row-cols-1 row-cols-md-4 g-3">
			<%
			for (Product p : prodList) {
			%>
			<div class="col">

				<div class="card h-100 px-2 py-2">
					<div class="container text-center">
						<img src="Product_imgs\<%=p.getImages()%>"
							class="card-img-top m-2"
							style="max-width: 100%; max-height: 200px; width: auto;">
						<div class="wishlist-icon">
							<%
							if (u != null) {
								if (wishlistDao.getWishlist(u.getUser_Id(), p.getProduct_Id())) {
							%>
							<button
								onclick="window.open('WishlistServlet?uid=<%=u.getUser_Id()%>&pid=<%=p.getProduct_Id()%>&op=remove', '_self')"
								class="btn btn-link" type="submit">
								<i class="fa-sharp fa-solid fa-heart" style="color: #ff0303;"></i>
							</button>
							<%
							} else {
							%>
							<button type="submit"
								onclick="window.open('WishlistServlet?uid=<%=u.getUser_Id()%>&pid=<%=p.getProduct_Id()%>&op=add', '_self')"
								class="btn btn-link">
								<i class="fa-sharp fa-solid fa-heart" style="color: #909191;"></i>
							</button>
							<%
							}
							} else {
							%>
							<button onclick="window.open('login.jsp', '_self')"
								class="btn btn-link" type="submit">
								<i class="fa-sharp fa-solid fa-heart" style="color: #909191;"></i>
							</button>
							<%
							}
							%>

						</div>
						<h5 class="card-title text-center"><%=p.getName()%></h5>

						<div class="container text-center">
							<span class="real-price">&#8377;<%=p.getProductPriceAfterDiscount()%></span>&ensp;
							<span class="product-price">&#8377;<%=p.getPrice()%></span>&ensp;
							<span class="product-discount"><%=p.getDiscount()%>&#37;off</span>
						</div>
						<div class="container text-center mb-2 mt-2">
							<button type="button"
								onclick="window.open('viewProduct.jsp?pid=<%=p.getProduct_Id()%>', '_self')"
								class="btn btn-primary text-white">View Details</button>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>
	</div>
</body>
</html>

