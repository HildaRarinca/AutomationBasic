import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest {
    WebDriver driver;
    public int initialTableSize = 0;
    String firstName = "Firicel";
    String lastName = "Celentano";
    String userEmail = "test@test.com";
    String age = "25";
    String salary = "27500";
    String department = "testing";

    @Test
    public void webTableTest() {
        openBrowser();
        chooseMenu();
        chooseSubMenu();
        getTableSize();
        clickToAddNewRecord();
        fillFormValues();
        validateThatNewRecordsAreAddedProperly();
    }

    // facem o metoda care deschide un browser
    public void openBrowser() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
    }

    // facem o metoda care alege un meniu
    public void chooseMenu() {
        // identificam meniul dorit si facem click pe el
        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        // facem scroll pana in dreptul elementului pe care vrem sa il actionam
        scrollIntoElement(elementsMenu);
        elementsMenu.click();
    }

    // facem o metoda care sa faca scroll
    public void scrollIntoElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // facem o metoda care sa selecteze submeniul
    public void chooseSubMenu() {
        WebElement webTablesSubMenu = driver.findElement((By.xpath("//span[text()='Web Tables']")));
        webTablesSubMenu.click();
    }
// facem o metoda care sa ia numarul initial de randuri din tabel

    public int getTableSize() {
        List<WebElement> tableRowsList = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        initialTableSize = tableRowsList.size();
        System.out.println("Numarul initial de randuri in tabel este: " + initialTableSize);
        return initialTableSize;
    }

    // face, o metoda care sa faca click pe adaugare rand nou in tabel
    public void clickToAddNewRecord() {
        WebElement addNewRecordButton = driver.findElement(By.id("addNewRecordButton"));
        addNewRecordButton.click();
    }

    // facem o metoda care sa completeze tpate campurile din formular
    public void fillFormValues() {
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        firstNameField.sendKeys(firstName);
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.sendKeys(lastName);
        WebElement userEmailField = driver.findElement(By.id("userEmail"));
        userEmailField.sendKeys(userEmail);
        WebElement ageField = driver.findElement(By.id("age"));
        ageField.sendKeys(age);
        WebElement salaryField = driver.findElement(By.id("salary"));
        salaryField.sendKeys(salary);
        WebElement departmentField = driver.findElement(By.id("department"));
        departmentField.sendKeys(department);
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
    }

    // facem o metoda care sa valideze ca am adaugat o intrare noua in tabel si sa verifice valorile pe care le-am dat
    public void validateThatNewRecordsAreAddedProperly(){
        List<WebElement> tableRowsList = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertTrue(tableRowsList.size() > initialTableSize , "There are no new entries in the table! , Initial table size: "+ initialTableSize +
                "is the same with actual table size: "+ tableRowsList.size());

        String actualTableValues = tableRowsList.get(tableRowsList.size()-1).getText();
        System.out.println("New record values are: " + actualTableValues);
        Assert.assertTrue(actualTableValues.contains(firstName), "First name value is not correct. Expected first name: " + firstName);
        Assert.assertTrue(actualTableValues.contains(lastName), "Last name value is not correct. Expected last name: " + lastName);
        Assert.assertTrue(actualTableValues.contains(userEmail), "User email is not correct. Expected user email: " + userEmail);
        Assert.assertTrue(actualTableValues.contains(age), "Age value is not correct. Expected age: " + age);
        Assert.assertTrue(actualTableValues.contains("111"), "Salary value is not correct. Expected salary value: " + salary);
        Assert.assertTrue(actualTableValues.contains(department), "Department value is not correct. Expected department value: " + department);
    }
}
// de facut din Elements>checkbox
