package strazhce.codekata4;

import static org.junit.Assert.*;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;

public class DayWithMinimalSpreadTest {

	private static final String ITEM3_NAME = "3";
	private static final String ITEM2_NAME = "2";
	private static final String ITEM_NAME  = "1";

	@Test
	public void testCalculateOne() {
		ListData data = new ListData();
		IListItem item = new ListItem(ITEM_NAME, 5, 7);
		data.addItem(item);

		checkSpreadCalculation(data, item);
	}
	
	@Test
	public void testCalculateThree() {
		ListData data = new ListData();
		IListItem item = new ListItem(ITEM_NAME, 5, 7);
		data.addItem(item);
		IListItem item2 = new ListItem(ITEM2_NAME, 5, 5.1);
		data.addItem(item2);
		IListItem item3 = new ListItem(ITEM3_NAME, 1, 10);
		data.addItem(item3);

		checkSpreadCalculation(data, item2);
	}

	private void checkSpreadCalculation(ListData data, IListItem expectedItem) {
		DayWithMinimalSpread spread = new DayWithMinimalSpread(data);
		
		IListItem minimalSpreadItem = spread.getItemWithMinimalSpread();
		
		Assert.assertNotNull("Not null item",minimalSpreadItem);
		Assert.assertEquals("Should be same item name", expectedItem.getName(), minimalSpreadItem.getName());
	}
	
	@Test
	public void testProcessWeatherFile(){
		DayWithMinimalSpread minimalSpread = new DayWithMinimalSpread(new WeatherParser(new File("resources/weather.dat")).getData());
		
		IListItem itemWithMinimalSpread = minimalSpread.getItemWithMinimalSpread();
		assertEquals("item name","14",itemWithMinimalSpread.getName());
	}
	
	@Test
	public void testProcessFootballFile(){
		DayWithMinimalSpread minimalSpread = new DayWithMinimalSpread(new FootballParser(new File("resources/football.dat")).getData());
		
		IListItem itemWithMinimalSpread = minimalSpread.getItemWithMinimalSpread();
		assertEquals("item name","Aston_Villa",itemWithMinimalSpread.getName());
	}
}
