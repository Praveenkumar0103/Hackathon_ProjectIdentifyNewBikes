package utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static String[] readData(String sheetName,int row) throws IOException {
	
		String path = "C:\\Users\\2303657\\eclipse-workspace\\IdentifyNewBikes\\Testdata\\Zigwheels.xlsx";
		FileInputStream file = new FileInputStream(path);
	    @SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(file);
	    XSSFSheet worksheet = workbook.getSheet(sheetName);        
	    int cellNo = worksheet.getRow(1).getLastCellNum();
        String cellValue[] = new String[cellNo];
        XSSFRow cRow = worksheet.getRow(row);
	        for(int c=0; c<cellNo; c++)
	        {
	        	cellValue[c] = String.valueOf(cRow.getCell(c));
	        }
		return cellValue;
	}
	
	
	public void writeData(String sheetName,  List<String> a,int rowNo, int colNo) throws IOException {
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testData\\Data.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook=new XSSFWorkbook(file); 
		if(workbook.getSheetIndex(sheetName)==-1) {
			workbook.createSheet(sheetName);
		}
		
		XSSFSheet sheet = workbook.getSheet(sheetName);		 
		for(int i = rowNo; i<a.size(); i++) {
					
			if(sheet.getRow(i)==null)
			{
				sheet.createRow(i);
			}
			XSSFRow row =sheet.getRow(i);   
			
			row.createCell(colNo).setCellValue(a.get(i));
						
		}
		 
		FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir")+"\\testData\\Data.xlsx");
		workbook.write(fo);		
		file.close();
		fo.close();

	}
	
	
	
	
	
	
 
}
