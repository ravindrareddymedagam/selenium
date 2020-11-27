package com.org.Tools;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class CommonAPI {
	public String readProp(String a_key) throws Exception {
		try {
			String w_value = "";
			Properties w_prop = new Properties();
			InputStream w_input = null;
			System.out.println(System.getProperty("user.dir"));
			w_input = new FileInputStream(System.getProperty("user.dir") + "Resources//system.properies");
			w_prop.load(w_input);
			w_value = w_prop.getProperty(a_key);

			return w_value;

		} catch (Exception e) {
			throw e;
		}
	}

}
