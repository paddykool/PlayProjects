package project.lotto.calc;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class LotteryCalculatorFrame extends JFrame{

	private JTextField range;
	private JTextField numberOfSelections; 
	private JTextField probabilityOfWinning;
	private JButton probabilityBtn;
	
	public LotteryCalculatorFrame() {
		super("Lottery Calculator");
		setLayout(new FlowLayout());
	
		add(new JLabel("Please enter the range: "));
		range = new JTextField(10);
		add(range);
	
		add(new JLabel("Number of selections:   "));
		numberOfSelections = new JTextField(10);
		add(numberOfSelections);
		
		probabilityBtn = new JButton("Get Probability!");
		add(probabilityBtn);
		
		probabilityOfWinning = new JTextField(20);
		add(probabilityOfWinning);
		
		BtnListener listener = new BtnListener();
		probabilityBtn.addActionListener(listener);
		
	}
	
	private class BtnListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int range = Integer.parseInt(LotteryCalculatorFrame.this.range.getText());
			int numSelections = Integer.parseInt(numberOfSelections.getText());
			
			probabilityOfWinning.setText(Integer.toString(combin(range, numSelections)));
						
		}
		
	}
	
	static BigInteger bigFact(BigInteger n){
		if (n.compareTo(BigInteger.ZERO) == 0){
			return BigInteger.ONE;
		}
		else{
			return n.multiply(bigFact(n.subtract(BigInteger.ONE)));	
		}
	}
	
	static int combin(int n, int k){   
		
		BigInteger bigN = new BigInteger(Integer.toString(n));
		BigInteger bigK = new BigInteger(Integer.toString(k));
		
		BigInteger factN = bigFact(bigN);
		BigInteger factK = bigFact(bigK);
		BigInteger NminusK = bigN.subtract(bigK);
		BigInteger factNminusK = bigFact(NminusK);
		
		// return n! / (k! * (n-k)!)
		BigInteger bigCombin = factN.divide(factK.multiply(factNminusK));
		
		return bigCombin.intValue(); 
	}

	public static void main (String... arga){
		
		LotteryCalculatorFrame lFrame = new LotteryCalculatorFrame();
		lFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lFrame.setSize(300, 300);
		lFrame.setVisible(true);
	}

}