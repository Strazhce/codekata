package strazhce.codekata4;

import java.util.Iterator;
import java.util.LinkedList;

public class ListData implements Iterable<ListItem>{

	private LinkedList<ListItem> items = new LinkedList<ListItem>();

	public void addItem(ListItem ListItem){ 
		items.add(ListItem);
	}

	public Iterator<ListItem> iterator() {
		return items.iterator();
	}

	public int size() {
		return items.size();
	}

	public ListItem get(int i) {
		return items.get(i);
	}

}
