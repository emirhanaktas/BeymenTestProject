package org.example;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        //System.out.println( "Hello World!" );

       // System.setProperty("webdriver.chrome.driver", "/Users/appcentappcent/Documents/selenium libraries/libraries/chromedriver/chromedriver");
       // WebDriver driver = new ChromeDriver();
      //  driver.get("https://www.beymen.com");

        File excelFile = new File("/Users/appcentappcent/Documents/BeymenTest.xlsx");

        FileInputStream fileInputStreams = new FileInputStream(excelFile);

        XSSFWorkbook xsf = new XSSFWorkbook(fileInputStreams);

        XSSFSheet sheet = xsf.getSheetAt(0);

        String entrySort = sheet.getRow(0).getCell(0).getStringCellValue();
        String entryGomlek = sheet.getRow(0).getCell(1).getStringCellValue();

        System.out.println(entrySort);
        System.out.println(entryGomlek);

    }
}
