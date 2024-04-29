package Model;
public class Order {
	private int Order_id;
	private String status;
	private String paymentType;
	private int user_Id;

	public Order() {
		super();
	}

	public Order(int Order_Id, String status, String paymentType, int user_Id) {
		super();
		this.Order_id = Order_Id;
		this.status = status;
		this.paymentType = paymentType;
		this.user_Id = user_Id;
	}

	public Order(String status, String paymentType, int user_Id) {
		super();
		this.status = status;
		this.paymentType = paymentType;
		this.user_Id = user_Id;
	}

	public int getOrder_Id() {
		return Order_id;
	}

	public void setOrder_Id(int order_id) {
		this.Order_id = order_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

}
