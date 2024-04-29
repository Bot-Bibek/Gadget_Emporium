package Model;

public class Cart {
	private int cart_Id;
	private int user_Id;
	private int product_Id;
	private int quantity;

	public Cart() {
		super();
	}

	public Cart(int user_Id, int product_Id, int quantity) {
		super();
		this.user_Id = user_Id;
		this.product_Id = product_Id;
		this.quantity = quantity;
	}

	public int getCart_Id() {
		return cart_Id;
	}

	public void setCart_Id(int cart_Id) {
		this.cart_Id = cart_Id;
	}

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public int getProduct_Id() {
		return product_Id;
	}

	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
