import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.Scanner;

public class Menu {
    private Scanner sc;
    private String wordForTrans;
    private Strategy strategy;
    private final String ENG_RUS_COMMAND = "eng-rus";
    private final String RUS_ENG_COMMAND = "rus-eng";
    private String typeOfLanguage;
    private String languageNow = "eng";
    private  WorkWithGoogleTRans workWithGoogleTRans;

    WebDriver driver;

    public Menu(){
        sc = new Scanner(System.in);

        FirefoxOptions option = new FirefoxOptions();
        option.setHeadless(true);
        driver = new FirefoxDriver(option);
        workWithGoogleTRans = new WorkWithGoogleTRans(driver);
        strategy = new EnglishRussiaTranslate(workWithGoogleTRans);
    }

    private void scanWord(){
        wordForTrans = sc.next();
    }

    private void languageDefenition(){
        char firstLetter = wordForTrans.charAt(0);
        if((((int)firstLetter >= 1040) && ((int)firstLetter<=1103)) || ((int)firstLetter == 1105))
            typeOfLanguage = "rus";
        else
            typeOfLanguage = "eng";
    }

    private void changeLanguage(){
        if (wordForTrans.equals(ENG_RUS_COMMAND)) {
            languageNow = "eng";
            System.out.println("Режим перевода переключен на eng-rus");
        }
        else if(wordForTrans.equals(RUS_ENG_COMMAND)) {
            languageNow = "rus";
            System.out.println("Режим перевода переключен на rus-eng");
        }
    }

    private void autoStrategy(){
        String getClass = strategy.getClass().getName();

        if(typeOfLanguage.equals("eng") && !(getClass.equals("EnglishRussiaTranslate"))){
            strategy = new EnglishRussiaTranslate(workWithGoogleTRans);
    }
        else if(typeOfLanguage.equals("rus") && !getClass.equals("RussianEnglishTranslate"))
            strategy = new RussianEnglishTranslate(workWithGoogleTRans);
    }


    public void translate(){
        System.out.println("Переводчик (для выхода нажмите 1)");
        System.out.println("Для переключения режимов введите: \n" +
                "eng-rus - англиско-русский\n" +
                "rus-eng - русско-английский\n");
        do{
            System.out.print("Введите слово для перевода: ");
            scanWord();
            changeLanguage();
            languageDefenition();
            autoStrategy();
            if(typeOfLanguage.equals(languageNow))
                System.out.println(strategy.translate(wordForTrans, languageNow));
            else
                System.out.println("Слово не найдено переключите режим перевода");

        }while(!wordForTrans.equals("1"));
        System.out.println("Программа окончила работу");
        workWithGoogleTRans.quit();
    }

}
