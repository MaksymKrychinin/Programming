package Entity;

public class Translate {
    String language;
    String word;
    String languageToTranslate;
    String wordTranslate;

    public Translate(String language, String word, String languageToTranslate, String wordTranslate) {
        this.language = language;
        this.word = word;
        this.languageToTranslate = languageToTranslate;
        this.wordTranslate = wordTranslate;
    }

    public String getLanguage() {
        return language;
    }

    public String getWord() {
        return word;
    }

    public String getLanguageToTranslate() {
        return languageToTranslate;
    }

    public String getWordTranslate() {
        return wordTranslate;
    }
}
