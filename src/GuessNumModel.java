import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuessNumModel {
  private int number;
  private Random random = new Random();
  private List<GuessNumListener> listeners = new ArrayList<GuessNumListener>();

  private void createNumber(){
    number = random.nextInt(100);
  }

  public void guessMade(int guess){
    if (guess > number){
      fireTooHighEvent(guess);
    }
    else if(guess < number){
      fireTooLowEvent(guess);
    }else{
      fireWinnerEvent(guess);
    }
  }

  public void startGame(){
    createNumber();
    fireGameStarted();
  }
  private void fireWinnerEvent(int guess) {
    for (GuessNumListener listener: listeners){
      listener.winner(guess);
    }    
  }

  private void fireTooLowEvent(int guess) {
    for (GuessNumListener listener: listeners){
      listener.tooLow(guess);
    }    
  }

  private void fireGameStarted() {
    for (GuessNumListener listener: listeners){
      listener.gameStarted();
    }    
  }
  private void fireTooHighEvent(int guess) {
    for (GuessNumListener listener: listeners){
      listener.tooHigh(guess);
    }
  }

  public void addGuessNumListener(GuessNumListener guessNumListener){
    listeners.add(guessNumListener);
  }

  public void removeGuessNumListener(GuessNumListener guessNumListener){
    listeners.remove(guessNumListener);
  }
}
