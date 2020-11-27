package com.org.Tools;

import java.util.HashMap;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager extends DriverManager {
	private ChromeDriverService m_chService;

	@Override
	protected void startService() {
		if (null == m_chService) {
			try {

				System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void stopService() {
		if (null != m_chService && m_chService.isRunning())
			m_chService.stop();
	}

	@Override
	protected void createDriver() {

		ChromeOptions w_options = new ChromeOptions();
		w_options.addArguments("--no-sandbox");
		w_options.addArguments("disable-features=NetworkService");
		// w_options.addArguments("headless");//to run on headless chrome browser on
		// linux.Comment this line when running on local machine
		w_options.setAcceptInsecureCerts(true);

		w_options.setCapability("enableNetwork", false);
		w_options.setCapability("enablePage", false);
		w_options.setUnhandledPromptBehaviour(null);
		w_options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		// w_options.addArguments("download.default_directory="+System.getProperty("user.dir")+"\\EWR_Downloads");

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", "downloads");
		w_options.setExperimentalOption("prefs", chromePrefs);
		w_options.addArguments("--test-type");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch blockFs
			e.printStackTrace();
		}
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(w_options);
	}

}
