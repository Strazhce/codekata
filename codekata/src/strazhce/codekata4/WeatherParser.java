package strazhce.codekata4;

import java.io.File;
import java.util.List;

public class WeatherParser extends BaseParser {

	public WeatherParser(File file) {
		lines = FileUtils.readFileToList(file);
	}

	public ListItem parseLine(String testline) {
		int dayNumber = Integer.parseInt(testline.substring(2, 4).trim());
		double maxTemp = Double.parseDouble(testline.substring(6, 8).trim());
		double minTemp = Double.parseDouble(testline.substring(12, 14).trim());

		return new ListItem(Integer.toString(dayNumber), minTemp, maxTemp);
	}

	protected String getPatternForDataLines() {
		return "^  (\\d|\\s)\\d  \\d\\d";
	}

}
