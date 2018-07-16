package com.action.pechatka_develop;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReaderExcel {
    public static String boLoginFromFile = "";
    public static String boPasswordFromFile = "";
    private File file = new File("e:\\sagitt\\work\\files for selenium\\dev_authset\\auth_set.xlsx");
    public static void main(String[] args) {
        ReaderExcel readerExcel = new ReaderExcel(); // получаю- сначала объект так называемой рабочей книги excel, инициализируя его объектом FileInputStream, открывающим поток ввода связанный с моим файлом
        readerExcel.getDataExcel("list1","admin"); //  вызываю у Workbook метод getSheet(sheetName) и таким образом получаю уже объект нужного листа рабочей книги

        System.out.println("login is: "+boLoginFromFile +" and password is: "+ boPasswordFromFile);
    }
    public void readExcel(String sheetName, String boUserRole) throws IOException {
        /*Создание объекта FileInputStream требует наличия обработчика исключений.
        Я поручу это методу, который будет вызывать readExcel с помощью оператора throws в сигнатуре метода readExcel:
        throws IOException*/
        XSSFWorkbook workbook =  new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet sheet = workbook.getSheet(sheetName);

        /*Доступ к строкам таблицы происходит по индексу начиная с «0».
        Чтобы не вывалиться за пределы таблицы в цикле стоит ограничение индекса r<sheet.getLastRowNum()+1.*/
        for(int r=0; r<sheet.getLastRowNum()+1; r++) {
            XSSFRow row = sheet.getRow(r); //последовательно получаю строки таблицы вызывая у объекта Sheet метод getRow
            for (int c=0; c<row.getLastCellNum(); c++) {
                if(row.getCell(c).getStringCellValue().equals(boUserRole)){
                    boLoginFromFile = row.getCell(c+1).getStringCellValue();
                    boPasswordFromFile = row.getCell(c+2).getStringCellValue();
                    break;
                }
                break;
            }
        }
        workbook.close();
    }
    public static String getBOLoginFromFile(){
        return boLoginFromFile;
    }
    public static String getBOPasswordFromFile(){
        return boPasswordFromFile;
    }
    private void getDataExcel(String sheet, String boUserRole) {
        try {
            readExcel(sheet, boUserRole);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
