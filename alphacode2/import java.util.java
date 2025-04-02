import java.util.HashMap;
import java.util.Scanner;

public class AIChatbot {
    private HashMap<String, String> responses;

    public AIChatbot() {
        responses = new HashMap<>();
        trainModel();
    }

    private void trainModel() {
        // Training with sample intents and responses
        responses.put("hello", "Hi there! How can I help you today?");
        responses.put("how are you", "I'm just a program, but I'm here to assist you!");
        responses.put("bye", "Goodbye! Have a great day!");
        responses.put("default", "Sorry, I didn't understand that. Can you rephrase?");
    }

    public String getResponse(String userInput) {
        // Simplified intent recognition
        String intent = userInput.toLowerCase();
        return responses.getOrDefault(intent, responses.get("default"));
    }

    public static void main(String[] args) {
        AIChatbot chatbot = new AIChatbot();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Chatbot: Hello! Type your message:");
        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println("Chatbot: " + chatbot.getResponse(userInput));
                break;
            }
            System.out.println("Chatbot: " + chatbot.getResponse(userInput));
        }
        scanner.close();
    }
}
