package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Cart;
import StringUtils.StringUtils;

public class CartController {

	private Connection con;

	public CartController(Connection con) {
		super();
		this.con = con;
	}

	//Add to cart method 
	public boolean addToCart(Cart cart) {
		boolean flag = false;
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.INSERT_INTO_CART);
			psmt.setInt(1, cart.getUser_Id());
			psmt.setInt(2, cart.getProduct_Id());
			psmt.setInt(3, cart.getQuantity());

			psmt.executeUpdate();
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	//Get cart by category method.
	public List<Cart> getCartListByUserId(int user_id) {
		List<Cart> list = new ArrayList<Cart>();
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.GET_CATEGORY);
			psmt.setInt(1, user_id);

			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Cart cart = new Cart();
				cart.setCart_Id(rs.getInt("cart_id"));
				cart.setUser_Id(rs.getInt("user_id"));
				cart.setProduct_Id(rs.getInt("product_id"));
				cart.setQuantity(rs.getInt("quantity"));

				list.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	//Get quantity by user and product method.
	public int getQuantity(int user_id, int product_id) {
		int qty = 0;
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.GET_QUANTITY_USER_PRODUCT);
			psmt.setInt(1, user_id);
			psmt.setInt(2, product_id);

			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				qty = rs.getInt("quantity");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qty;
	}

	//Get quantity by id method.
	public int getQuantityById(int cart_id) {
		int qty = 0;
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.GET_QUANTITY);
			psmt.setInt(1, cart_id);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				qty = rs.getInt("quantity");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qty;
	}

	//Update quantity method.
	public void updateQuantity(int cart_id, int qty) {

		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.UPDATE_QUANTITY);
			psmt.setInt(1, qty);
			psmt.setInt(2, cart_id);

			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Remove Product.
	public void removeProduct(int cart_id) {
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.REMOVE_PRODUCT);
			psmt.setInt(1, cart_id);

			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Remove all product method.
	public void removeAllProduct() {
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.REMOVE_ALL_PRODUCT);
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Get by user_id and product_id method.
	public int getIdByUserIdAndProductId(int user_id, int product_id) {
		int cart_id = 0;
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.GETBY_USER_AND_PRODUCT);
			psmt.setInt(1, user_id);
			psmt.setInt(2, product_id);

			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				cart_id = rs.getInt("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart_id;
	}

	//Count by user Id Method
	public int getCartCountByUserId(int user_id) {
		int count = 0;
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.COUNT_BY_USERID);
			psmt.setInt(1, user_id);

			ResultSet rs = psmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	//Get Product Method 
	public int getProductId(int cart_id) {
		int product_id = 0;
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.GET_PRODUCT);
			psmt.setInt(1, cart_id);
			ResultSet rs = psmt.executeQuery();
			rs.next();
			product_id = rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return product_id;
	}

}
