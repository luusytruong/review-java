package transaction;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main<T> {
	public void print(ArrayList<T> arr) {
		System.out.println("===============print===============");
		for (T prd : arr) {
			System.out.println(prd);
		}
		System.out.println("===================================" + "\n");
	}

	public static void main(String[] args) throws SQLException {
		Main<Product> prd = new Main<>();
		Main<Orders> od = new Main<>();
		Main<OrderDetail> odd = new Main<>();

		TransactionExample example = new TransactionExample();
		System.out.println("before transaction");
		prd.print(example.getProductDao().getAll());
		od.print(example.getOrderDAO().getAll());
		odd.print(example.getDetailDAO().getAll());

		ArrayList<OrderDetail> listProduct = new ArrayList<>();
		listProduct.add(new OrderDetail(0, 1, 7));
		listProduct.add(new OrderDetail(0, 2, 3));
		listProduct.add(new OrderDetail(0, 3, 3));
		listProduct.add(new OrderDetail(0, 4, 3));
		System.out.println("==============process==============");
		example.addOrder(listProduct);
		System.out.println("===================================");

		System.out.println("\n" + "after transaction");
		prd.print(example.getProductDao().getAll());
		od.print(example.getOrderDAO().getAll());
		odd.print(example.getDetailDAO().getAll());
	}
}
