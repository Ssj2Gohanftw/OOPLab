import javax.swing.*;
import java.awt.*;

class QuizUIQuestions {
    public String[] questions = {
            "Which book from the following is written by George Orwell?",
            "What game was written in the Java Programming Language?",
            "What is the antonym of Preceding?",
            "How many countries are present in the EU?",
            "What is the best selling Console of all time?",
            "What is the chemical formula for water?",
            "In which year did the Berlin Wall fall?",
            "Who painted the Mona Lisa?",
            "Which planet is known as the Red Planet?",
            "What is the capital of Japan?",
            "Which company developed the iPhone?",
            "What is the square root of 144?",
            "Who is the author of Harry Potter?",
            "Which element has the atomic number 6?",
            "What is the largest mammal in the world?",
            "In which continent is the Sahara Desert located?",
            "Who was the first president of the United States?",
            "What is the fastest land animal?",
            "How many bones are in the adult human body?",
            "Who invented the lightbulb?"
    };

    public String[][] options = {
            {"1984", "A Tale of Two Cities", "The Time Machine"},
            {"Hollow Knight", "Minecraft", "Cuphead"},
            {"Previous", "Succeeding", "Leading"},
            {"26", "29", "27"},
            {"Xbox 360", "Nintendo Switch", "PS2"},
            {"H2O", "CO2", "NaCl"},
            {"1987", "1989", "1991"},
            {"Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso"},
            {"Earth", "Mars", "Jupiter"},
            {"Tokyo", "Beijing", "Seoul"},
            {"Apple", "Samsung", "Google"},
            {"10", "12", "14"},
            {"J.K. Rowling", "George R.R. Martin", "J.R.R. Tolkien"},
            {"Carbon", "Oxygen", "Nitrogen"},
            {"Blue Whale", "Elephant", "Great White Shark"},
            {"Africa", "Asia", "Australia"},
            {"George Washington", "Abraham Lincoln", "Thomas Jefferson"},
            {"Cheetah", "Lion", "Horse"},
            {"206", "208", "210"},
            {"Thomas Edison", "Nikola Tesla", "Alexander Graham Bell"}
    };

    public String[] correct_answers = {
            "1984", "Minecraft", "Succeeding", "27", "PS2", "H2O", "1989",
            "Leonardo da Vinci", "Mars", "Tokyo", "Apple", "12",
            "J.K. Rowling", "Carbon", "Blue Whale", "Africa", "George Washington",
            "Cheetah", "206", "Thomas Edison"};

    public String[] getQuestions() {
        return questions;
    }

    public String[][] getOptions() {
        return options;
    }

    public String[] getCorrectAnswers() {
        return correct_answers;
    }
}

public class Quiz_UI {
    private JFrame frame;
    private JLabel welcomelbl;
    private JButton confirmButton;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JPanel contentPanel;
    private JPanel welcomePanel;
    private JPanel QuizPanel;
    private JLabel welcomeplayerlbl;
    private ButtonGroup Option_bg;
    private int currentQuestion = 0;
    private QuizUIQuestions question = new QuizUIQuestions();
    private String p1_nm;
    private String p2_nm;
    private Player p1;
    private Player p2;
    private Player curr_player;
    private ImageIcon gif;
    public Quiz_UI() {
        frame = new JFrame("Quiz Game");
        confirmButton.addActionListener(e -> checkCorrectAnswer());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.add(contentPanel);
        frame.setVisible(true);

        welcomelbl.setVisible(true);
        radioButton1.setVisible(false);
        radioButton2.setVisible(false);
        radioButton3.setVisible(false);
        confirmButton.setVisible(false);


        SwingUtilities.invokeLater(() -> {
            Timer timer = new Timer(2000, e -> {
                p1_nm = JOptionPane.showInputDialog(frame,
                        "Player 1, Please enter your name:",
                        "Name Input", JOptionPane.PLAIN_MESSAGE);
                p2_nm = JOptionPane.showInputDialog(frame,
                        "Player 2, Please enter your name:",
                        "Name Input", JOptionPane.PLAIN_MESSAGE);
                p1 = new Player(p1_nm);
                p2 = new Player(p2_nm);
                curr_player = p1;
                if ((p1.getName() == null && p2.getName() == null)
                        ||
                        (p1.getName().trim().isEmpty() && p2.getName().trim().isEmpty()))
                {
                    JOptionPane.showMessageDialog(frame,
                            "Your Names can't be empty. Please enter your names. Exiting the program...");
                    System.exit(0);
                }

                welcomeplayerlbl.setText("Welcome, " + p1.getName() + " and " + p2.getName() + "! Let's start the quiz.");
                welcomelbl.setVisible(true);
                loadQuestionsAndOptions(currentQuestion);
                radioButton1.setVisible(true);
                radioButton2.setVisible(true);
                radioButton3.setVisible(true);
                confirmButton.setVisible(true);
                welcomeplayerlbl.setVisible(false);
            });
            timer.setRepeats(false);
            timer.start();
        });
    }

