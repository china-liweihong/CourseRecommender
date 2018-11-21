package src.main.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String exePath = "C:\\Users\\Bala\\Desktop\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", exePath);
        WebDriver driver=new ChromeDriver();
        String URL = "https://www.class-central.com/provider/coursera";
        driver.navigate().to(URL);
	WebElement wb=driver.findElement(By.id("course-listing-tbody"));//.click();
        int i=0;
        int counter=1;
        String baseLocation="C:\\Users\\Bala\\Downloads\\IIRData\\";
        for(WebElement _ele : wb.findElements(By.tagName("tr"))){
            if(_ele.getAttribute("itemtype")!=null){
                List<WebElement> wbElement =_ele.findElements(By.tagName("td"));
                ArrayList<WebElement> wbEle=new ArrayList<WebElement>(wbElement);
                String nextPageURL=wbElement.get(0).findElement(By.tagName("a")).getAttribute("href");
                System.out.println(nextPageURL);
                String title=wbEle.get(1).findElement(By.tagName("span")).getText();
                String currentLocation=baseLocation+counter+".txt";
          //      FileWriter fw=new FileWriter(currentLocation);
          //      for(int z=0;z<title.length();z++)
          //          fw.write(title.charAt(z));
          //      fw.close();
                counter++;
            }
            i++;
        }      /*  for(int i=1;i<=26;i++){
        }*/
        driver.quit();
    }
    
}

