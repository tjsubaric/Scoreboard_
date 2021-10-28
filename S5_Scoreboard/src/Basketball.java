
 // Extension of Game for Basketball that sets the parameters and overrides addScore method
public class Basketball extends Game{
     // Constructor that initializes the proper variables of Game for Basketball
     // Name of Team 1
     // Name of Team 2
    public Basketball(String team1, String team2) {
        super(team1, team2, 4, 1, "Quarter", new String[] {"Three-Points", "Two-Points", "Free-Throw"});
    }
     //Overrides addScore of Game to give the correct amount of points based on scoring method
     // Number of points to add
     // Team which team gets the points
     // scoreMethod used to determine points
    @Override
    public void addScore(int points, String team, String scoreMethod) {
        if (scoreMethod.equals("Three-Points")) {
            points = 3;
        }
        else if (scoreMethod.equals("Two-Points")) {
            points = 2;
        }
        else{
            points = 1;
        }
        super.addScore(points, team, scoreMethod);
    }
}