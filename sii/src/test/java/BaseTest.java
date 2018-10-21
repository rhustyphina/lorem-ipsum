import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
     System.setProperty("webdriver.chrome.driver",
             "src\\files\\chromedriver.exe");
     ChromeOptions options = new ChromeOptions();
     options.addArguments("start-maximized");
     driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit(); //zamyka chrome i chrome drivera
        // driver.close(); - zamyka tylko chrome - więc jak się kolejne testy uruchamiają, to będzie wiele razy w procesach chrome driver - do spr. Ctrl+Shift+Esc > Szczegóły
    }
}
