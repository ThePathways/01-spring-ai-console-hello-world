# Spring AI Console Hello World

A console-based chat application built with Spring AI that connects to GroQ's LLM API. This project demonstrates how to create an interactive command-line chat interface using Spring Boot and Spring AI.

## Overview

This application provides a simple yet functional console-based chat interface that communicates with Large Language Models (LLMs) via GroQ's OpenAI-compatible API. It's designed as a starter project for understanding Spring AI fundamentals.

## Features

- Interactive console-based chat interface
- GroQ API integration (OpenAI-compatible)
- Uses Llama 3.3 70B Versatile model
- Configurable temperature settings
- Simple command-based session management (exit/quit)
- Clean architecture with separation of concerns

## Prerequisites

- Java 21 or higher
- Maven 3.6+
- GroQ API Key

## Technology Stack

| Component | Version |
|-----------|---------|
| Spring Boot | 4.0.3 |
| Spring AI | 2.0.0-M2 |
| Java | 21 |
| LLM Model | Llama-3.3-70b-versatile |

## Setup

### 1. Clone and Navigate

```bash
cd 01-spring-ai-console-hello-world
```

### 2. Set GroQ API Key

You need to set your GroQ API key as an environment variable:

**macOS/Linux:**
```bash
export GROQ_API_KEY=your_api_key_here
```

**Windows (Command Prompt):**
```cmd
set GROQ_API_KEY=your_api_key_here
```

**Windows (PowerShell):**
```powershell
$env:GROQ_API_KEY="your_api_key_here"
```

> **Note**: You can get a free API key from [GroQ Console](https://console.groq.com/)

### 3. Build the Project

```bash
./mvnw clean package -DskipTests
```

### 4. Run the Application

```bash
./mvnw spring-boot:run
```

Or run the compiled JAR:

```bash
java -jar target/01-spring-ai-console-hello-world-0.0.1-SNAPSHOT.jar
```

## Usage

Once the application starts, you'll see:

```
===========================================
   Console Chat with GroQ LLM
===========================================
Type 'exit' or 'quit' to end the chat.
===========================================
```

Type your messages and press Enter to chat with the AI. Type `exit` or `quit` to end the session.

```
You: Hello, how are you?
AI: Hello! I'm doing well, thank you for asking. How can I help you today?

You: What is Spring AI?
AI: Spring AI is an AI framework that provides a unified API for interacting with various AI providers...

You: exit
Goodbye!
```

## Configuration

Configuration is managed in `src/main/resources/application.properties`:

```properties
spring.application.name=01-spring-ai-console-hello-world

# GroQ Configuration (using OpenAI-compatible API)
spring.ai.openai.api-key=${GROQ_API_KEY}
spring.ai.openai.base-url=https://api.groq.com/openai
spring.ai.openai.chat.options.model=llama-3.3-70b-versatile
spring.ai.openai.chat.options.temperature=0.7
```

### Configuration Options

| Property | Description | Default |
|----------|-------------|---------|
| `spring.ai.openai.api-key` | GroQ API Key | (required) |
| `spring.ai.openai.base-url` | API Base URL | https://api.groq.com/openai |
| `spring.ai.openai.chat.options.model` | LLM Model | llama-3.3-70b-versatile |
| `spring.ai.openai.chat.options.temperature` | Response creativity (0-1) | 0.7 |

## Project Structure

```
src/main/java/com/example/__spring_ai_console_hello_world/
├── Application.java          # Main Spring Boot entry point
├── ChatClient.java           # Console I/O and session management
├── ChatClientConfig.java     # Spring AI ChatClient bean configuration
├── ChatService.java          # Chat business logic service
└── ConsoleChatRunner.java    # Application startup runner
```

### Component Descriptions

| File | Responsibility |
|------|----------------|
| `Application.java` | Spring Boot application bootstrap |
| `ChatClientConfig.java` | Creates and configures the Spring AI ChatClient bean |
| `ChatService.java` | Service layer that wraps ChatClient for business logic |
| `ChatClient.java` | Handles user input/output and chat session flow |
| `ConsoleChatRunner.java` | Initiates the chat session on application startup |

## Architecture

```
┌─────────────────────────────────────────────┐
│           ConsoleChatRunner                 │
│         (CommandLineRunner)                 │
└─────────────────┬───────────────────────────┘
                  │
                  ▼
┌─────────────────────────────────────────────┐
│              ChatClient                      │
│       (Session Management)                  │
│  - User Input/Output                        │
│  - Session Control                          │
└─────────────────┬───────────────────────────┘
                  │
                  ▼
┌─────────────────────────────────────────────┐
│              ChatService                     │
│         (Business Logic)                    │
└─────────────────┬───────────────────────────┘
                  │
                  ▼
┌─────────────────────────────────────────────┐
│         ChatClient (Spring AI)              │
│      (LLM Communication)                    │
└─────────────────┬───────────────────────────┘
                  │
                  ▼
┌─────────────────────────────────────────────┐
│              GroQ API                        │
│         (Llama 3.3 70B)                     │
└─────────────────────────────────────────────┘
```

## Troubleshooting

### API Key Not Set
```
Error: Make sure GROQ_API_KEY is set in your environment.
```
**Solution**: Ensure the `GROQ_API_KEY` environment variable is set correctly.

### Connection Issues
```
Error: Connection refused or timeout
```
**Solution**: Check your internet connection and verify the GroQ API base URL.

### Model Not Available
```
Error: Model not found
```
**Solution**: Verify the model name in `application.properties` matches available GroQ models.

## Dependencies

- `spring-boot-starter-webmvc` - Web framework
- `spring-ai-starter-model-openai` - Spring AI OpenAI support
- `lombok` - Boilerplate code reduction

## License

This project is for educational purposes.

## References

- [Spring AI Documentation](https://docs.spring.io/spring-ai/)
- [GroQ Console](https://console.groq.com/)
- [GroQ API Documentation](https://docs.groq.com/)

