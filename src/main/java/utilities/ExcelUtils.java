package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static Logger logger = Logger.getLogger(ExcelUtils.class);
	public static Workbook workbook;
	
	public static int getRowCountOfWorkbook(int sheetNo,String filePath) throws IOException{
		
		Sheet sheet = getWorkBook(filePath).getSheetAt(0);
		int iRowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		return iRowCount;
	}
	
	public static Workbook getWorkBook(String filePath) throws IOException{
		FileInputStream fis = new FileInputStream(filePath);
		if(StringUtils.substringAfter(filePath, ".").equals("xlsx")){
			workbook = new XSSFWorkbook(fis);
		}else{
			workbook = new HSSFWorkbook(fis);
		}
		return workbook;
	}
	
	public static String getCellData(int iRowNum,int iColumnNo,int iSheetNo,String filePath) throws IOException{
		
		Sheet sheet = getWorkBook(filePath).getSheetAt(iSheetNo);
		Cell cell = sheet.getRow(iRowNum).getCell(iColumnNo);
		String cellText = null;
		if(!(cell==null)){
			if(cell.getCellType()==CellType.BLANK){
				cellText = "";
			}else if(cell.getCellType()==CellType.STRING){
				cellText = cell.getStringCellValue();
			}else if(cell.getCellType()==CellType.NUMERIC){
				cellText = String.valueOf(cell.getNumericCellValue());
			}else if(cell.getCellType()==CellType.BOOLEAN){
				cellText = String.valueOf(cell.getBooleanCellValue());
			}
		}else{
			 logger.error("Cell is null");
		}
		
		return cellText;
	}
	
	public static void setCellValue(String[] sVal,int iColumnNo,int iSheetNo,String filePath) throws IOException{
		
		int rowCount = getRowCountOfWorkbook(0,filePath);
		workbook = getWorkBook(filePath);
		Sheet sheet = workbook.getSheetAt(iSheetNo);
		Row r0 = sheet.getRow(0);
		Row r = sheet.createRow(rowCount+1);
		for(int i=0;i<r0.getLastCellNum();i++){
			Cell cell = r.createCell(i);
			cell.setCellValue(sVal[i]);
		}
		
		FileOutputStream fos = new FileOutputStream(filePath);
		workbook.write(fos);
		fos.flush();
	}
	
	public static void getLatestDownloadedWorkbook(){
		String SDirPath = "C:\\Users\\"+System.getProperty("user.name")+"\\Downloads\\";
		File file = GenericUtils.getLatestFileFromDir(SDirPath);
		System.out.println(file.getAbsolutePath());
	}
}
