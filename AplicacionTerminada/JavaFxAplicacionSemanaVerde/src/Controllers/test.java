package Controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class test {
	public static void main(String[] args) {
		Properties properties = new Properties();
		try {
			InputStream is = getClass().getResourceAsStream("/confi/app-config.properties");
			properties.load(is);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
