package project.lotto.mvc;

public interface LottoModelInterface {
	
	int getProbability();
	void setProbability(int n, int k);
	void registerObserver (ProbObserver o);
	void removeObserver (ProbObserver o);
	
}