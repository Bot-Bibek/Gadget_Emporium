package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Product;

public class ProductController {
	private Connection con;

	public ProductController(Connection con) {
		super();
		this.con = con;
	}

	public boolean saveProduct(Product product) {
		boolean flag = false;
		try {
			String query = "insert into product(name, description, price, quantity, discount, image, category_id) values(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setString(1, product.getName());
			psmt.setString(2, product.getDescription());
			psmt.setFloat(3, product.getPrice());
			psmt.setInt(4, product.getQunatity());
			psmt.setInt(5, product.getDiscount());
			psmt.setString(6, product.getImages());
			psmt.setInt(7, product.getCategory_Id());

			psmt.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public List<Product> getAllProducts() {
		List<Product> list = new ArrayList<Product>();
		try {
			String query = "select * from product";
			Statement statement = this.con.createStatement();

			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Product product = new Product();
				product.setProduct_Id(rs.getInt("product_id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setQunatity(rs.getInt("quantity"));
				product.setDiscount(rs.getInt("discount"));
				product.setImages(rs.getString("image"));
				product.setCategory_Id(rs.getInt("category_id"));

				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Product> getAllLatestProducts() {
		List<Product> list = new ArrayList<Product>();
		try {
			String query = "select * from product order by product_id desc";
			Statement statement = this.con.createStatement();

			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Product product = new Product();
				product.setProduct_Id(rs.getInt("product_id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setQunatity(rs.getInt("quantity"));
				product.setDiscount(rs.getInt("discount"));
				product.setImages(rs.getString("image"));
				product.setCategory_Id(rs.getInt("category_id"));

				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Product getProductsByProductId(int product_id) {
		Product product = new Product();
		try {
			String query = "select * from product where product_id = ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setInt(1, product_id);
			ResultSet rs = psmt.executeQuery();
			rs.next();

			product.setProduct_Id(rs.getInt("product_id"));
			product.setName(rs.getString("name"));
			product.setDescription(rs.getString("description"));
			product.setPrice(rs.getFloat("price"));
			product.setQunatity(rs.getInt("quantity"));
			product.setDiscount(rs.getInt("discount"));
			product.setImages(rs.getString("image"));
			product.setCategory_Id(rs.getInt("category_id"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	public List<Product> getAllProductsByCategoryId(int category_Id) {
		List<Product> list = new ArrayList<Product>();
		try {
			String query = "select * from product where category_id = ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setInt(1, category_Id);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setProduct_Id(rs.getInt("product_id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setQunatity(rs.getInt("quantity"));
				product.setDiscount(rs.getInt("discount"));
				product.setImages(rs.getString("image"));
				product.setCategory_Id(rs.getInt("category_id"));

				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Product> getAllProductsBySearchKey(String search) {
		List<Product> list = new ArrayList<Product>();
		try {
			String query = "select * from product where lower(name) like ? or lower(description) like ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			search = "%" + search + "%";
			psmt.setString(1, search);
			psmt.setString(2, search);

			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setProduct_Id(rs.getInt("product_id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setQunatity(rs.getInt("quantity"));
				product.setDiscount(rs.getInt("discount"));
				product.setImages(rs.getString("image"));
				product.setCategory_Id(rs.getInt("category_id"));

				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Product> getDiscountedProducts() {
		List<Product> list = new ArrayList<Product>();
		try {
			String query = "select * from product where discount >= 30 order by discount desc";
			Statement statement = this.con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Product product = new Product();
				product.setProduct_Id(rs.getInt("product_id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setQunatity(rs.getInt("quantity"));
				product.setDiscount(rs.getInt("discount"));
				product.setImages(rs.getString("image"));
				product.setCategory_Id(rs.getInt("category_id"));

				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void updateProduct(Product product) {
		try {

			String query = "update product set name=?, description=?, price=?, quantity=?, discount=?, image=? where product_id=?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setString(1, product.getName());
			psmt.setString(2, product.getDescription());
			psmt.setFloat(3, product.getPrice());
			psmt.setInt(4, product.getQunatity());
			psmt.setInt(5, product.getDiscount());
			psmt.setString(6, product.getImages());
			psmt.setInt(7, product.getProduct_Id());

			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateQuantity(int id, int qty) {
		try {
			String query = "update product set quantity = ? where product_id = ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setInt(1, qty);
			psmt.setInt(2, id);

			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteProduct(int product_id) {
		try {
			String query = "delete from product where product_id = ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setInt(1, product_id);
			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int productCount() {
		int count = 0;
		try {
			String query = "select count(*) from product";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public float getProductPriceById(int product_id) {
		float price = 0;
		try {
			String query = "select price, discount from product where product_id = ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setInt(1, product_id);
			ResultSet rs = psmt.executeQuery();
			rs.next();
			float orgPrice = rs.getInt(1);
			int discount = rs.getInt(2);

			float discountPrice = (int) ((discount / 100.0) * orgPrice);
			price = orgPrice - discountPrice;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return price;
	}
	public int getProductQuantityById(int product_id) {
		int qty = 0;
		try {
			String query = "select quantity from product where product_id = ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setInt(1, product_id);
			ResultSet rs = psmt.executeQuery();
			rs.next();
			qty = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qty;
	}

}
