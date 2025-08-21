package day40;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {

		
		//FileInputStream file  = new FileInputStream("C:\\workspaces\\seleniumwebdriver\\seleniumwebdriver\\testdata\\data.xlsx");
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testdata\\data.xlsx")  ;
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet =  workbook.getSheet("Sheet1");
		//XSSFSheet sheet = workbook.getSheetAt(0); //will do same thing as above stmt, using index of sheet instead of name
		
		int total_rows  = sheet.getLastRowNum();
		int total_cells = sheet.getRow(1).getLastCellNum();
		
		System.out.println("Rows"+ " " + total_rows); //counting rows from 0
		System.out.println("Cells in each row" + " " + total_cells); //counting cells from 1
		
		
		for (int r=0; r<=total_rows;r++)
		{
			
			XSSFRow current_row = sheet.getRow(r);
			
			for (int c=0; c<total_cells ; c++)
			{
				XSSFCell cell = current_row.getCell(c);
				System.out.print(cell.toString() + "\t");
			}
			System.out.println();
		}
		
		workbook.close(); // to clear memory which was occupied by opening a workbook
		file.close(); // to clear memory which was occupied by opening a file
	}	

}
