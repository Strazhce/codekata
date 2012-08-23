package strazhce.codekata4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class FileUtils {

	static ArrayList<String> readFileToList(File file) {
		ArrayList<String> lines = new ArrayList<String>();
		BufferedReader bufferedReader;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			while (bufferedReader.ready()) {
				lines.add(bufferedReader.readLine());
			}
			bufferedReader.close();
			return lines;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
