public class ObjectCreator{
    private String choice;
    private String choiceAsImage;
    private String botImage;
    private String botChoice;
    public ObjectCreator(String choice){
        this.choice = choice;
        botChoice = "";
        if (choice.equals("rock")){
            choice  = "rock";
        }else if (choice.equals("paper")){
            choice  = "paper";
        }else if(choice.equals("scissors")){
            choice  = "scissors";
        }

    }

    public String botChoice(){
        int randInt = (int)(Math.random() * 3) + 1;
        if (randInt == 1){
            botChoice = "rock";
        }
        if (randInt == 2){
            botChoice = "paper";
        }
        if (randInt == 3){
            botChoice = "scissors";
        }
        return botChoice;
    }

    public String getUserObject(){
        return choice;
    }

    private String getBotObject(){
        return botChoice;
    }

    public String convertUserImage(){
        if (getUserObject().equals("rock")){
            choiceAsImage = "🪨";
        }else if (getUserObject().equals("paper")){
            choiceAsImage = "📝";
        }else{
            choiceAsImage = "✂️";
        }
        return choiceAsImage;
    }

    public String convertBotImage(){
        if (getBotObject().equals("rock")){
            botImage = "🪨";
        }else if (getBotObject().equals("paper")){
            botImage = "📝";
        }else if (getBotObject().equals("scissors")){
            botImage = "✂️";
        }
        return botImage;
    }
}
