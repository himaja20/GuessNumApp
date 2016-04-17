
public class GuessNumApp {

  public static void main(String[] args) {
    new GuessNumApp().startGame();
  }

  private void startGame() {
    GuessNumModel model = new GuessNumModel();
    new GuessNumView(model);
    new GuessNumView(model);
    new GuessNumView(model);
    new GuessNumView(model);
    model.startGame();
  }

}
