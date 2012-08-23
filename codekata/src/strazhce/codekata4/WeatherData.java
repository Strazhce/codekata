package strazhce.codekata4;

import java.util.Iterator;
import java.util.LinkedList;

public class WeatherData implements Iterable<WeatherItem>{

	private LinkedList<WeatherItem> items = new LinkedList<WeatherItem>();

	public void addItem(WeatherItem weatherItem){ 
		items.add(weatherItem);
	}

	public Iterator<WeatherItem> iterator() {
		return items.iterator();
	}

	public int size() {
		return items.size();
	}

	public WeatherItem get(int i) {
		return items.get(i);
	}

}
