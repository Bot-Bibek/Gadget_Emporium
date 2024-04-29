package Model;



public class User {
	private int User_Id;
	private String Name;
	private String Email;
	private String Password;
	private String Phone_Number;
	private String Gender;
	private String Address;
	private String City;
	private String Postalcode;
	private String Province;

	public User(String Name, String Email, String Password, String Phone_Number, String Gender, String Address, String City, String Postalcode, String Province){
		super();
		this.Name = Name;
		this.Email = Email;
		this.Password = Password;
		this.Phone_Number = Phone_Number;
		this.Gender = Gender;
		this.Address = Address;
		this.City = City;
		this.Postalcode = Postalcode;
		this.Province = Province;
	}

	

	public User(String Name, String Email, String Phone_Number, String Gender, String Address, String City, String Postalcode,
			String Province) {
		super();
		this.Name = Name;
		this.Email = Email;
		this.Phone_Number = Phone_Number;
		this.Gender = Gender;
		this.Address = Address;
		this.City = City;
		this.Postalcode = Postalcode;
		this.Province = Province;
	}

	public User() {
		super();
	}



	public int getUser_Id() {
		return User_Id;
	}

	public void setUser_Id(int User_Id) {
		this.User_Id = User_Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public String getPhone_Number() {
		return Phone_Number;
	}

	public void setPhone_Number(String Phone_Number) {
		this.Phone_Number = Phone_Number;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String Gender) {
		this.Gender = Gender;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String City) {
		this.City = City;
	}

	public String getPostalcode() {
		return Postalcode;
	}

	public void setPostalcode(String Postalcode) {
		this.Postalcode = Postalcode;
	}

	public String getProvince() {
		return Province;
	}

	public void setProvince(String Province) {
		this.Province = Province;
	}

}
