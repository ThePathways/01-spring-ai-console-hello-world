package com.example.__spring_ai_console_hello_world;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleChatRunner implements CommandLineRunner {

    private final ChatClient chatClient;

    public ConsoleChatRunner(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public void run(String... args) {
        chatClient.start();
    }
}

