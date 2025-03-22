package org.example;


import Common.CommonHelper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GetDataFromTheExcel {
    public static void main(String[] args) {
        CommonHelper common = new CommonHelper();
        int size = common.getDataFromExcell("./Test.xlsx", "Data").size();
        for (int i = 1; i <= size; i++) {
            System.out.println(common.getDataFromExcell("./Test.xlsx", "Data").get(i));
        }
    }
}