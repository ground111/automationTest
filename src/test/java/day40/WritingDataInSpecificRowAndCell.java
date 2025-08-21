package day40;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataInSpecificRowAndCell {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile_dynamic2.xlsx"); // file doesn't exist so it will create file

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("dynamic_data_2"); // create a new sheet(use getSheet if sheet already exists)
		
		XSSFRow row3 = sheet.createRow(3);
		XSSFCell cell3 = row3.createCell(3);
		cell3.setCellValue("Welcome");
		

			workbook.write(file);
			workbook.close();
			file.close();
		
		System.out.println("File created");
	}	

}
