package lib;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ExcelDataConfig {
	
	//Global variable to use in different method
	HSSFWorkbook wb;
	HSSFSheet sheetN;
	
	public ExcelDataConfig(String excelPath)
	{
		try {
			File src = new File(excelPath);
			
			FileInputStream fis = new FileInputStream(src);
			
			//load excel sheet (total workbook)
			 wb = new HSSFWorkbook(fis);

			
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				
	}
	
	public String getData (int sheetNumber, int row, int column)
	{
		sheetN = wb.getSheetAt(sheetNumber);
		
		DataFormatter formatter = new DataFormatter();
		
		String data = formatter.formatCellValue(sheetN.getRow(row).getCell(column));
		//String data = sheetN.getRow(row).getCell(column).getStringCellValue().toString();
		return data;
	}
	
	public int getRowCount(int sheetIndex)
	{
		try {
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row = row + 1;
		return row;		
	} catch (Exception e) {
		System.out.println(e.getMessage());
		
	}
		return sheetIndex;
		
	}
	

}
