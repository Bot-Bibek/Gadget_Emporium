package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Order_Product;

public class OrderProductController {
	private Connection con;

	public OrderProductController(Connection con) {
		super();
		this.con = con;
	}

	public void insertOrderedProduct(Order_Product ordProduct) {
		try {
			String query = "insert into ordered_product(name, quantity, price, image, orderid) values(?, ?, ?, ?, ?)";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setString(1, ordProduct.getName());
			psmt.setInt(2, ordProduct.getQuantity());
			psmt.setFloat(3, ordProduct.getPrice());
			psmt.setString(4, ordProduct.getImage());
			psmt.setInt(5, ordProduct.getOrder_Id());

			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Order_Product> getAllOrderedProduct(int oid) {
		List<Order_Product> list = new ArrayList<Order_Product>();
		try {
			String query = "select * from ordered_product where orderid = ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setInt(1, oid);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Order_Product orderProd = new Order_Product();
				orderProd.setName(rs.getString("name"));
				orderProd.setQuantity(rs.getInt("quantity"));
				orderProd.setPrice(rs.getFloat("price"));
				orderProd.setImage(rs.getString("image"));
				orderProd.setOrder_Id(oid);

				list.add(orderProd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
