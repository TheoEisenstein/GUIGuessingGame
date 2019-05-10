import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	
	
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message ="";
		
		try {
		int guess = Integer.parseInt(guessText);
		
		if(guess < theNumber)
			message = guess + " is too low. Try again.";
		else if (guess > theNumber)
			message = guess + " is too high. Try again.";
		else {
			message = guess + " is correct. You win! Let's play again!";
			newGame();
		}
		} catch (Exception e) {
			message = "Enter a whole number between 1 and 100.";
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}
	
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
	}
	
	
	public GuessingGame() {
		getContentPane().setFont(new Font("Tekton Pro", Font.PLAIN, 11));
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setBackground(Color.BLACK);
		setForeground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Teddy's Hi-Lo Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel lblTeddysHiloGuessing = new JLabel("Teddy's Hi-Lo Guessing Game");
		lblTeddysHiloGuessing.setFont(new Font("Trajan Pro", Font.PLAIN, 15));
		lblTeddysHiloGuessing.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeddysHiloGuessing.setBounds(0, 35, 434, 26);
		getContentPane().add(lblTeddysHiloGuessing);
		
		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100:");
		lblGuessANumber.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		lblGuessANumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGuessANumber.setBounds(0, 96, 302, 21);
		getContentPane().add(lblGuessANumber);
		
		txtGuess = new JTextField();
		txtGuess.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		txtGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGuess.setBounds(308, 96, 37, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(172, 152, 89, 23);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(0, 210, 434, 14);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);

	}
}
