package LinkedIn.linkedin_qa;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Linkedin status post testing.
 * 
 * @author Sadia Irshad
 */
public class StatusTest 
{
	/**
	 * This test posts only textual content
	 * @throws InterruptedException
	 */
	@Test
	public void test1() throws InterruptedException
	{
		WebDriver c= Driver.getDriver();
		c.get("https://www.linkedin.com");
		c.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		c.manage().window().maximize();  

		c.findElement(By.cssSelector("input[name='session_key']")).sendKeys("sid@quantumcph.com");
		c.findElement(By.cssSelector("input[name='session_password']")).sendKeys("si01000001");
		c.findElement(By.cssSelector(".sign-in-form__submit-btn")).click();
		c.findElement(By.cssSelector("button[data-control-name=\"share.sharebox_focus\"]")).click();
		String jScript = "var myList = document.querySelector('.mentions-texteditor__content').innerHTML=\"Hello\";"; 
			JavascriptExecutor executor = (JavascriptExecutor)c;
			executor.executeScript(jScript);

		c.findElement(By.cssSelector("button[data-control-name='share.visibility_button']")).click();
		TimeUnit.SECONDS.sleep(2);
		c.findElement(By.cssSelector("button[data-control-name='share.change_visibility_connections_only']")).click();
		List<WebElement> wes = c.findElements(By.cssSelector("button[data-control-name='share.change_visibility_close']"));
		wes.get(1).click();

		c.findElement(By.cssSelector("button[data-control-name='share.post']")).click();
	}
}
