package com.bwf.framework.utils;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
/**
 * ��װ��RemoteWebDriver���̳���RemoteWebDriver����дfindElements��findElement������ʵ��Ԫ�ز���
 * ʱ����־��¼
 * @author jlt
 *
 */
public class WrappedRemoteWebDriver  extends RemoteWebDriver{
	private Logger logger = LogManager.getLogger();
	
	public WrappedRemoteWebDriver(URL remoteAddress,Capabilities capabilities) {
		super(remoteAddress,capabilities);	
	}
	@Override
	protected List<WebElement> findElements(String by,String using){
		List<WebElement> elements = null;
		try {
			elements = super.findElements(by, using);
			logger.info("ͨ��"+by+"��������"+using+"Ԫ�أ����ҵ�"+elements.size()+"��");
		} catch ( Exception e) {
			logger.error("ͨ��"+by+"��������"+using+"Ԫ��ʱ�����쳣��ԭ��"+e.getMessage());
		}
		return elements;
	}
	@Override
	protected WebElement findElement(String by,String using){
		WebElement element = null;
		try {
			element = super.findElement(by, using);
			logger.info("ͨ��"+by+"��������"+using+"Ԫ�أ����ҵ�");
		} catch ( Exception e) {
			logger.error("ͨ��"+by+"��������"+using+"Ԫ��ʱ�����쳣��ԭ��"+e.getMessage());
		}
		return element;
	}
	/**
	 * �Զ����ͼ���ļ���������ָ����Ŀ¼�С�
	 * @param fileName �ļ���
	 */
	public void takeScreenShot(String fileName) {
		File screenShot = ((TakesScreenshot) this). getScreenshotAs(OutputType.FILE);
		//����Ŀ¼
		File directory = new File("screenshots");
		//�ж�Ŀ¼�Ƿ���ڻ��߲���Ŀ¼,��ô����Ŀ¼
		if(!directory.exists() || !directory.isDirectory()) {
			logger.info("screenshotsĿ¼�����ڣ�������Ŀ¼");
			directory.mkdir();
		}
		//�ļ��浽���Ŀ¼��
		File file = new File(directory,fileName);
		screenShot.renameTo(file);
		logger.info("��������ɹ���������"+file.getAbsolutePath());
	}
}
