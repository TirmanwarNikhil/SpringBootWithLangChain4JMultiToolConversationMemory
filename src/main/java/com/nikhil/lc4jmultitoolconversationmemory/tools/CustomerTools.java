package com.nikhil.lc4jmultitoolconversationmemory.tools;

import org.springframework.stereotype.Component;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;

@Component
public class CustomerTools {

	@Tool("Get customer profile information using customer ID")
	public String getCustomerDetails(@P("Customer ID, for example CUST001") String customerId) {

		System.out.println("Executing Customer Tool: " + customerId);

		return switch (customerId) {
		case "CUST001" -> "Customer ID: CUST001, Name: Rahul Sharma, " + "Email: rahul@example.com, City: Pune";
		case "CUST002" -> "Customer ID: CUST002, Name: Priya Patil, " + "Email: priya@example.com, City: Mumbai";
		case "CUST003" -> "Customer ID: CUST003, Name: Amit Verma, " + "Email: amit@example.com, City: Bangalore";
		default -> "No customer found for ID: " + customerId;
		};
	}
}
