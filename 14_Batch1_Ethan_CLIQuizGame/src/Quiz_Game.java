import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class QuizQuestion {
    public String question;
    public String[] options;
    public String correctAnswer;

    public QuizQuestion(String question, String[] options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
class Player{
    private String name;
    private int score;
    private int num_wrong_answers;
    private int num_correct_answers;
    public Player(String name){
        this.name=name;
        this.score=0;
        this.num_wrong_answers =0;
        this.num_correct_answers =0;
    }
    public int getScore(){
        return score;
    }
    public String getName(){
        return name;
    }
    public int getNumWrongAnswers() {
        return num_wrong_answers;
    }
    public int getNumCorrectAnswers() {
        return num_correct_answers;
    }
    public void IncrementScore(){
        this.score++;
    }
    public void IncrementNumOfCorrectAnswers(){
        this.num_correct_answers++;
    }
    public void IncrementNumOfWrongAnswers(){
        this.num_wrong_answers++;
    }
    public void ResetNumCorrectAnswers(){
        this.num_wrong_answers=0;
    }
    public void ResetNumWrongAnswers(){
        this.num_wrong_answers=0;
    }
    public void ResetScore(){
        this.score=0;
    }
}
public class Quiz_Game {
    public static void main(String[] args) {
        List<QuizQuestion> quizQuestions = loadQuestionsFromCSV("src/Quiz_Questions.csv");
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to my quiz game!\nPlayer 1,What's your name:");
        String p1_name = s.next();
        Player p1 = new Player(p1_name);
        System.out.println("\nPlayer 2,What's your name:");
        String p2_name = s.next();
        Player p2 = new Player(p2_name);
        System.out.println("Hello there " + p1_name + " and " + p2_name + "!");
        while (true) {
            for (int i = 0; i < quizQuestions.size(); i++) {
                Player currentPlayer = (i % 2 == 0) ? p1 : p2;
                QuizQuestion current_question = quizQuestions.get(i);
                System.out.println("\n" + currentPlayer.getName() + "'s turn");
                System.out.println("\nQuestion " + (i + 1) + " : " + current_question.getQuestion());
                System.out.println("Your Options are:");
                for (int j = 0; j < current_question.getOptions().length; j++) {
                    System.out.println((char) ('a' + j) + ") " + current_question.getOptions()[j]);
                }
                System.out.println("Choose your Answer:");
                String usersAnswer = s.next().toLowerCase();

                if (usersAnswer.equals(current_question.getCorrectAnswer())) {
                    currentPlayer.IncrementScore();
                    currentPlayer.IncrementNumOfCorrectAnswers();
                    System.out.println("Correct answer!");
                } else {
                    currentPlayer.IncrementNumOfWrongAnswers();
                    System.out.println("Sorry! The correct answer is: " + current_question.getCorrectAnswer());
                }
            }

            System.out.println("Results:");
            System.out.println("---------");
            System.out.println(p1.getName() + ": " + p1.getScore() + " points");
            System.out.println("The number of correct answers: " + p1.getNumCorrectAnswers());
            System.out.println("The number of wrong answers: " + p1.getNumWrongAnswers());

            System.out.println(p2.getName() + ": " + p2.getScore() + " points");
            System.out.println("The number of correct answers: " + p2.getNumCorrectAnswers());
            System.out.println("The number of wrong answers: " + p2.getNumWrongAnswers());

            if (p1.getScore() > p2.getScore()) {
                System.out.println(p1.getName() + "is the winner!");
            } else if (p1.getScore() == p2.getScore()) {
                System.out.println("It's a tie!");
            } else {
                System.out.println(p2.getName() + " is the winner!");
            }
            System.out.println("Do you want to play again?");
            String choice = s.next().toLowerCase();
            if (choice.equals("no") || choice.equals("n")) {
                System.out.println("Thanks for playing!");
                break;
            }
            else {
                p1.ResetNumCorrectAnswers();
                p1.ResetNumWrongAnswers();
                p2.ResetNumCorrectAnswers();
                p2.ResetNumWrongAnswers();
                p1.ResetScore();
                p2.ResetScore();
            }

        }
        s.close();
    }
    private static List<QuizQuestion> loadQuestionsFromCSV(String filePath) {
        List<QuizQuestion> questions = new ArrayList<>();
        String line;
        boolean isFirstLine = true;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] values = line.split(",");
                if (values.length == 5) {
                    String question = values[0];
                    String[] options = new String[]{values[1], values[2], values[3]};
                    String correctAnswer = values[4];
                    questions.add(new QuizQuestion(question, options, correctAnswer));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }
}