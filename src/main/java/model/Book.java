package model;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Book {            // Create 3 methods representing the set of books with an array

    private int bookID;
    private String bookTitle,author,publisher;
    private int quantity;

    public Book(String bookTitle, String author, String publisher, int quantity) {
        this.bookID = 000;
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public int getBookID() {
        return bookID;
    }

    public int getQuantity() {
        return quantity;
    }

    public int addQuantity() {
        return quantity += 1;
    }

    public int subtractQuantity() {
        return quantity -= 1;
    }


    //private static Map<Integer, Book> map = new LinkedHashMap<Integer, Book>();

    @Override
    public int hashCode() {
        return Objects.hash(bookTitle, quantity);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + bookTitle + '\'' +
                ", noOfCopies=" + quantity +
                '}';
    }

}


