package project.lotto.mvc;

public class LottoCalcTestHarness {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		LottoModelInterface model = new LottoModel();
		LottoControllerInterface controller = new LottoController(model);
		
	}

}