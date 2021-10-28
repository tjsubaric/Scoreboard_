public abstract class Game {
    private Team team1;
    private Team team2;
    private int period;
    private int currentPeriod;
    private String periodName;
    private String[] scoringMethods;

    public Game(String team1, String team2, int period, int currentPeriod, String periodName, String[] scoringMethods) {
        this.team1 = new Team(team1);
        this.team2 = new Team(team2);
        this.period = period;
        this.currentPeriod = currentPeriod;
        this.periodName = periodName;
        this.scoringMethods = scoringMethods;
    }

    public void addScore(int points, String team, String scoringMethod) {
        if (team.equals("1")) {
            team1.addScore(points);
        }
        else {
            team2.addScore(points);
        }
    }

    public String getTeam1() {
        return team1.getName();
    }

    public String getTeam2() {
        return team2.getName();
    }

    public String[] getScoringMethods(){
        return scoringMethods;
    }

    public int getTeam1Score(){
        return team1.getScore();
    }

    public int getTeam2Score(){
        return team2.getScore();
    }

    public String getPeriodName(){
        return periodName;
    }

    public int getCurrentPeriod(){
        return currentPeriod;
    }

    public void startGame() {
        currentPeriod = 1;
    }

    public void newPeriod() {
        currentPeriod++;
    }

    public boolean endGame() {
        if(currentPeriod > period){
            return true;
        }
        else{
            return false;
        }
    }

    public String getWinner() {
        if (team1.getScore() > team2.getScore()) {
            return team1.getName();
        }
        else {
            return team2.getName();
        }
    }
}
