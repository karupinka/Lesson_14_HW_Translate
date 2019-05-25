import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.soap.Text;

public class WorkWithGoogleTRans {

    private WebDriver webDriver;
    private By inputArea = By.xpath("//textarea");
    private By outputTextarea = By.xpath("//span[@class='tlid-translation translation']//span");
    private By engEngRusTrans = By.xpath("//div[@class='sl-sugg']//div[@value='en']");
    private By rusEngRusTrans = By.xpath("//div[@class='tl-wrap']//div[@value='ru']");
    private By rusRusEngTrans = By.xpath("//div[@class='sl-sugg']//div[@value='ru']");
    private By engRusEngTrans = By.xpath("//div[@class='tl-wrap']//div[@value='en']");
    private By more = By.xpath("//div[@class = 'tl-more tlid-open-target-language-list']");
    private By moreList = By.xpath("//div[@class = 'language-list'][2]");




    public WorkWithGoogleTRans(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    private void inputText(String text){
        webDriver.findElement(inputArea).sendKeys(text);
    }

    private void engRusSettings(){
        webDriver.findElement(engEngRusTrans).click();
        webDriver.findElement(rusEngRusTrans).click();
        if(webDriver.findElement(moreList).isDisplayed())
            webDriver.findElement(more).click();
    }

    private void rusEngSettings(){
        webDriver.findElement(rusRusEngTrans).click();
        webDriver.findElement(engRusEngTrans).click();
        if(webDriver.findElement(moreList).isDisplayed())
            webDriver.findElement(more).click();
    }

    private String getTrans(){
        return webDriver.findElement(outputTextarea).getText();
    }

    public String Translate(String text, String language){
        webDriver.get("https://translate.google.com/");
        if(language.equals("eng")){
            inputText(text);
            engRusSettings();
            return getTrans();
        }
        else{
            inputText(text);
            rusEngSettings();
            return getTrans();
        }
    }

    public void quit(){
        webDriver.quit();
    }




}
