package utilities;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExcelOutput {
	String name;
	String price;
	String quantity;
	String total;
	String browser;
	public ExcelOutput(String name, String price, String quantity, String total, String browser) {
		super();
		this.name=name;
		this.price=price;
		this.quantity=quantity;
		this.total=total;
		this.browser=browser;
	}
	public void setData() throws IOException{
		String pathString = ".\\testdata\\TestOutputData.xlsx";
		String sheetName = "Sheet1";
		ExcelUtility utility = new ExcelUtility(pathString);
		int totalrows=utility.getRowCount(sheetName);	
		int insertIndexRow=totalrows+1;
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		utility.setCellData(sheetName, insertIndexRow, 0, timestamp);
		utility.setCellData(sheetName, insertIndexRow, 1, name);
		utility.setCellData(sheetName, insertIndexRow, 2, price);
		utility.setCellData(sheetName, insertIndexRow, 3, quantity);
		utility.setCellData(sheetName, insertIndexRow, 4, total);
		utility.setCellData(sheetName, insertIndexRow, 5, browser);
		
		
	}
}
