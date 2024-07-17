package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf1.getCalendar().getTime();
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String cliName = sc.nextLine();
		System.out.print("E-mail: ");
		String cliEmail = sc.nextLine();
		System.out.print("Birth date: ");
		String cliBirth = sc.nextLine();
		Date data = sdf2.parse(cliBirth);
		Client client = new Client(cliName, cliEmail, data);
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus orderStatus = OrderStatus.valueOf(sc.next());
		Order order = new Order(date, orderStatus, client);
		System.out.print("How many items to this order: ");
		int n = sc.nextInt();
		sc.nextLine();
		for(int a=1; a <= n; a++){
			System.out.println("Enter #" + a + " item data:");
			System.out.print("Product name: ");
			String prodName = sc.nextLine();
			System.out.print("Product price: ");
			double prodPrice = sc.nextDouble();
			Product product = new Product(prodName, prodPrice);
			System.out.print("Qauntity: ");
			int quantity = sc.nextInt();
			sc.nextLine();
			OrderItem orderItem = new  OrderItem(quantity, prodPrice, product);
			order.addItem(orderItem);
		}
		System.out.println("ORDER SUMMARY:");
		System.out.println(order.toString());
		
		
			
		
		
		
		
		
		sc.close();
	}

}
