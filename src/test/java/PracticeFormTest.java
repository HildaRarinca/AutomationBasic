import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;


public class PracticeFormTest {

    WebDriver driver;

    @Test
    public void practiceFormTest(){

        driver = new ChromeDriver();

        //navigam catre pagina websitetului
        driver.get("https://demoqa.com/");

        //facem fereastra browserului maximaize
        driver.manage().window().maximize();

        //identificam meniul dorit si facem click pe el
        WebElement FormMeniu = driver.findElement(By.xpath("//h5[text() = 'Forms'] "));

        //facem scroll pana in dreptul elementului pe care vrem sa dam click
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", FormMeniu);

        //facem click pe meniul de mai sus
        FormMeniu.click();

        //identificam sub -meniul dorit si facem click pe el
        WebElement PracticeFormSubMenu = driver.findElement(By.xpath("//span[text() = 'Practice Form']"));
        PracticeFormSubMenu.click();

        //identificam elementele din fromular si facem actiuni corespunzatoare pe fiecare
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        String firstNameText = "Hilda";
        firstNameField.sendKeys(firstNameText);

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        String lastNameText = "Rarinca";
        lastNameField.sendKeys(lastNameText);

        WebElement emailField = driver.findElement(By.id("userEmail"));
        String emailText = "martonhilda94@gmail.com";
        emailField.sendKeys(emailText);

        WebElement genderMale = driver.findElement(By.xpath("//label[@for = 'gender-radio-1']"));
        WebElement genderFemale = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement genderOther = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        String genderValueText = "Female";
        List<WebElement> genderList = List.of(genderMale, genderFemale, genderOther); // o alta metoda de a declara o lista
        for (int i = 0; i < genderList.size(); i++) {
            if (genderList.get(i).getText().equals(genderValueText)) {
                genderList.get(i).click();
                break;
            }
        }

        WebElement mobilePhoneField = driver.findElement(By.id("userNumber"));
        String mobilePhoneText = "0755928530";
        mobilePhoneField.sendKeys(mobilePhoneText);

        WebElement dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirthInput.click();

        WebElement monthOfBirthElement = driver.findElement(By.xpath("//select[@class = 'react-datepicker__month-select']"));
        Select selectMonth = new Select(monthOfBirthElement);
        String monthValueText = "July";
        selectMonth.selectByVisibleText(monthValueText);

        WebElement yearOfBirthElement = driver.findElement(By.xpath("//select[@class = 'react-datepicker__year-select']"));
        Select selectYear = new Select(yearOfBirthElement);
        String yearValueText = "1994";
        selectYear.selectByVisibleText(yearValueText);

        List<WebElement> dayOfBirthList = driver.findElements(By.xpath("//div[contains(@class, 'react-datepicker__day')]"));
        String dayValueText = "31";
        for (int i = 0; i<dayOfBirthList.size(); i++){
            if (dayOfBirthList.get(i).getText().equals(dayValueText)){
                dayOfBirthList.get(i).click();
                break;
            }
        }

        // completam subject
        WebElement subjectInputElement = driver.findElement(By.id("subjectsInput"));
        String mathsSubjectText = "Maths";
        subjectInputElement.sendKeys(mathsSubjectText);
        subjectInputElement.sendKeys(Keys.ENTER);
        String physicsSubjectText = "Physics";
        subjectInputElement.sendKeys(physicsSubjectText);
        subjectInputElement.sendKeys(Keys.ENTER);

        js.executeScript("window.scrollBy(0,200)"); // asa facem scroll

        // selectam check box-urile de hobbies
        WebElement sportHobbyElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
        sportHobbyElement.click();
        WebElement readingHobbyElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));
        readingHobbyElement.click();
        WebElement musicHobbyElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']"));
        musicHobbyElement.click();
//        List<WebElement> hobbiesList = List.of(sportHobbyElement, musicHobbyElement, readingHobbyElement);
//        String sportHobbyText = "Sports";
//        String readingHobbyText = "Reading";
//        String musicHobbyText = "Music";
//        List<String> hobbyValueTextList = List.of(sportHobbyText, readingHobbyText, musicHobbyText);
//        for (String hobby : hobbyValueTextList) {
//            for (int i = 0; i < hobbiesList.size(); i++) {
//                if (hobbiesList.get(i).getText().equals(hobby)) {
//                    hobbiesList.get(i).click();
//                    break;
//                }
//            }
//        }

        // facem scroll
        js.executeScript("window.scrollBy(0,200)");

//      Aici am facut eu in fata si am gasit un alt element pt upload decat cel folosit cu colegii
//        WebElement pictureSelectElement = driver.findElement(By.xpath("//*[@id='userForm']/div[8]/div[2]/div/label"));
//        pictureSelectElement.click();

//      Uploadez o poza, un fisier pe site, care l-am downloadat si am dat un filepath
        WebElement uploadFileElement = driver.findElement(By.id("uploadPicture"));
        String pictureFilePath = "src/test/resources/Picture/TestImage.png";
        File file = new File(pictureFilePath);
        uploadFileElement.sendKeys(file.getAbsolutePath());

//      Identific elementul "Address Field" de pe pagina , dau click pe el si introduc textul "Targu Mures"
        WebElement addressField = driver.findElement(By.id("currentAddress"));
        String addressValueText = "Strada Imparatul Traian";
        addressField.sendKeys(addressValueText);

//      Aleg tara - statul din lista disponibila prin tastarea textului "NCR" si apoi apas tasta Enter
        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateValueText = "NCR";
        stateInputElement.sendKeys(stateValueText);
        stateInputElement.sendKeys(Keys.ENTER);

//      Aleg orasul din lista disponibila prin tastarea textului "Delhi" si apoi apas tasta Enter
        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityValueText = "Delhi";
        cityInputElement.sendKeys(cityValueText);
        cityInputElement.sendKeys(Keys.ENTER);

//      Apas butonul Submit
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // validam tabelul cu datele de intrare folosite

        // facem un hash map cu expected values
HashMap<String, String> expectedValues = new HashMap<>();
expectedValues.put("Student Name", firstNameText + " " + lastNameText);
expectedValues.put("Student Email", emailText);
expectedValues.put("Gender", genderValueText);
expectedValues.put("Mobile", mobilePhoneText);
expectedValues.put("Date of Birth", dayValueText + " " + monthValueText + "," + yearValueText);
expectedValues.put("Subjects", mathsSubjectText + ", " + physicsSubjectText);
//expectedValues.put("Hobbies", sportHobbyText + ", " + readingHobbyText + ", " + musicHobbyText);
//expectedValues.put("Picture", pictureFileText);
expectedValues.put("Address", addressValueText);
expectedValues.put("State and City", stateValueText + " " + cityValueText);

        // declaram listele cu valorile actuale din tabel
        List<WebElement> submitTablesKeys = driver.findElements(By.xpath("//tbody//td[1]"));
        List<WebElement> submitTablesValues = driver.findElements(By.xpath("//tbody//td[2]"));
        HashMap<String, String> actualValues = new HashMap<>();
        for (int i = 0; i < submitTablesKeys.size(); i++) {
            actualValues.put(submitTablesKeys.get(i).getText(), submitTablesValues.get(i).getText());
        }

        // assert-ul este validare ca un anumit obiect e egal cu altul sau ca valorile dintre anumite obiecte sunt egale, sau ca un element exista
       // Assert.assertEquals(actualValues, expectedValues, "Actual Values: " + actualValues + " are not equal/are not the same with the expected values: " + expectedValues);

    }
}
