package Model;

public class Admin {
	private int Admin_id;
	private String name;
	private String email;
	private String phone_number;
	private String password;

	public Admin() {
		super();
	}

	public Admin(String name, String email, String phone, String password) {
		super();
		this.name = name;
		this.email = email;
		this.phone_number = phone;
		this.password = password;
	}

	public int getAdmin_id() {
		return Admin_id;
	}

	public void setAdmin_Id(int Admin_id) {
		this.Admin_id = Admin_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone_number;
	}

	public void setPhone(String phone) {
		this.phone_number = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
