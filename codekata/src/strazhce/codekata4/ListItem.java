package strazhce.codekata4;

public class ListItem  {

	private String name;
	private double lowValue;
	private double highValue;

	public ListItem(String name, double minTemp, double maxTemp) {
		super();
		this.name = name;
		this.lowValue = minTemp;
		this.highValue = maxTemp;
	}

	public String getName() {
		return name;
	}

	public double getLowValue() {
		return lowValue;
	}

	public double getHighValue() {
		return highValue;
	}

	public double getSpread() {
		return Math.abs(highValue - lowValue);
	}

}
