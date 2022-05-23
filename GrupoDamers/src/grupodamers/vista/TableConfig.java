package grupodamers.vista;

public class TableConfig {
	
	private double layoutX;
	private double layoutY;
	private String[] columns;
	private double width;
	private double height;
	private double[] columnWidth;

	public TableConfig(double x, double y, String[] columns, double width, double height) {
		this.setLayoutX(x);
		this.setLayoutY(y);
		this.setColumns(columns);
		this.setWidth(width);
		this.setHeight(height);
	}
	
	public TableConfig(double x, double y, String[] columns, double width, double height, double[] columnWidth) {
		this.setLayoutX(x);
		this.setLayoutY(y);
		this.setColumns(columns);
		this.setWidth(width);
		this.setHeight(height);
		this.setColumnWidth(columnWidth);
	}

	public double getLayoutX() {
		return layoutX;
	}

	public void setLayoutX(double layoutX) {
		this.layoutX = layoutX;
	}

	public double getLayoutY() {
		return layoutY;
	}

	public void setLayoutY(double layoutY) {
		this.layoutY = layoutY;
	}

	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double[] getColumnWidth() {
		return columnWidth;
	}

	public void setColumnWidth(double[] columnWidth) {
		this.columnWidth = columnWidth;
	}
	
	

}
