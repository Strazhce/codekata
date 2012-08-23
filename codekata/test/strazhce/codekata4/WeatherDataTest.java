package strazhce.codekata4;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class WeatherDataTest {

	@Test
	public void testEmpty() {
		Iterator<WeatherItem> iterator = new WeatherData().iterator();
		Assert.assertNotNull("Iterator is null", iterator);
		doesntHaveMoreItems(iterator);
	}

	private void doesntHaveMoreItems(Iterator<WeatherItem> iterator) {
		Assert.assertFalse("Shouldn't have any more items", iterator.hasNext());
	}

	@Test
	public void testSomeItems() {
		WeatherData data = new WeatherData();
		WeatherItem item = new WeatherItem(1, 0, 2);
		data.addItem(item);

		Iterator<WeatherItem> iterator = data.iterator();
		Assert.assertEquals("Should be same items", item, iterator.next());
		doesntHaveMoreItems(iterator);

		Assert.assertEquals("Size", 1, data.size());
		data.addItem(new WeatherItem(5, 3, 5));
		Assert.assertEquals("Size", 2, data.size());
	}

}
