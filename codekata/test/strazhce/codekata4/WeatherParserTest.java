package strazhce.codekata4;

import java.io.File;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class WeatherParserTest {

	private static final String FIRST_LINE_START = "   1  88";
	private static final String LAST_LINE_START = "  30  90";
	private static final String TESTLINE = "  26  97*   64    81          70.4       0.00 H       050  5.1 200  12  4.0 107 45 1014.9";

	@Test
	public void testGetWeatherItemsText() {
		WeatherParser parser = createParser();

		List<String> itemsText = parser.getItemsText();

		Assert.assertEquals("Number of items", 30, itemsText.size());
		checkStartOfLine(FIRST_LINE_START, itemsText.get(0));
		checkStartOfLine(LAST_LINE_START, itemsText.get(itemsText.size() - 1));

	}

	private WeatherParser createParser() {
		File file = new File("resources/weather.dat");
		WeatherParser parser = new WeatherParser(file);
		return parser;
	}

	@Test
	public void testParseLine() {
		WeatherParser parser = createParser();
		ListItem item = parser.parseLine(TESTLINE);

		Assert.assertEquals("Day", "26", item.getName());
		Assert.assertEquals("Min", 64, item.getLowValue(), 0);
		Assert.assertEquals("Max", 97, item.getHighValue(), 0);
	}

	@Test
	public void testGetWeatherData() {
		WeatherParser parser = createParser();
		ListData data = parser.getData();

		Assert.assertEquals("Number of items", 30, data.size());
		Assert.assertEquals("First day number", "1", data.get(0).getName());
	}

	private void checkStartOfLine(String startOfLine, String item) {
		Assert.assertEquals("Line not starts with " + startOfLine, startOfLine, item.substring(0, startOfLine.length()));
	}
}
