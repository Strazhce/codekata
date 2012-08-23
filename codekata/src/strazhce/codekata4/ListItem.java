package strazhce.codekata4;

public class ListItem implements IListItem {

	private int dayNumber;
	private double minTemp;
	private double maxTemp;

	public ListItem(int dayNumber, double minTemp, double maxTemp) {
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

	@Override
	public double getSpread() {
		return maxTemp - minTemp;
	}

	@Override
	public String getName() {
		return Integer.toString(dayNumber);
	}
}
