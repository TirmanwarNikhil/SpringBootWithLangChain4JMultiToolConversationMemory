package com.nikhil.lc4jmultitoolconversationmemory.tools;

import org.springframework.stereotype.Component;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;

@Component
public class OrderTools {

	@Tool("Get order status and basic order information using order ID")
	public String getOrderStatus(@P("Unique order ID, for example ORD1001") String orderId) {

		System.out.println("Executing Order Tool: " + orderId);

		return switch (orderId) {
		case "ORD1001" ->
			"Order ID: ORD1001, Customer ID: CUST001, " + "Product: Laptop, Amount: 75000, Status: CONFIRMED";
		case "ORD1002" ->
			"Order ID: ORD1002, Customer ID: CUST002, " + "Product: Mobile Phone, Amount: 25000, Status: PROCESSING";
		case "ORD1003" ->
			"Order ID: ORD1003, Customer ID: CUST003, " + "Product: Headphones, Amount: 5000, Status: SHIPPED";
		default -> "No order found for ID: " + orderId;
		};
	}
}