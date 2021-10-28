
// Extension of Game for Baseball that sets the parameters and overrides addScore method
public class Baseball extends Game{
    // Constructor that initializes the proper variables of Game for Baseball
    // Name of Team 1
    // Name of Team 2
    public Baseball(String team1, String team2) {
        super(team1, team2, 9, 1, "Inning", new String[] {"Home Run","Two-Run Home Run","Three-Run Home Run","Grand Slam"});
    }
    //Overrides addScore of Game to give the correct amount of points based on scoring method
    // Number of points to add
    // Team which team gets the points
    // scoreMethod used to determine points
    @Override
    public void addScore(int points, String team, String scoreMethod) {
        if (scoreMethod.equals("Grand Slam")) {
            points = 4;
        }
        else if (scoreMethod.equals("Three-Run")) {
            points = 3;
        }
        else if (scoreMethod.equals("Three-Run")) {
            points = 2;
        }
        else{
            points = 1;
        }
        super.addScore(points, team, scoreMethod);
    }
}