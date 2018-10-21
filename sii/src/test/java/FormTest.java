import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Random;


public class FormTest extends BaseTest {

    Random generator = new Random();

    public int randomize(int i) {
        int rndNumber = generator.nextInt(i);
        System.out.println("Randomed number: " + rndNumber);
        return rndNumber;
    }

    @Test
    public void firstTest() throws InterruptedException {
        driver.get("http://toolsqa.com/automation-practice-form/");

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Anna");

//        List<WebElement> names = driver.findElements (By.name("firstname"));
//        names.get(0).sendKeys("Anna");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Jabłońska");

        List<WebElement> sex = driver.findElements(By.cssSelector("input[id*='sex'")); //By.name("sex")
        sex.get(1).click();

        Assert.assertTrue(sex.get(1).isSelected());


        int i = randomize(6); //generator.nextInt(6);

        List<WebElement> yearsOfExp = driver.findElements(By.name("exp"));
        yearsOfExp.get(i).click();

        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("2018-10-21");

        i = randomize(1);

        List<WebElement> profession = driver.findElements(By.cssSelector("input[id*='profession']"));
        profession.get(i).click();

        WebElement uploadPhoto = driver.findElement(By.id("photo"));

        File photo = new File("src\\files\\selscreenshot.png");
        String absolutePathToPhoto = photo.getAbsolutePath();
        System.out.println("absolute path: " + absolutePathToPhoto);
        uploadPhoto.sendKeys(absolutePathToPhoto);

        WebElement downloadFile = driver.findElement(By.linkText("Test File to Download"));
        downloadFile.click();

        //check box

        //i = randomize(6);
        WebElement continentList = driver.findElement(By.id("continents"));
        Select continentSelect = new Select(continentList);
        int numberOfOptions = continentSelect.getOptions().size();
        i = randomize(numberOfOptions - 1);
        continentSelect.selectByIndex(i);
        // można też po nazwie kontynentu wyszukać


        WebElement commandsList = driver.findElement(By.id("selenium_commands"));
        Select seleniumCommandsSelect = new Select(commandsList);
        seleniumCommandsSelect.selectByVisibleText("Switch Commands");
        seleniumCommandsSelect.selectByVisibleText("WebElement Commands");

        WebElement buttonSubmit = driver.findElement(By.id("submit"));
        buttonSubmit.click();

        Thread.sleep(3000);
    }
}
