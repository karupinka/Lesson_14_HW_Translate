
public class EnglishRussiaTranslate implements Strategy {
    private WorkWithGoogleTRans translate;

    private EnglishRussiaTranslate(){}
    public EnglishRussiaTranslate(WorkWithGoogleTRans translate) {
        this.translate = translate;
    }

    public String translate(String wordForTranslate, String language) {

        return translate.Translate(wordForTranslate, language);
    }
}
