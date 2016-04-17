
/*
 * Think about a UI for the game
 * Assessment - Enum - Hi , Low, Correct
 * event1 - is guess made
 */
public interface GuessNumListener {
  void gameStarted();
  void tooHigh(int guess);
  void tooLow(int guess);
  void winner(int guess);
}