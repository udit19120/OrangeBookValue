//package com.obv.qa.util;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.util.Calendar;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//
//import static org.apache.poi.ss.usermodel.CellType.STRING;
////import static org.apache.xmlbeans.impl.piccolo.xml.Piccolo.STRING;
//
//public class Xls_Reader {
//    public String path;
//    public FileInputStream fis = null;
//    public FileOutputStream fileOut = null;
//    private XSSFWorkbook workbook = null;
//    private XSSFSheet sheet = null;
//    private XSSFRow row = null;
//    private XSSFCell cell = null;
//
//    public Xls_Reader(String path) {
//
//        this.path = path;
//        try {
//            fis = new FileInputStream(path);
//            workbook = new XSSFWorkbook(fis);
//            sheet = workbook.getSheetAt(0);
//            fis.close();
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//    // returns the row count in a sheet
//    public int getRowCount(String sheetName) {
//        int index = workbook.getSheetIndex(sheetName);
//        if (index == -1)
//            return 0;
//        else {
//            sheet = workbook.getSheetAt(index);
//            int number = sheet.getLastRowNum() + 1;
//            return number;
//        }
//
//    }
//
//    // returns the data from a cell
//    public String getCellData(String sheetName, String colName, int rowNum) {
//        try {
//            if (rowNum <= 0)
//                return "";
//
//            int index = workbook.getSheetIndex(sheetName);
//            int col_Num = -1;
//            if (index == -1)
//                return "";
//
//            sheet = workbook.getSheetAt(index);
//            row = sheet.getRow(0);
//            for (int i = 0; i < row.getLastCellNum(); i++) {
//                if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
//                    col_Num = i;
//            }
//            if (col_Num == -1)
//                return "";
//
//            sheet = workbook.getSheetAt(index);
//            row = sheet.getRow(rowNum - 1);
//            if (row == null)
//                return "";
//            cell = row.getCell(col_Num);
//
//            if (cell == null)
//                return "";
//
//            if (cell.getCellType() == STRING)
//                return cell.getStringCellValue();
//            else
//                return cell.getRawValue();
//        } catch (Exception e) {
//
//            e.printStackTrace();
//            return "row " + rowNum + " or column " + colName + " does not exist in xls";
//        }
//    }
//
//
//    // returns true if data is set successfully else false
//    public boolean setCellData(String sheetName, String colName, int rowNum, String data) {
//        try {
//            fis = new FileInputStream(path);
//            workbook = new XSSFWorkbook(fis);
//
//            if (rowNum <= 0)
//                return false;
//
//            int index = workbook.getSheetIndex(sheetName);
//            int colNum = -1;
//            if (index == -1)
//                return false;
//
//            sheet = workbook.getSheetAt(index);
//
//            row = sheet.getRow(0);
//            for (int i = 0; i < row.getLastCellNum(); i++) {
//                // System.out.println(row.getCell(i).getStringCellValue().trim());
//                if (row.getCell(i).getStringCellValue().trim().equals(colName))
//                    colNum = i;
//            }
//            if (colNum == -1)
//                return false;
//
//            sheet.autoSizeColumn(colNum);
//            row = sheet.getRow(rowNum - 1);
//            if (row == null)
//                row = sheet.createRow(rowNum - 1);
//
//            cell = row.getCell(colNum);
//            if (cell == null)
//                cell = row.createCell(colNum);
//
//            cell.setCellValue(data);
//
//            fileOut = new FileOutputStream(path);
//
//            workbook.write(fileOut);
//
//            fileOut.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
//
//}