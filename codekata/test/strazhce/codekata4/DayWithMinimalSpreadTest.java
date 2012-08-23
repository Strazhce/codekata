package strazhce.codekata4;

import junit.framework.Assert;

import org.junit.Test;

public class DayWithMinimalSpreadTest {

	@Test
	public void testCalculateOne() {
		WeatherData data = new WeatherData();
		WeatherItem item = new WeatherItem(1, 5, 7);
		data.addItem(item);

		checkSpreadCalculation(data, item);
	}
	
	@Test
	public void testCalculateThree() {
		WeatherData data = new WeatherData();
		WeatherItem item = new WeatherItem(1, 5, 7);
		data.addItem(item);
		WeatherItem item2 = new WeatherItem(2, 5, 5.1);
		data.addItem(item2);
		WeatherItem item3 = new WeatherItem(3, 1, 10);
		data.addItem(item3);

		checkSpreadCalculation(data, item2);
	}

	private void checkSpreadCalculation(WeatherData data, WeatherItem expectedItem) {
		DayWithMinimalSpread spread = new DayWithMinimalSpread(data);
		
		WeatherItem minimalSpreadItem = spread.getItemWithMinimalSpread();
		
		Assert.assertNotNull("Not null item",minimalSpreadItem);
		Assert.assertEquals("Should be same day", expectedItem.getDayNumber(), minimalSpreadItem.getDayNumber());
	}
}
