package day40;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile_dynamic1.xlsx"); // file doesn't exist so it will create file

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("dynamic_data"); // create a new sheet(use getSheet if sheet already exists)

		Scanner sc = new Scanner(System.in);
		System.out.println("How many rows do you want?");
		int num_rows =  sc.nextInt();
		System.out.println("How many cells per row");
		int num_cells = sc.nextInt();
		
		
		System.out.println("Enter table data");
		
		for(int r=0; r<=num_rows;r++)
		{
			 XSSFRow current_row =  sheet.createRow(r);
			
			for(int c=0;c<num_cells;c++)
			{
				XSSFCell cell = current_row.createCell(c);
				cell.setCellValue(sc.next());
				
			}
		}

			workbook.write(file);
			workbook.close();
			file.close();
		
		System.out.println("File created");
	}	

}
