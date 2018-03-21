package com.bwf.learning;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bwf.framework.utils.ReadExcel;

public class ReadExcelDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//����һ����ҵ��ָ��·��
		Workbook wb = new XSSFWorkbook(new FileInputStream(new File("F:\\eclipse-jee-oxygen-2-win32-x86_64\\workspace\\training\\src\\test\\resources\\LoginTestData.xlsx")));
		//��sheetҳ�����Ƶõ�sheet
		Sheet  sheet = wb.getSheet("Sheet1");
		//���һ�е����
		int lastRowNum = sheet.getLastRowNum();
		System.out.println(lastRowNum);
		//��ȡ���һ�е����һ����Ԫ��
		int lastCellNum = sheet.getRow(lastRowNum).getLastCellNum();
		System.out.println(lastCellNum);
		for(int i=0;i<=lastRowNum;i++) {
			for(int j=0;j<lastCellNum;j++) {
				System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+"\t");
			}
			System.out.println();
		}
		wb.close();
	}
}
