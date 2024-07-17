package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;	
		this.client = client; 
}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		double sum = 0.0;
		for(OrderItem c : items) {
			sum += c.subtotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + moment + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append(client.getName()+" "+client.getBirthDate()+" - " + client.getEmail()+"\n");
		for(OrderItem c : items) {
			sb.append(c.getProduct().getName() +", Quantity: " + c.getQuantity() + ", Subtotal: " + String.format("%.2f", c.subtotal())+"\n");
		}
		sb.append("Total price: " + String.format("%.2f", total()));
		return sb.toString();
	}
}
