import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    String question;
    List<String> options;
    int correctOption;

    public QuizQuestion(String question, List<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }
}

public class QuizGame {
    private static int score = 0;
    private static int currentQuesIndex = 0;
    private static List<QuizQuestion> questions;
    private static Timer timer;

    public static void main(String[] args) {
        initializeQuestions();
        startGame();
    }

    private static void initializeQuestions() {
        questions = new ArrayList<>();

        // Add your questions with options and correct answers here
        questions.add(new QuizQuestion("What is the capital of India?",
                List.of("A. Mumbai", "B. Delhi", "C. Gujrat", "D. Nagpur"), 1));
        questions.add(new QuizQuestion("Which programming language is Java derived from?",
                List.of("A. C", "B. C++", "C. Python", "D. Assembly"), 0));
        // Add more questions as needed
    }

    private static void startGame() {
        System.out.println("Welcome to the Quiz Game!");

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                displayResult();
                System.exit(0);
            }
        }, 60000); // Set the timer for 60 seconds (adjust as needed)

        displayQuestion();
    }

    private static void displayQuestion() {
        QuizQuestion currentQuestion = questions.get(currentQuesIndex);

        System.out.println("\n" + currentQuestion.question);
        for (String option : currentQuestion.options) {
            System.out.println(option);
        }

        System.out.print("Your choice (enter A, B, C, or D): ");
        Scanner sc = new Scanner(System.in);
        String userChoice = sc.next().toUpperCase();

        processAnswer(userChoice);
        sc.close();
    }

    private static void processAnswer(String userChoice) {
        QuizQuestion currentQuestion = questions.get(currentQuesIndex);

        if (userChoice.equals(currentQuestion.options.get(currentQuestion.correctOption).substring(0, 1))) {
            System.out.println("Correct!\n");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer was: " +
                    currentQuestion.options.get(currentQuestion.correctOption) + "\n");
        }

        currentQuesIndex++;

        if (currentQuesIndex < questions.size()) {
            displayQuestion();
        } else {
            displayResult();
            timer.cancel();
        }
    }

    private static void displayResult() {
        System.out.println("Quiz Over!");
        System.out.println("Your final score: " + score + " out of " + questions.size());
        System.out.println("Correct Answers: " + score);
        System.out.println("Incorrect Answers: " + (questions.size() - score));
    }
}
