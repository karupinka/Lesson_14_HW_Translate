import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class Main {

    public static void main(String[] args) {
//        WebDriver driver;
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\gecko\\geckodriver.exe");
//        FirefoxOptions option = new FirefoxOptions();
//        option.setHeadless(true);
//        driver = new FirefoxDriver(option);

        Menu menu = new Menu();
        menu.translate();

       /* WorkWithGoogleTRans workWithGoogleTRans = new WorkWithGoogleTRans(driver);
        System.out.println(workWithGoogleTRans.Translate("Hello", "eng"));
        System.out.println(workWithGoogleTRans.Translate("Собака идет сюда", "rus"));*/

        //workWithGoogleTRans.quit();
    }
}
