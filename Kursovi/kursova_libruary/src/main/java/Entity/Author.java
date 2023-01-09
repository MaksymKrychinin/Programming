package Entity;

import java.util.ArrayList;
import java.util.List;

public class Author {
    String author;
    List<Book> bookList;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void addBookList(Book book) {
        bookList.add(book);
    }
    public Author(){
        bookList=new ArrayList<>();
    }
    public Author(String author){
        this.author=author;
        bookList=new ArrayList<>();
    }

}
