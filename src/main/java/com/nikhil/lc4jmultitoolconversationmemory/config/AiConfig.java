package com.nikhil.lc4jmultitoolconversationmemory.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nikhil.lc4jmultitoolconversationmemory.assistant.OrderAssistant;
import com.nikhil.lc4jmultitoolconversationmemory.tools.CustomerTools;
import com.nikhil.lc4jmultitoolconversationmemory.tools.OrderTools;
import com.nikhil.lc4jmultitoolconversationmemory.tools.PaymentTools;
import com.nikhil.lc4jmultitoolconversationmemory.tools.ShipmentTools;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;

@Configuration
public class AiConfig {

	@Bean
	public ChatModel chatModel(@Value("${app.ai.openai.api-key}") String apiKey,
			@Value("${app.ai.openai.model-name}") String modelName) {

		return OpenAiChatModel.builder().apiKey(apiKey).modelName(modelName).temperature(0.2).build();
	}

	@Bean
	public OrderAssistant orderAssistant(ChatModel chatModel, OrderTools orderTools, PaymentTools paymentTools,
			CustomerTools customerTools, ShipmentTools shipmentTools) {

		return AiServices.builder(OrderAssistant.class).chatModel(chatModel)

				// Separate conversation memory for each session
				.chatMemoryProvider(memoryId -> MessageWindowChatMemory.builder().id(memoryId).maxMessages(20).build())

				// Register all four tools
				.tools(orderTools, paymentTools, customerTools, shipmentTools).build();
	}
}