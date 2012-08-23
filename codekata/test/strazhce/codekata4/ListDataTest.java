package strazhce.codekata4;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class ListDataTest {

	@Test
	public void testEmpty() {
		Iterator<IListItem> iterator = new ListData().iterator();
		Assert.assertNotNull("Iterator is null", iterator);
		doesntHaveMoreItems(iterator);
	}

	private void doesntHaveMoreItems(Iterator<?> iterator) {
		Assert.assertFalse("Shouldn't have any more items", iterator.hasNext());
	}

	@Test
	public void testSomeItems() {
		ListData data = new ListData();
		ListItem item = new ListItem(1, 0, 2);
		data.addItem(item);

		Iterator<IListItem> iterator = data.iterator();
		Assert.assertEquals("Should be same items", item, iterator.next());
		doesntHaveMoreItems(iterator);

		Assert.assertEquals("Size", 1, data.size());
		data.addItem(new ListItem(5, 3, 5));
		Assert.assertEquals("Size", 2, data.size());
	}

}
