import java.util.Scanner;
public class GameRunner{
    public static void main(String[] args) {
        ObjectCreator user = new ObjectCreator("rock");

        Scanner scanner = new Scanner(System.in);
        GameLogic gameLogic = new GameLogic(user, scanner);

        // Start the game and generate stats once it ends
        gameLogic.startGame();
        GameStats gameStats = new GameStats(gameLogic);
        gameStats.generateGameStats();

    }
}
