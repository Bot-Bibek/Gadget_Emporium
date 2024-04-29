package Model;

public class Order_Product {
	private int OrderItem_Id;
	private String Name;
	private int quantity;
	private float price;
	private String image;
	private int order_Id;

	public Order_Product() {
		super();
	}

	public Order_Product(String Name, int quantity, float price, String image, int orderId) {
		super();
		this.Name = Name;
		this.quantity = quantity;
		this.price = price;
		this.image = image;
		this.order_Id = orderId;
	}

	public int getOrderItem_Id() {
		return OrderItem_Id;
	}

	public void setOrederItem_Id(int orderItem_Id) {
		this.OrderItem_Id = orderItem_Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}

}
