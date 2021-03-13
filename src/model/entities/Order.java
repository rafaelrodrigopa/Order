package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.enums.OrderStatus;

public class Order {

	private Date moment;
	private OrderStatus status;
	
	
	private Client client;
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	private List<OrderItem> orderItem = new ArrayList<>();
	

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
	
	public Order() {
		
	}

	public Order(Date moment, OrderStatus status, Client client) {
		super();
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	
	public void addItem(OrderItem item) {
		this.orderItem.add(item);
	}
	public void removeItem(OrderItem item) {
		this.orderItem.remove(item);
	}
	public Double total() {
		double sum = 0;
		
		for(OrderItem item : orderItem) {
			
			sum += item.subTotal();
			
		}
		return sum;
	}
	
}
