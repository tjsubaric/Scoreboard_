public class Team { //object team that has two instance variables
    private String name;
    private int score;

    public Team(String name){
        this.name = name;
        this.score = 0;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public int addScore(int points){
        return score += points;
    }
    
}
