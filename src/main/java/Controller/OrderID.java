package Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderID {
	public static String getOrderId() {
		String orderId = "";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		orderId = sdf.format(new Date());
		orderId = "ORD-" + orderId;

		return orderId;
	}

}
