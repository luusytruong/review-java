package Transaction;

import java.sql.Date;
import java.text.MessageFormat;

public class Orders {
	private int id;
	private Date orderDate;

	public Orders() {
	}

	public Orders(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Orders(int id, Date orderDate) {
		this.id = id;
		this.orderDate = orderDate;
	}

	public String toString() {
		return MessageFormat.format("id:{0}, order date: {1}", id, orderDate);
	}
}
