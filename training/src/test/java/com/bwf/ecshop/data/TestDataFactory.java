package com.bwf.ecshop.data;
/**
 * ���ݹ���������������
 * @author jlt
 *
 */

import org.testng.annotations.DataProvider;

import com.bwf.framework.utils.ReadExcel;

public class TestDataFactory {
	/*
	 * ����½�ṩ�û��������룬����ֵҲ��������ע����������
	 */
	@DataProvider(name="login_test_data")
	public static Object[][] getTestData(){
		/*return new Object[][] {
			{"liudao001","123456","��¼�ɹ�"},
			{"liudao001","111111","�û������������"},
			{"liudao","123456","�û������������"},
			{"","123456","�û�������Ϊ��"},
			{"liudao001","","��¼���벻��Ϊ��"}
			
		};*/
		return ReadExcel.getDataFromExcel("LoginTestData.xlsx", "login");
	}
	/**
	 * ��ע���ṩ�û���,email,����,ȷ������,�ֻ�.����ֵҲ������.
	 * @return
	 */
	@DataProvider(name="registerTestData_tips")
	public static Object[][] getRegisterTestData_tips(){ 
		return ReadExcel.getDataFromExcel("LoginTestData.xlsx", "register"); 
	}
	@DataProvider(name="registerTest_success")
	public static Object[][] getRegisterTestData(){
		return ReadExcel.getDataFromExcel("LoginTestData.xlsx", "Sheet3");
	}     
	
}
