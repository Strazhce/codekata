package strazhce.codekata4;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class WeatherItemTest {

	private static final double TEMP2 = 7.1;
	private static final double TEMP1 = 2.5;
	private static final double SPREAD = TEMP2-TEMP1;

	@Test
	public void testSpread() {
		WeatherItem item = new WeatherItem(1,TEMP1,TEMP2);
		
		Assert.assertEquals("Spread",SPREAD, item.getTempSpread(),0);
	}

}
