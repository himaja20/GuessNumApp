import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessNumView implements GuessNumListener {

  private JFrame frame = new JFrame("GuessNum");
  private JTextArea textArea = new JTextArea();
  private JTextField textField = new JTextField();
  private JButton guessButton = new JButton("Guess");
  private GuessNumModel model;

  public GuessNumView(GuessNumModel model){
    this.model = model;
    model.addGuessNumListener(this);
    JPanel gamePanel= new JPanel(new BorderLayout());
    JPanel controlPanel = new JPanel(new BorderLayout());

    controlPanel.add(guessButton, BorderLayout.EAST);
    controlPanel.add(new JScrollPane(textField), BorderLayout.CENTER);

    gamePanel.add(textArea, BorderLayout.CENTER);
    gamePanel.add(controlPanel,BorderLayout.SOUTH);

    frame.getContentPane().add(gamePanel);
    guessButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        buttonClicked();
      }
    });
    frame.setSize(200, 200);
    frame.setVisible(true);
  }

  private void buttonClicked() {
    int guess = Integer.parseInt(textField.getText());
    textField.setText("");
    model.guessMade(guess);
  }

  @Override
  public void gameStarted() {
    textArea.append("GameStarted");;
  }

  @Override
  public void tooHigh(int guess) {
    textArea.append("\n Too high :" + guess);
  }

  @Override
  public void tooLow(int guess) {
    textArea.append("\n Too Low :" + guess);
  }

  @Override
  public void winner(int guess) {
    textArea.append("\n Winner:" + guess);
  }

}
