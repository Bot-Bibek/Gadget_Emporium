package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Admin;
import StringUtils.StringUtils;
public class AdminController {
	private Connection con;

	public AdminController(Connection con) {
		super();
		this.con = con;
	}

	public boolean saveAdmin(Admin admin) {
		boolean flag = false;

		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.INSERT_ADMIN);
			psmt.setString(1, admin.getName());
			psmt.setString(2, admin.getEmail());
			psmt.setString(3, admin.getPassword());
			psmt.setString(4, admin.getPhone());

			psmt.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public Admin getAdminByEmailPassword(String email, String password) {
		Admin admin = null;
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.GET_ADMIN_PASS_EMAIL);
			psmt.setString(1, email);
			psmt.setString(2, password);

			ResultSet set = psmt.executeQuery();
			while (set.next()) {
				admin = new Admin();
				admin.setAdmin_Id(set.getInt("admin_id"));
				admin.setName(set.getString("name"));
				admin.setEmail(set.getString("email"));
				admin.setPassword(set.getString("password"));
				admin.setPhone(set.getString("phone_Number"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

	public List<Admin> getAllAdmin() {
		List<Admin> list = new ArrayList<Admin>();
		try {
			Statement statement = this.con.createStatement();
			ResultSet rs = statement.executeQuery(StringUtils.GET_ADMIN_DETAILS);
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAdmin_Id(rs.getInt("admin_id"));
				admin.setName(rs.getString("name"));
				admin.setEmail(rs.getString("email"));
				admin.setPhone(rs.getString("phone_Number"));
				admin.setPassword(rs.getString("password"));

				list.add(admin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteAdmin(int id) {
		boolean flag = false;
		try {
			PreparedStatement psmt = this.con.prepareStatement(StringUtils.DELETE_ADMIN);
			psmt.setInt(1, id);
			psmt.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