    public void loadQuestionsAndOptions(int currentQuestion) {
        welcomelbl.setText(curr_player.getName() + "'s turn: " + question.getQuestions()[currentQuestion]);
        radioButton1.setText(question.getOptions()[currentQuestion][0]);
        radioButton2.setText(question.getOptions()[currentQuestion][1]);
        radioButton3.setText(question.getOptions()[currentQuestion][2]);
        Option_bg.clearSelection();
    }

    public void checkCorrectAnswer() {
        String correctAnswer = question.getCorrectAnswers()[currentQuestion];
        String selectedAnswer = null;
        if (radioButton1.isSelected()) {
            selectedAnswer = radioButton1.getText();
        } else if (radioButton2.isSelected()) {
            selectedAnswer = radioButton2.getText();
        } else if (radioButton3.isSelected()) {
            selectedAnswer = radioButton3.getText();
        }

        if (selectedAnswer == null) {
            JOptionPane.showMessageDialog(frame, "Please select a valid option!");
            return;
        }

        if (selectedAnswer.equals(correctAnswer)) {
            JOptionPane.showMessageDialog(frame, "Correct Answer!");
            curr_player.IncrementScore();
            curr_player.IncrementNumOfCorrectAnswers();
        } else {
            JOptionPane.showMessageDialog(frame, "Sorry, that is incorrect. The correct answer is: " + correctAnswer);
            curr_player.IncrementNumOfWrongAnswers();
        }

        currentQuestion++;
        if (currentQuestion < question.getQuestions().length) {
            curr_player = (curr_player == p1) ? p2 : p1;
            loadQuestionsAndOptions(currentQuestion);
        } else {
            displayResult();
            System.exit(0);
        }
    }

    public void displayResult() {
        String Result = "<html>Quiz Result\n" +
                "----------<br>" +
                p1.getName() + "'s Score: " + p1.getScore()
                + "<br>Number of Correct Answers: " + p1.getNumCorrectAnswers()
                + "<br>Number of Wrong Answers: " + p1.getNumWrongAnswers()
                + "<br><br>" + p2.getName() + "'s Score: " + p2.getScore()
                + "<br>Number of Correct Answers: " + p2.getNumCorrectAnswers()
                + "<br>Number of Wrong Answers: " + p2.getNumWrongAnswers();
        if (p1.getScore() > p2.getScore()) {
            Result += "<br>The winner is: " + p1.getName() + "!";
             gif=new ImageIcon("Images/crown.gif");
        } else if (p2.getScore() > p1.getScore()) {
            Result += "<br>The winner is: " + p2.getName() + "!";
            gif=new ImageIcon("Images/crown.gif");
        }
        else {
            Result += "<br>It's a tie!";
            gif=new ImageIcon("Images/TieGame.png");
        }
        Result+="</html>";
        JLabel Resultlbl=new JLabel(Result);
        Resultlbl.setHorizontalAlignment(SwingConstants.CENTER);

        Object[] WinnerGif={Resultlbl,new JLabel(gif)};
        JOptionPane.showMessageDialog(frame,WinnerGif,"Quiz Result",JOptionPane.PLAIN_MESSAGE );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Quiz_UI::new);
    }
}
