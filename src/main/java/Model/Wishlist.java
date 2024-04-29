package Model;

public class Wishlist {
	private int wishlist_Id;
	private int user_Id;
	private int product_Id;

	public Wishlist() {
		super();
	}

	public Wishlist(int user_Id, int product_Id) {
		super();
		this.user_Id = user_Id;
		this.product_Id = product_Id;
	}

	public int getWishlist_Id() {
		return wishlist_Id;
	}

	public void setWishlist_Id(int wishlist_Id) {
		this.wishlist_Id = wishlist_Id;
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

}
