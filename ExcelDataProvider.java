// ExcelDataProvider.java
package com.bookmyshow.utils;

import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
    
    @DataProvider(name = "movieBookingData")
    public Object[][] getMovieBookingData() throws IOException {
        File excelFile = new File("src/test/resources/testdata.xlsx");
        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("MovieBooking");
        
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();
        
        Object[][] data = new Object[rowCount-1][colCount];
        DataFormatter formatter = new DataFormatter();
        
        for(int i=1; i<rowCount; i++) {
            for(int j=0; j<colCount; j++) {
                data[i-1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
            }
        }
        
        workbook.close();
        fis.close();
        
        return data;
    }
}