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
 * 包装的RemoteWebDriver，继承了RemoteWebDriver，重写findElements和findElement方法，实现元素查找
 * 时的日志记录
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
			logger.info("通过"+by+"方法查找"+using+"元素，已找到"+elements.size()+"个");
		} catch ( Exception e) {
			logger.error("通过"+by+"方法查找"+using+"元素时发生异常，原因"+e.getMessage());
		}
		return elements;
	}
	@Override
	protected WebElement findElement(String by,String using){
		WebElement element = null;
		try {
			element = super.findElement(by, using);
			logger.info("通过"+by+"方法查找"+using+"元素，已找到");
		} catch ( Exception e) {
			logger.error("通过"+by+"方法查找"+using+"元素时发生异常，原因"+e.getMessage());
		}
		return element;
	}
	/**
	 * 自定义截图的文件名，放在指定的目录中。
	 * @param fileName 文件名
	 */
	public void takeScreenShot(String fileName) {
		File screenShot = ((TakesScreenshot) this). getScreenshotAs(OutputType.FILE);
		//定义目录
		File directory = new File("screenshots");
		//判断目录是否存在或者不是目录,那么创建目录
		if(!directory.exists() || !directory.isDirectory()) {
			logger.info("screenshots目录不存在，创建该目录");
			directory.mkdir();
		}
		//文件存到这个目录下
		File file = new File(directory,fileName);
		screenShot.renameTo(file);
		logger.info("截屏保存成功，保存在"+file.getAbsolutePath());
	}
}
