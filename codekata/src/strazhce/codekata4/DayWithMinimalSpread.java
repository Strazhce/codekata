package strazhce.codekata4;

import java.util.Iterator;

public class DayWithMinimalSpread {

	private WeatherData data;

	public DayWithMinimalSpread(WeatherData data) {
		this.data = data;
	}

	public WeatherItem getItemWithMinimalSpread() {
		WeatherItem res;

		Iterator<WeatherItem> iterator = data.iterator();
		res = iterator.next();
		if (res == null) {
			return null;
		}

		while (iterator.hasNext()) {
			WeatherItem next = iterator.next();
			if (res.getTempSpread() > next.getTempSpread()) {
				res = next;
			}
		}

		return res;
	}

}
