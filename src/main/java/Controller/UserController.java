package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.User;
import StringUtils.StringUtils;

public class UserController {
	private Connection con;

	public UserController(Connection con) {
		super();
		this.con = con;
	}

	//Save user method.
	public boolean saveUser(User user) {
		boolean flag = false;

		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.INSERT_USER);
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getEmail());
			psmt.setString(3, user.getPassword());
			psmt.setString(4, user.getPhone_Number());
			psmt.setString(5, user.getGender());
			psmt.setString(6, user.getAddress());
			psmt.setString(7, user.getCity());
			psmt.setString(8, user.getPostalcode());
			psmt.setString(9, user.getProvince());

			psmt.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	//Get user email and password method
	public User getUserByEmailPassword(String Email, String Password) {
		User user = null;
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.GET_USER_PASS_EMAIL);
			psmt.setString(1, Email);
			psmt.setString(2, Password);

			ResultSet set = psmt.executeQuery();
			while (set.next()) {
				user = new User();

				user.setUser_Id(set.getInt("user_id"));
				user.setName(set.getString("name"));
				user.setEmail(set.getString("email"));
				user.setPassword(set.getString("password"));
				user.setPhone_Number(set.getString("phone"));
				user.setGender(set.getString("gender"));
				user.setAddress(set.getString("address"));
				user.setCity(set.getString("city"));
				user.setPostalcode(set.getString("postalcode"));
				user.setProvince(set.getString("province"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}
	
	//Get User Details Method
	public List<User> getAllUser() {
		List<User> list = new ArrayList<User>();
		try {
			Statement statement = this.con.createStatement();
			ResultSet set = statement.executeQuery(StringUtils.GET_USER_DETAILS);
			while (set.next()) {
				User user = new User();
				user.setUser_Id(set.getInt("user_id"));
				user.setName(set.getString("name"));
				user.setEmail(set.getString("email"));
				user.setPassword(set.getString("password"));
				user.setPhone_Number(set.getString("phone"));
				user.setGender(set.getString("gender"));
				user.setAddress(set.getString("address"));
				user.setCity(set.getString("city"));
				user.setPostalcode(set.getString("postal_code"));
				user.setProvince(set.getString("province"));
				
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//Update user Address method.
	public void updateUserAddresss(User user) {
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.UPDATE_USER_ADDRESS);
			psmt.setString(1, user.getAddress());
			psmt.setString(2, user.getCity());
			psmt.setString(3, user.getPostalcode());
			psmt.setString(4, user.getProvince());
			psmt.setInt(5, user.getUser_Id());

			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Update user password method.
	public void updateUserPassword(String password, String mail) {
		try {
			String query = "update user set password = ? where email = ?";
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.UPDATE_PASSWORD);
			psmt.setString(1, password);
			psmt.setString(2, mail);
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//Update User method
	public void updateUser(User user) {
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.UPDATE_USER);
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getEmail());
			psmt.setString(3, user.getPhone_Number());
			psmt.setString(4, user.getGender());
			psmt.setString(5, user.getAddress());
			psmt.setString(6, user.getCity());
			psmt.setString(7, user.getPostalcode());
			psmt.setString(8, user.getProvince());
			psmt.setInt(9, user.getUser_Id());

			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//User count method.
	public int userCount() {
		int count = 0;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(StringUtils.COUNT_USER);
			rs.next();
			count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	//Get user address method
	public String getUserAddress(int user_id) {
		String address = "";
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.GET_USER_ADDRESS);
			psmt.setInt(1, user_id);

			ResultSet rs = psmt.executeQuery();
			rs.next();
			address = rs.getString(1) + ", " + rs.getString(2) + "-" + rs.getString(3) + ", " + rs.getString(4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return address;
	}
	
	//Get user name method.
	public String getUserName(int User_id) {
		String name = "";
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.GET_USER_NAME);
			psmt.setInt(1, User_id);
			
			ResultSet rs = psmt.executeQuery();
			rs.next();
			name = rs.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}
	
	//Get user email method. 
	public String getUserEmail(int user_id) {
		String email = "";
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.GET_USER_EMAIL);
			psmt.setInt(1, user_id);
			
			ResultSet rs = psmt.executeQuery();
			rs.next();
			email = rs.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return email;
	}
	
	//Get user phone number method.
	public String getUserPhone(int user_id) {
		String phone = "";
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.GET_USER_PHONE);
			psmt.setInt(1, user_id);
			
			ResultSet rs = psmt.executeQuery();
			rs.next();
			phone = rs.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return phone;
	}
	
	//Delete user method.
	public void deleteUser(int user_id) {
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.DELETE_USER);
			psmt.setInt(1, user_id);
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
