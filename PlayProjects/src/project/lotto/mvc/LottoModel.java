package project.lotto.mvc;

import java.math.BigInteger;
	
public class LottoModel implements LottoModelInterface {
	
	private int probability; 
	
	ProbObserver probabilityObserver;
	
	
	@Override
	public int getProbability() {
		return probability;
	}

	@Override
	public void registerObserver(ProbObserver o) {
		probabilityObserver = o;
	}

	@Override
	public void removeObserver(ProbObserver o) {
		probabilityObserver = null;
	}
	
	public void notifyProbObservers(){
		probabilityObserver.updateProb();
	}
	
	public void setProbability(int n, int k){
		probability = combin(n,k);
		probabilityObserver.updateProb();
	}
	
	private int combin(int n, int k){   
		
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
	
	private BigInteger bigFact(BigInteger n){
		if (n.compareTo(BigInteger.ZERO) == 0){
			return BigInteger.ONE;
		}
		else{
			return n.multiply(bigFact(n.subtract(BigInteger.ONE)));	
		}
	}
}