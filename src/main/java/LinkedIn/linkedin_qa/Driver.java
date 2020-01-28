package LinkedIn.linkedin_qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver 
{
	private static WebDriver driver = null;
	
	public Driver(){}
	
	public static WebDriver getDriver()
	{
		String cwd = System.getProperty("user.dir");
		String path = cwd+"/lib/chromedriver";
		System.setProperty("webdriver.chrome.driver", path);
		driver=new ChromeDriver();
		return driver;
	}
}
