package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Category;
import StringUtils.StringUtils;

public class CategoryController {
	private Connection con;

	public CategoryController(Connection con) {
		super();
		this.con = con;
	}

	//Save Category Method
	public boolean saveCategory(Category category) {
		boolean flag = false;

		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.SAVE_CATEGORY);
			psmt.setString(1, category.getName());
			psmt.setString(2, category.getImage());

			psmt.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	//Get Category method
	public List<Category> getAllCategories() {

		List<Category> list = new ArrayList<>();
		try {
			Statement statement = this.con.createStatement();

			ResultSet rs = statement.executeQuery(StringUtils.GET_ALL_CATEGORY);
			while (rs.next()) {
				Category category = new Category();
				category.setCategory_Id(rs.getInt("category_id"));
				category.setName(rs.getString("name"));
				category.setImage(rs.getString("image"));

				list.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	//Get Category by ID method
	public Category getCategoryById(int cid) {
		Category category = new Category();
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.GET_CATEGORY_BY_ID);
			psmt.setInt(1, cid);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				category.setCategory_Id(rs.getInt("cid"));
				category.setName(rs.getString("name"));
				category.setImage(rs.getString("image"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

	//Get category name Method 
	public String getCategoryName(int category_Id) {
		String category = "";
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.GET_CATEGORY_NAME);
			psmt.setInt(1, category_Id);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				category = rs.getString("name");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

	//Update category Method
	public void updateCategory(Category cat) {
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.UPDATE_CATEGORY);
			psmt.setString(1, cat.getName());
			psmt.setString(2, cat.getImage());
			psmt.setInt(3, cat.getCategory_Id());

			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Delete Category Method.
	public void deleteCategory(int cid) {
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.DELETE_CATEGORY);
			psmt.setInt(1, cid);

			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Category count method.
	public int categoryCount() {
		int count = 0;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(StringUtils.CATEGORY_COUNT);
			rs.next();
			count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
