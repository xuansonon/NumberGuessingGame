import java.util.*;
class NumberGame {
  public enum gameDifficulty { EASY, MEDIUM, HARD, INTENSE }

  int score;
  int guesses;
  int highestNumber;
  int answer;
  int errorPercentage;
  Boolean finished;

  public NumberGame(gameDifficulty difficulty) {
    errorPercentage = 5;
    finished = false;
    guesses = 0;
    switch(difficulty) {
      case EASY:
        score = 100;
        highestNumber = 10;
        errorPercentage = errorPercentage * 1;
        break;
      case MEDIUM:
        score = 200;
        highestNumber = 100;
        errorPercentage = errorPercentage * 2;
        break;
      case HARD:
        score = 300;
        highestNumber = 1000;
        errorPercentage = 3;
        break;
      case INTENSE:
        score = 500;
        highestNumber = 100000;
        errorPercentage = 4;
    }
    Random randNum = new Random();
    answer = randNum.nextInt(highestNumber);
  }

  public static Boolean compare(int aValueA, int aValueB) {
    return (aValueA == aValueB);
  }

  public static int toInt(String aValue) {
    int value = -1;
    try {
      value = Integer.parseInt(aValue);
    } catch(NumberFormatException e) {
      System.out.println("Incorrect input! Try again.");
    }
    return value;
  }

  public void play() {
    while(finished != true) {
      System.out.print("Guess a number: ");
      int guess = toInt(System.console().readLine());
      if(guess < 0) {
        break;
      }
      if(compare(answer, guess)) {
        System.out.println("Congratulations, you\'ve guessed the right number!");
        System.out.println("You achieved a total score of: " + String.valueOf(score) + " in " + guesses + " attempts.");
        finished = true;
      } else {
        System.out.println("Wrong number. Guess again!");
        if(guess > answer) {
          System.out.println("The number you\'re looking for is lower!");
        } else {
          System.out.println("The number you\'re looking for is higher!");
        }
        guesses++;
        score = score - (score * (errorPercentage / 100));
        System.out.println("Your score is: " + String.valueOf(score) + ".\n");
      }
    }
  }

  public static NumberGame askForGame() {
    System.out.print("Please enter a difficulty for this game: ");
    String difficulty = System.console().readLine();
    NumberGame returnGame;
    switch(difficulty) {
      case "easy":
        returnGame = new NumberGame(gameDifficulty.EASY);
        break;
      case "medium":
        returnGame = new NumberGame(gameDifficulty.MEDIUM);
        break;
      case "hard":
        returnGame = new NumberGame(gameDifficulty.HARD);
        break;
      case "intense":
        returnGame = new NumberGame(gameDifficulty.INTENSE);
        break;
      default:
        returnGame = new NumberGame(gameDifficulty.MEDIUM);
        break;
    }
    System.out.println("You've selected: " + difficulty);
    return returnGame;
  }

  public static void printWelcomeScreen() {
    System.out.println("Welcome to the Number Guessing Game!");
    System.out.println("There are 4 different difficulties, each with a higher score, but increased penalties.");
    System.out.println("The difficulties are: EASY, MEDIUM, HARD and INTENSE.");
  }

  public static void main(String[] args) {
    printWelcomeScreen();
    NumberGame game = askForGame();
    System.out.println("You have " + game.score + " points.");
    System.out.println("The number lies somewhere between 0 and " + String.valueOf(game.highestNumber));
    game.play();
  }
}
