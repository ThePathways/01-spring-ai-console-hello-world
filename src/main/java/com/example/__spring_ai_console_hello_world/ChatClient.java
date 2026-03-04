package com.example.__spring_ai_console_hello_world;

import org.springframework.stereotype.Component;
import java.util.Scanner;

/**
 * ChatClient handles the chat session management, including:
 * - Reading user input from console
 * - Managing conversation flow
 * - Handling exit/quit commands
 */
@Component
public class ChatClient {

    private final ChatService chatService;
    private final Scanner scanner;
    private boolean running;

    public ChatClient(ChatService chatService) {
        this.chatService = chatService;
        this.scanner = new Scanner(System.in);
        this.running = false;
    }

    /**
     * Starts the interactive chat session
     */
    public void start() {
        running = true;
        printWelcome();
        
        while (running) {
            String userInput = readInput();
            
            if (shouldExit(userInput)) {
                exit();
                continue;
            }
            
            if (isEmpty(userInput)) {
                continue;
            }
            
            processMessage(userInput);
        }
        
        scanner.close();
    }

    private void printWelcome() {
        System.out.println("===========================================");
        System.out.println("   Console Chat with GroQ LLM");
        System.out.println("===========================================");
        System.out.println("Type 'exit' or 'quit' to end the chat.");
        System.out.println("===========================================");
        System.out.println();
    }

    private String readInput() {
        System.out.print("You: ");
        return scanner.nextLine();
    }

    private boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private boolean shouldExit(String input) {
        return input != null && 
               (input.toLowerCase().equals("exit") || 
                input.toLowerCase().equals("quit"));
    }

    private void exit() {
        System.out.println("Goodbye!");
        running = false;
    }

    private void processMessage(String userMessage) {
        try {
            System.out.print("AI: ");
            String response = chatService.chat(userMessage);
            System.out.println(response);
            System.out.println();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("Make sure GROQ_API_KEY is set in your environment.");
        }
    }

    /**
     * Send a single message and get response (for programmatic use)
     */
    public String sendMessage(String message) {
        return chatService.chat(message);
    }

    /**
     * Stop the chat session
     */
    public void stop() {
        running = false;
    }
}

