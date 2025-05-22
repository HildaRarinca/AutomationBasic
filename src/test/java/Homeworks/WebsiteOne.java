package Homeworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebsiteOne {
    //Tema: initializare browser; gasit un element sau doua; facut o actiune pe elemente(sendkeys, click,etc);
    WebDriver driver;
    @Test

    public void websiteOne(){
        driver = new ChromeDriver();
        //navigam catre pagina websitetului
        driver.get("https://christiantour.ro/");
        //facem fereastra browserului maximaize
        driver.manage().window().maximize();

    }

}
