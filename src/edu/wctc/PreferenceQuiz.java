package edu.wctc;
import java.util.Scanner;

public class PreferenceQuiz {

    public static final String[] choicePrompts = {
            "Mild(0) or Spicy(1)?: ",
            "Tea(0) or Coffee(1)?: ",
            "Breakfast(0) or Brunch(1)?: ",
            "Summer(0) or Winter(1)?: ",
            "Paper(0) or Plastic(1)?: "
        };

    public static int[] userAnswers = new int[5];

    public static void askQuestions(Scanner input){
        for (int i = 0; i < choicePrompts.length; i++) {
            int answer = -1;
            do {
                System.out.print(choicePrompts[i]);
                answer = input.nextInt();
            } while (answer < 0 || answer > 1); //Input validation for answers
            userAnswers[i] = answer;
        }
    }

    public static int getScore(){
        int sum = 0;
        for(int x: userAnswers){
            sum += x;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int score;

        boolean userContinue = true;
        while(userContinue) {
            System.out.printf("Welcome to the Preference Quiz!%n-------------------------------%n");
            askQuestions(input);
            score = getScore();

            if (score < 3)  System.out.println("You're kinda boring.");
            else if (score == 3) System.out.println("Perfectly balanced, as all things should be.");
            else System.out.println("You live life on the edge!");

            System.out.println("Retry Quiz?  (y) to continue, any other key to exit");
            userContinue = input.next().toLowerCase().charAt(0) == 'y';
        }
    }
}
