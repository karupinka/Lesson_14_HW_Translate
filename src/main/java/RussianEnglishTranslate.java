
public class RussianEnglishTranslate implements Strategy {
    private WorkWithGoogleTRans translate;

    private RussianEnglishTranslate(){}
    public RussianEnglishTranslate(WorkWithGoogleTRans translate) {
        this.translate = translate;
    }


    public String translate(String wordForTranslate, String language) {

        return translate.Translate(wordForTranslate, language);
    }
}
