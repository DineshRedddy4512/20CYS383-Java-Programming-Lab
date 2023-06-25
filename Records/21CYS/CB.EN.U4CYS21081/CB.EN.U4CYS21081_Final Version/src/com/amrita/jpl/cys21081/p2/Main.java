package com.amrita.jpl.cys21081.p2;

        import java.util.Random;

/**
 * This class represents the main class for the quiz game.
 * @author Dinesh Reddy
 */
public class Main {
    private static String[] questions = {
            "What is the capital of India?",
            "Who is the color of the Sky?",
            "Who is the First Pan India Superstar?",
            "What is the topmost university in Tamil Nadu?"
    };
    private static String[] answers = {
            "New Delhi",
            "Blue",
            "Prabhas",
            "Amrita Vishwa Vidyapeetam"
    };

    /**
     * The main method that starts the quiz game.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        System.out.println("Game started!");

        askQuestion();
    }

    /**
     * Selects a random question from the predefined questions array and displays it.
     * Then evaluates the given answer.
     */
    private static void askQuestion() {
        Random random = new Random();
        int index = random.nextInt(questions.length);

        String question = questions[index];
        System.out.println("Question: " + question);
        evaluateAnswer("New Delhi");
    }

    /**
     * Evaluates the given answer by comparing it with the predefined answers array.
     *
     * @param answer The answer provided by the player.
     */
    private static void evaluateAnswer(String answer) {
        int index = -1;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].equalsIgnoreCase(answer)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.println("Correct answer!");
        } else {
            System.out.println("Wrong answer!");
        }
    }
}

