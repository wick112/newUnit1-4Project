public class GameStats {
    private GameLogic gameLogic;

    public GameStats(GameLogic logic){
        gameLogic = logic;
    }

    public void generateGameStats(){
        System.out.println("*-*-*-*-*-*GAME-STATS*-*-*-*-*-*");
        System.out.println("Rounds Played: " + gameLogic.getRoundsPlayed());
        System.out.println("Total Wins: " + gameLogic.getWins());
        System.out.println("Win Rate: " + getWinRate() + "% ");
        System.out.println(personalMessage());

    }

    private double getWinRate(){
        int rounds = gameLogic.getRoundsPlayed();
        int wins = gameLogic.getWins();
        double winRate = ((double)wins / rounds) * 100.0;
        return winRate;
    }

    private String personalMessage(){
        if (getWinRate() <= 50.0){
            return "Luck wasn't on your side \uD83D\uDC80\uD83D\uDDD1\uFE0F";
        }
        if (getWinRate() <= 85.0){
            return "Better luck next time \uD83D\uDE2D";
        }
        if (getWinRate() > 85.0){
            return "You're a Rock Paper Scissors Champ \uD83C\uDFC6\uD83D\uDC10";
        }
        return "";
    }
}
