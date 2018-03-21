package com.bwf.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * ReadExcelʹ��POI-XSSFʵ��2007�汾�Ժ�excel�ļ���ָ��sheetҳ���ݵĶ�ȡ
 * @author jlt
 */
public class ReadExcel {
	/**
	 * getDataFromExcel��̬�������ڶ�ȡ��resourcesĿ¼�µ�xlsx�ļ�ָ��ҳ�����ݣ���һ��
	 * ������Ϊͷ��Ϣ�������Զ�������
	 * @param excelFileName ��resources�µ�xlsx�ļ�������Ҫ·��
	 * @param sheetName �����ȡ���������ڵ�sheetҳ����
	 * @return ��������Ϊ��ά���鷵��
	 */
	public static Object[][] getDataFromExcel(String excelFileName,String sheetName){
		Object[][] obj = null;
		Workbook wb = null;
		//�������·���ж�ȡָ���ļ��������������
		InputStream resourceAsStream = ReadExcel.class.getClassLoader().getResourceAsStream(excelFileName);
		try {
			wb = new XSSFWorkbook(resourceAsStream);
			Sheet  sheet = wb.getSheet(sheetName);
			int lastRowNum = sheet.getLastRowNum();
			//��ȡ���һ���кţ���Ҫ-1
			int lastCellNum = sheet.getRow(lastRowNum).getLastCellNum();
			obj =new Object[lastRowNum][lastCellNum];
			for(int i=1;i<=lastRowNum;i++) {
				for(int j=0;j<lastCellNum;j++) {
					String str = sheet.getRow(i).getCell(j).getStringCellValue();
					if(str.equalsIgnoreCase("<Empty>")) {
						obj[i-1][j] = "";        
					}else {
						obj[i-1][j] = str;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				wb.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return obj;
	} 
}
