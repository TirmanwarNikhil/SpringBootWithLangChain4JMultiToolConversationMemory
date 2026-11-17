package com.nikhil.lc4jmultitoolconversationmemory.tools;

import org.springframework.stereotype.Component;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;

@Component
public class PaymentTools {

	@Tool("Check payment status, transaction ID and payment method for an order")
	public String getPaymentStatus(@P("Order ID, for example ORD1001") String orderId) {

		System.out.println("Executing Payment Tool: " + orderId);

		return switch (orderId) {
		case "ORD1001" -> "Payment ID: PAY1001, Order ID: ORD1001, " + "Transaction ID: TXN98765, Amount: 75000, "
				+ "Method: CREDIT_CARD, Status: SUCCESS";
		case "ORD1002" -> "Payment ID: PAY1002, Order ID: ORD1002, " + "Transaction ID: TXN98766, Amount: 25000, "
				+ "Method: UPI, Status: SUCCESS";
		case "ORD1003" -> "Payment ID: PAY1003, Order ID: ORD1003, " + "Transaction ID: TXN98767, Amount: 5000, "
				+ "Method: NET_BANKING, Status: FAILED";
		default -> "No payment information found for order: " + orderId;
		};
	}
}
