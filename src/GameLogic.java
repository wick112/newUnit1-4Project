import java.util.Scanner;
public class GameLogic{
    private int rounds;
    private int wins;
    private ObjectCreator user;
    private String playAgain;
    private String ucTemp;
    private String uc;
    private String bcTemp;
    private String bc;
    private boolean playerWon;
    private boolean draw;
    private Scanner scanner;



    public GameLogic(ObjectCreator user){
        this.user = user;
        wins = 0;
        rounds = 0;
        this.scanner = new Scanner(System.in);
        playAgain = "y";
    }
    //overloaded constructor
    public GameLogic(ObjectCreator user, Scanner scanner){
        this.user = user;
        wins = 0;
        rounds = 0;
        this.scanner = scanner;
        playAgain = "y";
    }

    public void startGame(){
        System.out.println("What is your name? ");
        String name = scanner.nextLine();
        System.out.println("WELCOME TO ROCK PAPER SCISSORS!");
        while (!(playAgain.equals("n"))){
            System.out.println("How many rounds would you like to play " + name.substring(0,1).toUpperCase() + name.substring(1) + "? (Eg. 5)");
            int req = scanner.nextInt();
            scanner.nextLine();
            for (int i = 1; i <= req; i ++){
                playRound();
            }
            System.out.println("Do you want to keep playing? (y/n) ");
            playAgain = scanner.nextLine();
        }

    }

    public void playRound(){
        rounds++;
        getUserChoice();
        bcTemp = user.botChoice();
        bc = user.convertBotImage();
        System.out.println("You: " + uc + " VS. Opponent: " + bc);
        System.out.println("LET THE FIGHT BEGIN!");
        winner(ucTemp, bcTemp);
        if(playerWon == false){
            if (draw == true){
                System.out.println("You and the Opponent Tied!" + "\n");
            }else{
                System.out.println("You Lost!" + "\n");
            }
        }else{
            wins++;
            System.out.println("You Won!" + "\n");
        }
        printRoundSummary();
    }

    private void printRoundSummary() {
        String resultSymbol;
        System.out.println("\nRound " + rounds + " Summary:");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                /* try and catch was used so that both the getResultSymbol method
                and its overlaoded counter-part could both be utilized */
                try {
                    resultSymbol = getResultSymbol(playerWon, draw);
                }catch (Exception e){
                    resultSymbol = getResultSymbol();
                }
                System.out.print(resultSymbol + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private String getResultSymbol() {
        if (playerWon == false && draw == true) {
            return "[\uD83E\uDD1D]"; // Tie
        } else if (playerWon == true) {
            return "[\uD83E\uDD47]"; // Win
        } else if (playerWon == false && draw == false) {
            return "[❌]"; // Lose
        } else {
            return "[ ]"; // Empty cell if there is an error
        }
    }

    //overloaded method which takes in the private variables as direct parameters
    private String getResultSymbol(boolean playerWon, boolean draw) {
        if (playerWon == false && draw == true) {
            return "[\uD83E\uDD1D]"; // Tie
        } else if (playerWon == true) {
            return "[\uD83E\uDD47]"; // Win
        } else if (playerWon == false && draw == false) {
            return "[❌]"; // Lose
        } else {
            return "[ ]"; // Empty cell if there is an error
        }
    }

    public void winner(String ucTemp, String bcTemp){

        if (ucTemp.equals(bcTemp)){
            playerWon = false;
            draw = true;
        }else{
            if ((ucTemp.equals("rock") && bcTemp.equals("scissors"))||(ucTemp.equals("paper") && bcTemp.equals("rock")) || (ucTemp.equals("scissors") && bcTemp.equals("paper"))){
                playerWon = true;
                draw = false;
            }else{
                playerWon = false;
                draw = false;
            }
        }
    }

    public void getUserChoice(){
        System.out.println("Rock, Paper, or Scissors? ");
        String input = scanner.nextLine().toLowerCase();
        System.out.println();
        this.user = new ObjectCreator(input);
        ucTemp = user.getUserObject();
        uc = user.convertUserImage();

    }

    public int getRoundsPlayed(){
        return rounds;
    }

    public int getWins(){
        return wins;
    }

}