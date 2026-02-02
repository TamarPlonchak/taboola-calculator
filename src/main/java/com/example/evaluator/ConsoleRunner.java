package com.example.evaluator;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
public class ConsoleRunner implements CommandLineRunner {

    private final Evaluator evaluator;

    public ConsoleRunner(Evaluator evaluator) {
        this.evaluator = evaluator;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Text-based Calculator. Enter expressions (Ctrl+D or Ctrl+Z to finish):");
        System.out.println();

        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.isEmpty()) {
                    continue;
                }

                try {
                    evaluator.evaluateExpression(line);
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }

            System.out.println();
            System.out.println("Result: " + evaluator.getVariableStore());
        }
    }
    
}
