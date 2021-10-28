//Extension of Game for Football that sets the parameters and overrides addScore method
public class Football extends Game{
    // Constructor that initializes the proper variables of Game for Football
    // Name of Team 1
    // Name of Team 2
    public Football(String team1, String team2) {
        super(team1, team2, 4, 1, "Quarter", new String[] {"Touchdown", "Extra Point", "Two-Point Conversion", "Field Goal", "Safety"});
    }

     //Overrides addScore of Game to give the correct amount of points based on scoring method
     // Number of points to add
     // Team which team gets the points
     // scoreMethod used to determine points
    @Override
    public void addScore(int points, String team, String scoreMethod) {
        if (scoreMethod.equals("Touchdown")) {
            points = 6;
        }
        else if (scoreMethod.equals("Extra Point")) {
            points = 1;
        }
        else if (scoreMethod.equals("Field Goal")) {
            points = 3;
        }
        else {
            points = 2;
        }
        super.addScore(points, team, scoreMethod);
    }
}