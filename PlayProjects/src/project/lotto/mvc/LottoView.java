package project.lotto.mvc;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LottoView extends JFrame implements ProbObserver {
	
	LottoModelInterface model;
	LottoControllerInterface controller;
	
	private JTextField range;
	private JTextField numberOfSelections; 
	private JTextField probabilityOfWinning;
	private JButton probabilityBtn;
	
	public LottoView(LottoModelInterface model, LottoControllerInterface controller) {
		
		this.model = model;
		this.controller = controller;
		model.registerObserver((ProbObserver)this);
		
	}
	
	public void createView(){
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
		
		probabilityBtn.addActionListener(new BtnListener());
	}
	
	
	private class BtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(null, "Inside the ActionPerformed method of the handler", "Method: ActionPerformed",JOptionPane.INFORMATION_MESSAGE);
			int n = Integer.parseInt(range.getText());
			int k = Integer.parseInt(numberOfSelections.getText());
			
			controller.getProbability(n, k);	
		}
	}

	
	@Override
	public void updateProb() {
		probabilityOfWinning.setText(Integer.toString(model.getProbability()));
	}
}
