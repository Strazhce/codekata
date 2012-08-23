package strazhce.codekata4;

import java.util.Iterator;

public class DayWithMinimalSpread {

	private ListData data;

	public DayWithMinimalSpread(ListData data) {
		this.data = data;
	}

	public ListItem getItemWithMinimalSpread() {
		ListItem res;

		Iterator<ListItem> iterator = data.iterator();
		res = iterator.next();
		if (res == null) {
			return null;
		}

		while (iterator.hasNext()) {
			ListItem next = iterator.next();
			if (res.getSpread() > next.getSpread()) {
				res = next;
			}
		}

		return res;
	}

}
