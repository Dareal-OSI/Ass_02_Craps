import java.util.Random;
import java.util.Scanner;

public class Craps
{
    public static void main(String[] args)
    {
        // Create a Scanner and a Random
        // Do (one game each time through)
        //     Roll two dice and show each die and the sum
        //     If the sum is 2, 3 or 12: crapped out, the game is over with a loss
        //     Else if the sum is 7 or 11: a natural, the game is over with a win
        //     Else: the sum becomes the point
        //         While the game is not over
        //             Roll again and show each die and the sum
        //             If the sum is the point: made point and won
        //             Else if the sum is 7: got a seven and lost
        //             Else: trying for point
        //         End while
        //     End if
        //     Ask to play again, looping until the answer is Y or N
        // While the user wants to play again

        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        int die1 = 0;
        int die2 = 0;
        int sum = 0;
        int point = 0;
        int gameNum = 0;
        boolean gameOver = false;
        boolean validAnswer = false;
        String playAgain = "";

        do
        {
            gameNum++;
            System.out.println("\n========== Game " + gameNum + " ==========");

            // First roll
            die1 = rnd.nextInt(6) + 1;
            die2 = rnd.nextInt(6) + 1;
            sum = die1 + die2;
            System.out.println("Roll: " + die1 + " + " + die2 + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12)
            {
                System.out.println("Craps! You crapped out with a " + sum + ". You lose.");
            }
            else if (sum == 7 || sum == 11)
            {
                System.out.println("A natural " + sum + "! You win!");
            }
            else
            {
                point = sum;
                System.out.println("The point is now " + point + ".");
                gameOver = false;

                // Keep rolling until the point or a 7 comes up
                while (!gameOver)
                {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;
                    System.out.print("Roll: " + die1 + " + " + die2 + " = " + sum + "  ->  ");

                    if (sum == point)
                    {
                        System.out.println("Made point and won!");
                        gameOver = true;
                    }
                    else if (sum == 7)
                    {
                        System.out.println("Got a seven and lost.");
                        gameOver = true;
                    }
                    else
                    {
                        System.out.println("Trying for point " + point + "...");
                    }
                }
            }

            // Ask to play again and bulletproof the answer
            validAnswer = false;
            do
            {
                System.out.print("\nDo you want to play again? [Y/N]: ");
                playAgain = in.nextLine();
                if (playAgain.equalsIgnoreCase("Y") || playAgain.equalsIgnoreCase("N"))
                {
                    validAnswer = true;
                }
                else
                {
                    System.out.println("You must enter Y or N, not: " + playAgain);
                }
            } while (!validAnswer);

        } while (playAgain.equalsIgnoreCase("Y"));

        System.out.println("\nThanks for playing Craps!");
    }
}
