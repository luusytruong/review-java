package transaction;

import java.text.MessageFormat;

public class OrderDetail {
	private int id;
	private int orderId;
	private int productId;
	private int quantity;

	public OrderDetail() {
	}

	public OrderDetail(int orderId, int productId, int quantity) {
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public OrderDetail(int id, int orderId, int productId, int quantity) {
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public String toString() {
		return MessageFormat.format("id: {0}, order id: {1}, product id: {2}, quantity: {3}", id, orderId, productId,
				quantity);
	}

	public int getOrderId() {
		return this.orderId;
	}

	public int getProductID() {
		return this.productId;
	}

	public int getQuantity() {
		return this.quantity;
	}
}
