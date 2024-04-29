package StringUtils;

public class StringUtils {
	//Admin 
	public static final String INSERT_ADMIN = "insert into admin(name, email, password, phone_number) values(?, ?, ?, ?)";
	public static final String GET_ADMIN_PASS_EMAIL = "select * from admin where email = ? and password = ?";
	public static final String GET_ADMIN_DETAILS = "select * from admin";
	public static final String DELETE_ADMIN = "delete from admin where admin_id = ?";
	
	//User
	public static final String INSERT_USER = "insert into user(name, email, password, phone_number, gender, address, city, postal_code, province) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String GET_USER_PASS_EMAIL = "select * from user where email = ? and password = ?";
	public static final String GET_USER_DETAILS = "select * from user";
	public static final String UPDATE_USER_ADDRESS = "update user set address = ?, city = ?, postal_code = ?, province = ? where user_id = ?";
	public static final String UPDATE_PASSWORD = "update user set password = ? where email = ?";
	public static final String UPDATE_USER = "update user set name = ?, email = ?, phone = ?, gender = ?, address = ?, city = ?, postal_code = ?, province = ? where user_id = ?";
	public static final String COUNT_USER = "select count(*) from user";
	public static final String GET_USER_ADDRESS = "select address, city, postal, province from user where user_id = ?";
	public static final String GET_USER_NAME = "select name from user where user_id = ?";
	public static final String GET_USER_EMAIL = "select email from user where user_id = ?";
	public static final String GET_USER_PHONE = "select phone from user where user_id = ?";
	public static final String DELETE_USER = "delete from user where user_id = ?";
	
	//Cart 
	public static final String INSERT_INTO_CART = "insert into cart(user_id, product_id, quantity) values(?,?,?)";
	public static final String GET_CATEGORY = "select * from category where user_id = ?";
	public static final String GET_QUANTITY_USER_PRODUCT = "select * from cart where user_id = ? and product_id = ?";
	public static final String GET_QUANTITY = "select * from cart where cart_id = ?";
	public static final String UPDATE_QUANTITY = "update cart set quantity = ? where cart_id = ?";
	public static final String REMOVE_PRODUCT = "delete from cart where cart_id = ?";
	public static final String REMOVE_ALL_PRODUCT =  "delete from cart";
	public static final String GETBY_USER_AND_PRODUCT = "select * from cart where user_id = ? and product_id = ?";
	public static final String COUNT_BY_USERID = "select count(*) from cart where user_id=?";
	public static final String GET_PRODUCT = "select product_id from cart where cart_id=?";
	
	//Category 
	public static final String SAVE_CATEGORY = "insert into category(name, image) values(?, ?)";
	public static final String GET_ALL_CATEGORY = "select * from category";
	public static final String GET_CATEGORY_BY_ID = "select * from category where category_id = ?";
	public static final String GET_CATEGORY_NAME = "select * from category where category_id = ?";
	public static final String UPDATE_CATEGORY = "update category set name=?, image=? where category_id=?";
	public static final String DELETE_CATEGORY = "delete from category where category_id = ?";
	public static final String CATEGORY_COUNT = "select count(*) from category";
	
}
