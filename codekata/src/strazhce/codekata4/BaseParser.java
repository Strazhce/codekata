package strazhce.codekata4;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public abstract class BaseParser {

	protected ArrayList<String> lines;

	public BaseParser() {
		super();
	}

	protected abstract String getPatternForDataLines();

	protected List<String> getItemsText() {
		ArrayList<String> result = new ArrayList<String>();
		Pattern teamResultPattern = Pattern.compile(getPatternForDataLines());
		for (String line : lines) {
			if (teamResultPattern.matcher(line).find()) {
				result.add(line);
			}
		}
		return result;
	}

	public ListData getData() {
		ListData result = new ListData();
		List<String> teamItemsText = getItemsText();
		for (String itemText : teamItemsText) {
			result.addItem(parseLine(itemText));
		}
		return result;
	}

	public abstract ListItem parseLine(String line);

}