package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class AlertHandle {
    ChromeDriver driver;
    public AlertHandle()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }
     //Handle alert in W3school
     public void testCase08() throws InterruptedException{
        // 1. Launch Browser (Chrome) :ChromeDriver()
        // 1.2 Maximize Window :driver.windows().manage().maximize();
        // 1.5 Handle Sync issue using implicitlyWait() :driver.windows().timeouts().implicitlyWait(30,TimeUnit.SECONDS)
        // 2. Load URL  https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
        // 3. wait for 10 second 
        Thread.sleep(1000); 
        // 4. switch to result iframe Using Locator "ID" "iframeResult" | driver.switchTo(driver.findElementsById("iframeResult"));
        driver.switchTo().frame("iframeResult");
        // 5. click on the try it button Using Locator "XPath" "/button[@onclick='myFunction()']" 
        driver.findElementByXPath("*//button[text()='Try it']").click();
        // 6. switch to alert   driver.switchTo().alert()
        Alert alertObj=driver.switchTo().alert();
        System.out.println(alertObj.getText());
        alertObj.sendKeys("priyanka Sonawane");
        alertObj.accept();
        // 7. print the text Using Locator "ID" "demo" gtText()
        System.out.println(driver.findElementById("demo").getText());

        // 8. switch to parent  driver.switchTo().parentFrame()
        driver.switchTo().parentFrame();
        
    }
}
