package Entity;

public class Vocabulary {
    String vocabularyName;
    String word;
    String wordInfo;

    public Vocabulary(String vocabularyName, String word, String wordInfo) {
        this.vocabularyName = vocabularyName;
        this.word = word;
        this.wordInfo = wordInfo;
    }

    public String getVocabularyName() {
        return vocabularyName;
    }

    public String getWord() {
        return word;
    }

    public String getWordInfo() {
        return wordInfo;
    }
}
