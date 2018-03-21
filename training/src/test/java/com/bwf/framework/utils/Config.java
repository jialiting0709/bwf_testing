package com.bwf.framework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * ∂¡»°properties≈‰÷√Œƒº˛
 * @author jlt
 *
 */
public class Config {
	private Properties prop;
	public Config(String fileName) {
		prop  = new Properties();
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName);
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getConfig(String key) {
		return prop.getProperty(key);
	}
/*	public static void main(String[] args) {
		Config config = new Config("config.properties");
		String driver = config.getConfig("bwf.test.browser");
		System.out.println(driver);
	}*/
}
