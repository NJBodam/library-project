package service;
import java.util.LinkedHashMap;
import java.util.Map;

public class Books {            // Create 3 methods representing the set of books with an array

    private int bookID;
    private String name,author,publisher;

    public static void bookMap(Books palace) {
    }

    public String getName() {
        return name;
    }

    public int getBookID() {
        return bookID;
    }

    private int quantity;
    private static Map<Integer, Books> map = new LinkedHashMap<Integer, Books>();

    public Books(String name, String author, String publisher, int quantity) {
        this.bookID = 000;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

}


