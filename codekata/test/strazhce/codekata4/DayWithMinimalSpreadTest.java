package strazhce.codekata4;

import junit.framework.Assert;

import org.junit.Test;

public class DayWithMinimalSpreadTest {

	@Test
	public void testCalculateOne() {
		ListData data = new ListData();
		ListItem item = new ListItem(1, 5, 7);
		data.addItem(item);

		checkSpreadCalculation(data, item);
	}
	
	@Test
	public void testCalculateThree() {
		ListData data = new ListData();
		ListItem item = new ListItem(1, 5, 7);
		data.addItem(item);
		ListItem item2 = new ListItem(2, 5, 5.1);
		data.addItem(item2);
		ListItem item3 = new ListItem(3, 1, 10);
		data.addItem(item3);

		checkSpreadCalculation(data, item2);
	}

	private void checkSpreadCalculation(ListData data, ListItem expectedItem) {
		DayWithMinimalSpread spread = new DayWithMinimalSpread(data);
		
		IListItem minimalSpreadItem = spread.getItemWithMinimalSpread();
		
		Assert.assertNotNull("Not null item",minimalSpreadItem);
		Assert.assertEquals("Should be same day", expectedItem.getName(), minimalSpreadItem.getName());
	}
}
