package strazhce.codekata4;

import java.io.File;

public class PartOneRunner {
	public static void main(String[] args) {
		DayWithMinimalSpread minimalSpread = new DayWithMinimalSpread(new WeatherParser(new File("resources/weather.dat")).getWeatherData());
		
		IListItem itemWithMinimalSpread = minimalSpread.getItemWithMinimalSpread();
		
		System.out.println(itemWithMinimalSpread.getName());
	}
}
