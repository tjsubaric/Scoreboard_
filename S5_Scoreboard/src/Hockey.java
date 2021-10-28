// Extension of Game for Hockey that sets the parameters and overrides addScore method
public class Hockey extends Game{
     // Constructor initializes the variables of Game for Hockey
     // Name of team 1
     //cName of team 2
    public Hockey(String team1, String team2) {
        super(team1, team2, 3, 1, "Period", new String[] {"Goal"});
    }

    //Overrides addScore of Game to give the correct amount of points based on scoring method
    // Number of points to add
    // Team which team gets the points
    // scoreMethod used to determine points
    @Override
    public void addScore(int points, String team, String scoreMethod) {
        points = 1;
        super.addScore(points, team, scoreMethod);
    }
}