import java.util.Scanner;
class QuizQuestions{
    public  String[] questions={"Which book from the following is written by George Orwell?",
            "What game was written in the Java Programming Language?",
            "What is the antonym of Preceding?",
            "How many countries are present in the EU?",
            "What is the best selling Console of all time?",
            "What is the chemical formula for water?",
            "In which year did the Berlin Wall fall?",
    };
    public String[] options={"a)1984\tb)A Tale of Two Cities\tc)The Time Machine",
            "a)Hollow Knight\tb)Minecraft\tc)Cuphead",
            "a)Previous\tb)Succeeding\tc)Leading",
            "a)26\tb)29\tc)27",
            "a)Xbox 360\tb)Nintendo Switch\tc)PS2",
            "  a)H2O\tb)CO2\tc)NaCl",
            "  a)1987\tb)1989c)\t1991"
    };
    public String[] correct_answers={"a","b","b","c","c","a","b"};
}

public class QuizGame {
    public static void main(String[]args){
        QuizQuestions q=new QuizQuestions();
        int score=0;
        int num_correct_answers=0;
        int num_wrong_answers=0;
        int highestScore=q.questions.length;
        Scanner s=new Scanner(System.in);
        System.out.println("Welcome to my quiz game!\nWhat is your name? ");
        String name=s.next();
        System.out.println("Hello "+name+"!");
        while (true){
            for(int i=0;i<q.questions.length;i++){
                System.out.println("\nQuestion "+(i+1)+" : "+ q.questions[i]);
                System.out.println("Your Options are:"+q.options[i]);
                System.out.println("Choose your Answer?");
                String usersAnswer=s.next().toLowerCase();

                if(usersAnswer.equals(q.correct_answers[i])){
                    score++;
                    num_correct_answers++;
                    System.out.println("Correct answer!");
                }
                else{
                    num_wrong_answers++;
                    System.out.println("Sorry!The correct is:"+q.correct_answers[i]);
                }
            }
            System.out.println("Results:");
            System.out.println("---------");
            System.out.println("Your Score was:"+score+" out of "+ q.questions.length);
            System.out.println("The no of correct answers:"+num_correct_answers);
            System.out.println("The no of wrong answers:"+num_wrong_answers);
            if(score==highestScore){
                System.out.println("Congrats!You are number 1!");
            }
            else if (score>=4) {
                System.out.println("Good Attempt!You can do better!");
            }
            else{
                System.out.println("Sorry!Do better next time");
            }
            System.out.println("Do you want to play again?");
            String choice=s.next().toLowerCase();
            if(choice.equals("No") || choice.equals("N")){
                System.out.println("Thanks for playing!");
                break;
            }
            else{
                num_correct_answers=0;
                num_wrong_answers=0;
                score=0;
            }
        }
        s.close();
    }
}
