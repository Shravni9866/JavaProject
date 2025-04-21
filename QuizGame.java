import java.util.Scanner;

public class QuizGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] questions = {
                "1. What is the capital of France?",
                "2. Who wrote 'Romeo and Juliet'?",
                "3. What is the largest planet in our solar system?",
                "4. What does HTTP stand for?",
                "5. Which language is commonly used for Android app development?",
                "6. What is the boiling point of water in Celsius?",
                "7. Which continent is known as the 'Dark Continent'?",
                "8. What gas do plants absorb from the atmosphere?",
                "9. Who painted the Mona Lisa?",
                "10. What is the smallest prime number?",
                "11. Which country gifted the Statue of Liberty to the USA?",
                "12. What is the hardest natural substance on Earth?",
                "13. Which planet is known as the Red Planet?",
                "14. Who discovered gravity when he saw a falling apple?",
                "15. What is the main ingredient in guacamole?",
                "16. How many players are there in a football (soccer) team on the field?",
                "17. Which ocean is the largest?",
                "18. What is the currency of Japan?",
                "19. What is the name of the longest river in the world?",
                "20. Who was the first person to walk on the moon?"
        };

        String[][] options = {
                {"A. Berlin", "B. Madrid", "C. Paris", "D. Rome"},
                {"A. Charles Dickens", "B. William Shakespeare", "C. Jane Austen", "D. Mark Twain"},
                {"A. Earth", "B. Mars", "C. Jupiter", "D. Saturn"},
                {"A. HyperText Transfer Protocol", "B. HighText Transfer Protocol", "C. HyperText Translate Protocol", "D. Hyper Transfer Text Protocol"},
                {"A. Python", "B. Java", "C. Swift", "D. Ruby"},
                {"A. 90°C", "B. 100°C", "C. 110°C", "D. 120°C"},
                {"A. Asia", "B. Europe", "C. Africa", "D. South America"},
                {"A. Oxygen", "B. Carbon Dioxide", "C. Nitrogen", "D. Hydrogen"},
                {"A. Picasso", "B. Da Vinci", "C. Michelangelo", "D. Van Gogh"},
                {"A. 0", "B. 1", "C. 2", "D. 3"},
                {"A. Germany", "B. France", "C. Italy", "D. Canada"},
                {"A. Gold", "B. Diamond", "C. Iron", "D. Platinum"},
                {"A. Venus", "B. Earth", "C. Mars", "D. Mercury"},
                {"A. Albert Einstein", "B. Galileo", "C. Isaac Newton", "D. Nikola Tesla"},
                {"A. Tomato", "B. Avocado", "C. Onion", "D. Pepper"},
                {"A. 9", "B. 10", "C. 11", "D. 12"},
                {"A. Atlantic", "B. Pacific", "C. Indian", "D. Arctic"},
                {"A. Dollar", "B. Yen", "C. Yuan", "D. Won"},
                {"A. Amazon", "B. Nile", "C. Yangtze", "D. Mississippi"},
                {"A. Yuri Gagarin", "B. Buzz Aldrin", "C. Neil Armstrong", "D. Michael Collins"}
        };

        char[] answers = {
                'C', 'B', 'C', 'A', 'B', 'B', 'C', 'B', 'B', 'C',
                'B', 'B', 'C', 'C', 'B', 'C', 'B', 'B', 'B', 'C'
        };

        int score = 0;

        System.out.println("🎉 Welcome to the Ultimate General Knowledge Quiz! 🎉\n");
        System.out.println("🧠 Let's see how many you can get right out of 20.\n");

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("👉 Your answer (A/B/C/D): ");
            char userAnswer = Character.toUpperCase(scanner.next().charAt(0));

            if (userAnswer == answers[i]) {
                System.out.println("✅ Spot on! Great job!\n");
                score++;
            } else {
                System.out.println("❌ Oops! The correct answer was: " + answers[i] + "\n");
            }

            // Optional: Uncomment to simulate pause
            // try { Thread.sleep(500); } catch (InterruptedException e) { }
        }

        System.out.println("🎯 Quiz Complete!");
        System.out.println("📝 You scored " + score + " out of " + questions.length);

        if (score == 20) {
            System.out.println("🏆 Perfect score! You're a trivia legend!");
        } else if (score >= 15) {
            System.out.println("👏 Excellent! You really know your stuff.");
        } else if (score >= 10) {
            System.out.println("👍 Good try! Keep sharpening that brain.");
        } else {
            System.out.println("📚 You’ve got potential! Time to hit the books 😉");
        }

        System.out.println("\nThanks for playing. Until next time, stay curious! 🌍");

        scanner.close();
    }
}
