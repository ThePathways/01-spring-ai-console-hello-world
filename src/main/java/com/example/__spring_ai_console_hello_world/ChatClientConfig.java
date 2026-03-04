package com.example.__spring_ai_console_hello_world;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class responsible for building the Spring AI ChatClient.
 * This separates the ChatClient creation from ChatService.
 */
@Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient aiChatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder
                .defaultSystem("You are a helpful AI assistant.")
                .build();
    }
}

