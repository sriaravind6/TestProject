package org.example;


import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.text.NumberFormat;
import java.time.Duration;
import java.util.function.Function;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class WriteDataExcel {
    public static void main(String[] args) throws Exception {
        XSSFWorkbook createWorkbook = new XSSFWorkbook();
        XSSFSheet createSheet = createWorkbook.createSheet("Data");
        CellStyle style = createWorkbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        int k = 0;
        for(int i=0;i<10;i++){
            XSSFRow row = createSheet.createRow(i);
            for (int j = 0; j < 10; j++) {
                XSSFCell cell =row.createCell(j);
                cell.setCellStyle(style);
                cell.setCellValue(++k);
            }
        }
        createWorkbook.write(new FileOutputStream(new File("./sample.xlsx")));
        createWorkbook.close();

        FileInputStream fis = new FileInputStream(new File("./sample.xlsx"));
        XSSFWorkbook readWorkbook = new XSSFWorkbook(fis);
        XSSFSheet readSheet = readWorkbook.getSheetAt(0);
        int rowCount = readSheet.getLastRowNum();
        int colCount = readSheet.getRow(0).getLastCellNum();
        for(int i=0;i<rowCount;i++){
            XSSFRow row = readSheet.getRow(i);
            for(int j=0;j<colCount;j++){
                XSSFCell cell = row.getCell(j);
                System.out.println(cell.getCellType());
//                System.out.print(cell+" ");
            }
            System.out.println();
        }
    }
}