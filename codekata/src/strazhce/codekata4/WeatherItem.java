package strazhce.codekata4;

public class WeatherItem {

	private int dayNumber;
	private double minTemp;
	private double maxTemp;

	public WeatherItem(int dayNumber, double minTemp, double maxTemp) {
		super();
		this.dayNumber = dayNumber;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
	}

	public int getDayNumber() {
		return dayNumber;
	}

	public double getMinTemp() {
		return minTemp;
	}

	public double getMaxTemp() {
		return maxTemp;
	}

	public double getTempSpread() {
		return maxTemp-minTemp;
	}
}
