package com.nikhil.lc4jmultitoolconversationmemory.tools;

import org.springframework.stereotype.Component;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;

@Component
public class ShipmentTools {

	@Tool("Track shipment status, courier name and expected delivery date using order ID")
	public String trackShipment(@P("Order ID, for example ORD1001") String orderId) {

		System.out.println("Executing Shipment Tool: " + orderId);

		return switch (orderId) {
		case "ORD1001" -> "Shipment ID: SHIP1001, Order ID: ORD1001, " + "Courier: BlueDart, Tracking Number: BD12345, "
				+ "Status: IN_TRANSIT, Expected Delivery: 2026-11-20";
		case "ORD1002" -> "Shipment not created yet for order ORD1002";
		case "ORD1003" -> "Shipment ID: SHIP1003, Order ID: ORD1003, "
				+ "Courier: Delhivery, Tracking Number: DL98765, " + "Status: DELIVERED, Delivery Date: 2026-11-15";
		default -> "No shipment found for order: " + orderId;
		};
	}
}
