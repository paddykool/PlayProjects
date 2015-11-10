package project.lotto.mvc;

import javax.swing.JFrame;

public class LottoController implements LottoControllerInterface {

	LottoModelInterface model;
	LottoView view;
	
	public LottoController (LottoModelInterface model){
		this.model = model;
		view = new LottoView(model,this);
		view.createView();
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(300, 300);
		view.setVisible(true);
	}

	@Override
	public void getProbability(int n, int k) {
		model.setProbability(n, k);
	}
}
