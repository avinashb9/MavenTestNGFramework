package utilities;

import java.io.IOException;

public class Debug {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\Login.xlsx";
		System.out.println("CELL DATA: "+ExcelUtils.getCellData(1, 0, 0, filePath));
		ExcelUtils.setCellValue(new String[]{"avin","Test@12345","blank"}, 0, 0, filePath);
		System.out.println("CELL DATA: "+ExcelUtils.getCellData(2, 0, 0, filePath));*/
		
		ExcelUtils.getLatestDownloadedWorkbook();
	}

}
