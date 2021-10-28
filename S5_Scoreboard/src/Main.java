////////////////////////////
// By: Tommy Subaric
// Created: 10-21-2021
// Descriptions: Simulates a scoreboard
// interface for a variety of different sports
// S_5 Scoreboard
//////////////////////////////

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String team1, team2; // team names
        Game scoreboard; // type game variable name scoreboard takes in Game inputs
        int choice = 0; // choice is used for user input
        int gameChoice = 0; // int used for game choice
        boolean isValid; // checks if user input is valid

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Team 1: ");
        team1 = scan.nextLine();
        System.out.print("Enter Team 2: ");
        team2 = scan.nextLine();

        // 0 is assigned when the user choice is not valid
        while (gameChoice == 0) {
            System.out.println("Please select a game type:");
            System.out.println("1. Football");
            System.out.println("2. Baseball");
            System.out.println("3. Basketball");
            System.out.println("4. Hockey");
            System.out.println("Enter Choice:");
            gameChoice = scan.nextInt();

            // checks if gameChoice is invalid
            if ((gameChoice != 1) && (gameChoice != 2)  && (gameChoice != 3) && gameChoice != 4) {
                gameChoice = 0;
                System.out.println("Invalid Entry");
            }
        }

        //Constructor that initializes the proper variables of Scoreboard for the correct game
        if (gameChoice ==  1) {
            scoreboard = new Football(team1, team2);
        }
        else if (gameChoice == 2) {
            scoreboard = new Baseball(team1,team2);
        }
        else if (gameChoice == 3) {
            scoreboard = new Basketball(team1, team2);
        }
        else {
            scoreboard = new Hockey(team1, team2);
        }

        scoreboard.startGame();

        while (!scoreboard.endGame()) { // checks when the game is over to signal the end of the scoreboard
            System.out.println(scoreboard.getPeriodName() + ": " + scoreboard.getCurrentPeriod()); // output current game-specific period
            System.out.println(scoreboard.getTeam1() + " - " + scoreboard.getTeam1Score()); // output teams and scores
            System.out.println(scoreboard.getTeam2() + " - " + scoreboard.getTeam2Score());
            int i = 1;
            System.out.println("Menu:");

            for (String scoringMethod : scoreboard.getScoringMethods()) { // gives an option for each scoring method for team 1
                System.out.println(i + ": " + scoreboard.getTeam1() + " " + scoringMethod);
                i++;
            }
            for (String scoringMethod : scoreboard.getScoringMethods()) {  // gives an option for each scoring method for team 2
                System.out.println(i + ": " + scoreboard.getTeam2() + " " + scoringMethod);
                i++;
            }

            System.out.println(i + ": End " + scoreboard.getPeriodName()); // gives option to end period
            gameChoice = scan.nextInt(); // gets user input

            // check for valid input
            try {
                choice = gameChoice;
                isValid = (choice >= 1 && choice <= i);
            }
            catch (NumberFormatException notANum) {
                isValid = false;
            }

            if (isValid) {
                if (choice <= ((i-1)/2)) { // team1 scoring options
                    scoreboard.addScore(0, "1", scoreboard.getScoringMethods()[choice-1]);
                }
                else if (choice > ((i-1)/2) && choice != i) { // team2 scoring options
                    scoreboard.addScore(0, "2", scoreboard.getScoringMethods()[choice-((i-1)/2)-1]);
                }
                else {
                    scoreboard.newPeriod();
                }

                if (scoreboard.endGame()) { // game over menu
                    System.out.println("Game Over!");
                    // displays final score
                    System.out.println("Final Score:");
                    System.out.println(scoreboard.getTeam1() + " - " + scoreboard.getTeam1Score());
                    System.out.println(scoreboard.getTeam2() + " - " + scoreboard.getTeam2Score());

                    if (scoreboard.getTeam1Score() == scoreboard.getTeam2Score()) { // check for tie
                        System.out.println("It's a tie!");
                    }
                    else { // displays winning team
                        System.out.println(scoreboard.getWinner() + " win!");
                    }
                }
            }
            else { // user choice invalid entry
                System.out.println("Invalid Entry");
            }
        }
    }
}