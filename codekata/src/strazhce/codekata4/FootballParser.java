package strazhce.codekata4;

import java.io.File;

public class FootballParser extends BaseParser {

	public FootballParser(File file) {
		lines = FileUtils.readFileToList(file);
	}

	@Override
	protected String getPatternForDataLines() {
		return "   [\\d|\\s]\\d\\.";
	}

	@Override
	public ListItem parseLine(String line) {
		String name = line.substring(7, 23).trim();
		int forTeam = Integer.parseInt(line.substring(43, 45));
		int againstTeam = Integer.parseInt(line.substring(50, 52));
		return new ListItem(name, againstTeam, forTeam);
	}

}
