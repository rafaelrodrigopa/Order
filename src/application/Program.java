package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.enums.OrderStatus;

public class Program {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data: ");
		
		System.out.print("Name: ");
		String nameClient = sc.nextLine();
		
		System.out.print("Email: ");
		String emailClient = sc.nextLine();
		
		System.out.print("Birth date (DD/MM/YYYY)");
		String dateBirthClient = sc.nextLine();
		
		Order order = new Order(new Date(), OrderStatus.PROCESSING, new Client(nameClient, emailClient, sdf.parse(dateBirthClient)));
				
		System.out.println("Status: " + order.getStatus());
		
		System.out.println("How many item to this order?");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data: ");
			
			System.out.print("Product name: ");
			String productName = sc.next();
			
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			
			
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, new Product(productName, productPrice));
			order.addItem(orderItem);
		}
		
		
		System.out.println("ORDER SUMARY: ");
		
		System.out.println("Order moment: " + order.getMoment());
		System.out.println("Order status: " + order.getStatus());
		System.out.println("Client: " + order.getClient().getName() + "( " + order.getClient().getBirthDate() + " ) - " + order.getClient().getEmail());
		System.out.println();
		System.out.println("Order Items: ");
		
		
		for(OrderItem o : order.getOrderItem()) {
			
			System.out.println(o.lookProduct());
		}
		
	}
}
