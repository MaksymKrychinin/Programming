package Entity;

public class Book {
    String keyWords;
    String nameOfBook;


    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    Book() {
    }

    Book(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public Book(String nameOfBook, String keyWords) {
        this.keyWords = keyWords;
        this.nameOfBook = nameOfBook;
    }


}
