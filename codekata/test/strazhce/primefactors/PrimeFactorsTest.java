package strazhce.primefactors;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class PrimeFactorsTest {

	private static final int VALUE_4 = 4;
	private static final int VALUE_2 = 2;
	private static final int VALUE_1 = 1;

	@Test
	public void testOne() {
		List<Integer> primes = new PrimeFactors().factor(VALUE_1);

		assertEquals("Size", 1, primes.size());
		assertEquals("Prime", Integer.valueOf(VALUE_1), primes.get(0));
	}

	@Test
	public void testTwo() {
		List<Integer> primes = new PrimeFactors().factor(VALUE_2);

		assertEquals("Size", 1, primes.size());
		assertEquals("Prime", Integer.valueOf(VALUE_2), primes.get(0));
	}

	@Test
	public void testTwoFactors() {
		List<Integer> primes = new PrimeFactors().factor(VALUE_4);

		assertEquals("Size", 2, primes.size());
		assertEquals("Prime", Integer.valueOf(VALUE_2), primes.get(0));
		assertEquals("Prime", Integer.valueOf(VALUE_2), primes.get(1));
	}

	@Test
	public void testMultipleFactors() {
		List<Integer> primes = new PrimeFactors().factor(2*3*7*11);

		assertEquals("Size", 4, primes.size());
		assertEquals("Prime", Integer.valueOf(2), primes.get(0));
		assertEquals("Prime", Integer.valueOf(3), primes.get(1));
		assertEquals("Prime", Integer.valueOf(7), primes.get(2));
		assertEquals("Prime", Integer.valueOf(11), primes.get(3));
	}
	
	@Test
	public void testBigFactors() {
		List<Integer> primes = new PrimeFactors().factor(859*997);

		assertEquals("Size", 2, primes.size());
		assertEquals("Prime", Integer.valueOf(859), primes.get(0));
		assertEquals("Prime", Integer.valueOf(997), primes.get(1));
	}
	
	@Test
	public void testIsFactor() {
		checkFactor(true, 1, 1);
		checkFactor(true, 2, 2);
		checkFactor(false, 3, 2);
	}

	private void checkFactor(boolean isFactor, int num, int factor) {
		PrimeFactors f = new PrimeFactors();
		assertTrue(num + "/" + factor, f.isFactor(num, factor) == isFactor);
	}
}
