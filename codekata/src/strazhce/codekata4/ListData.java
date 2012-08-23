package strazhce.codekata4;

import java.util.Iterator;
import java.util.LinkedList;

public class ListData implements Iterable<IListItem>{

	private LinkedList<IListItem> items = new LinkedList<IListItem>();

	public void addItem(IListItem IListItem){ 
		items.add(IListItem);
	}

	public Iterator<IListItem> iterator() {
		return items.iterator();
	}

	public int size() {
		return items.size();
	}

	public IListItem get(int i) {
		return items.get(i);
	}

}
