package strazhce.codekata4;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

import junit.framework.Assert;

import org.junit.Test;

public class FootballParserTest {

	private static final String FILENAME = "resources/football.dat";
	private static final int FILE_CORRECT_ITEMS = 20;
	private static final String FIRST_LINE_START = "    1. Arsenal";
	private static final String LAST_LINE_START = "   20. Leicester";
	private static final String TESTLINE = "   11. Southampton     38    12   9  17    46  -  54    45";

	@Test
	public void testGetWeatherItemsText() {
		BaseParser parser = createParser();

		List<String> itemsText = parser.getItemsText();

		Assert.assertEquals("Number of items", FILE_CORRECT_ITEMS, itemsText.size());
		checkStartOfLine(FIRST_LINE_START, itemsText.get(0));
		checkStartOfLine(LAST_LINE_START, itemsText.get(itemsText.size() - 1));

	}

	private BaseParser createParser() {
		File file = new File(FILENAME);
		BaseParser parser = new FootballParser(file);
		return parser;
	}

	@Test
	public void testParseLine() {
		BaseParser parser = createParser();
		ListItem item = parser.parseLine(TESTLINE);

		Assert.assertEquals("Name", "Southampton", item.getName());
		Assert.assertEquals("Low", 54, item.getLowValue(), 0);
		Assert.assertEquals("High", 46, item.getHighValue(), 0);
	}

	@Test
	public void testGetData() {
		BaseParser parser = createParser();
		ListData data = parser.getData();

		Assert.assertEquals("Number of items", FILE_CORRECT_ITEMS, data.size());
		Assert.assertEquals("First name", "Arsenal", data.get(0).getName());
		Assert.assertEquals("Last name", "Leicester", data.get(FILE_CORRECT_ITEMS-1).getName());
	}

	private void checkStartOfLine(String startOfLine, String item) {
		Assert.assertEquals("Line not starts with " + startOfLine, startOfLine, item.substring(0, startOfLine.length()));
	}
	
	@Test
	public void testRegex(){
		assertTrue(Pattern.compile("   \\d\\d\\.").matcher(TESTLINE).find());
//		assertTrue("   11. Southampton     38    12   9  17    46  -  54    45".matches(" "));
	}
}
