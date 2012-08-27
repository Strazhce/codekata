package strazhce.primefactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

	public List<Integer> factor(int input) {
		List<Integer> res = new ArrayList<Integer>();

		if (input == 1) {
			res.add(1);
		} else {
			factorGreater(input, res);
		}
		return res;
	}

	private void factorGreater(int input, List<Integer> res) {
		int number = 2;
		do {
			while (isFactor(input, number)) {
				input = input / number;
				res.add(number);
			} 
		number++;
		} while (input > 1);
	}

	protected boolean isFactor(int input, int factor) {
		return Math.IEEEremainder(input, factor) == 0;
	}

}
