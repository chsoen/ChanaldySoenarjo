import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        String playGame;
        int playerWins = 0;
        int playerLosses = 0;

        do {
            String[] hands = {"rock", "paper", "scissors"};
            String compChoice = hands[rand.nextInt(3)]; //Computer chooses random entry in array
            String playerChoice;

            do {
                System.out.println("Choose rock, paper, or scissors");
                playerChoice = scan.next().toLowerCase();
            } while (!Arrays.asList(hands).contains(playerChoice)); //Player is asked to choose a valid choice

            System.out.println("You chose " + playerChoice + " and computer chose " + compChoice);

            if (playerChoice.equals(compChoice)) { //When player and computer has same choice, it's a tie
                System.out.println("It's a tie!");
            } else {
                boolean result = false;
                switch (playerChoice) { //If computer's sign is beaten, player wins, else player loses
                    case "rock": result = compChoice.equals("scissors"); break;
                    case "paper": result = compChoice.equals("rock"); break;
                    case "scissors": result = compChoice.equals("paper"); break;
                }

                if (result) { //Increment wins and print player wins
                    System.out.println("You win!");
                    playerWins++;
                } else { //Increment losses and print player loses
                    System.out.println("You lose!");
                    playerLosses++;
                }
            }

            do {
                System.out.println("Play again? Yes or no?");
                playGame = scan.next().toLowerCase();
            } while (!playGame.equals("yes") && !playGame.equals("no")); //Keep asking until "yes" or "no"

        } while (playGame.equals("yes"));

        System.out.println("You have " + playerWins + " wins and " + playerLosses + " losses");
    }
}