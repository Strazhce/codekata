package strazhce.codekata4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeatherParser {

	private static final int NUMBER_OF_DAYS = 30;
	private static final int LINE_NUMBER_START_OF_DAYS = 8;
	private ArrayList<String> lines = new ArrayList<String>();

	public WeatherParser(File file){
		BufferedReader bufferedReader;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			while (bufferedReader.ready()) {
				lines.add(bufferedReader.readLine());
			}
			bufferedReader.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}

	protected List<String> getWeatherItemsText() {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = LINE_NUMBER_START_OF_DAYS; i < LINE_NUMBER_START_OF_DAYS + NUMBER_OF_DAYS; i++) {
			list.add(lines.get(i));
		}
		return list;
	}

	public ListItem parseLine(String testline) {
		int dayNumber=Integer.parseInt(testline.substring(2, 4).trim());
		double minTemp=Double.parseDouble(testline.substring(6, 8).trim());
		double maxTemp=Double.parseDouble(testline.substring(12, 14).trim());
		
		return new ListItem(dayNumber, minTemp, maxTemp);
	}

	public ListData getWeatherData() {
		ListData data = new ListData();
		List<String> weatherItemsText = getWeatherItemsText();
		for (String itemText : weatherItemsText) {
			data.addItem(parseLine(itemText));
		}
		return data;
	}

}
