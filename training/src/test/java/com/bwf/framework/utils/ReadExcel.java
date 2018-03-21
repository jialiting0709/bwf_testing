package com.bwf.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * ReadExcel使用POI-XSSF实现2007版本以后excel文件中指定sheet页数据的读取
 * @author jlt
 */
public class ReadExcel {
	/**
	 * getDataFromExcel静态方法用于读取在resources目录下的xlsx文件指定页的数据，第一行
	 * 数据作为头信息不读，自动跳过。
	 * @param excelFileName 在resources下的xlsx文件名不需要路径
	 * @param sheetName 所需读取的数据所在的sheet页名称
	 * @return 将数据作为二维数组返回
	 */
	public static Object[][] getDataFromExcel(String excelFileName,String sheetName){
		Object[][] obj = null;
		Workbook wb = null;
		//从类加载路径中读取指定文件，获得其输入流
		InputStream resourceAsStream = ReadExcel.class.getClassLoader().getResourceAsStream(excelFileName);
		try {
			wb = new XSSFWorkbook(resourceAsStream);
			Sheet  sheet = wb.getSheet(sheetName);
			int lastRowNum = sheet.getLastRowNum();
			//获取最后一行列号，需要-1
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
