package model;

import java.util.*;
import model.Book;

public class Library {

    private static Library library = null;

    private final Map<String, Book> availableBooks;
    private final Map<Person, Book> borrowedBooks;
    private final Map<Person, Book> vipBorrowers;
    private final List<Person> registeredBookers;
    public Queue<Person> priorityQueue;
    private static Queue<Person> personQueue;

    public Library() {
        vipBorrowers = new HashMap<>();
        borrowedBooks = new HashMap<>();
        registeredBookers = new LinkedList<>();
        availableBooks  = new HashMap<>();
         personQueue = new LinkedList<>();
         priorityQueue = new PriorityQueue<>((person1, person2) -> {
             if(person1.getRole().getPriority() < person2.getRole().getPriority()) {
                 return -1;  // would sort based on ascending order
             } else if(person1.getRole().getPriority() > person2.getRole().getPriority()) {
                 return 1;
             } else {
                 return 0;
             }
         });
    }

    public void addNewBooks(List<Book> books){
        //Lambda expression to add books to the books shelf
        books.forEach(book -> availableBooks.put(book.getBookTitle(), book));
    }
    public static Library getInstance() {
        if(library == null) {
            library = new Library();
        }
        return library;
    }

    public void addToBorrowedList(Person borrower, Book book){
        getBorrowedBooks().put(borrower, book);
    }

    public void addToVIPBorrowersList(Person borrower, Book book){
        getVipBorrowers().put(borrower, book);
    }

    public Map<String, Book> getAvailableBooks() {
        return availableBooks;
    }

    public Map<Person, Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public Map<Person, Book> getVipBorrowers() {
        return vipBorrowers;
    }

    public List<Person> getRegisteredBookers() {
        return registeredBookers;
    }

    public Queue<Person> getPersonQueue() {
        return personQueue;
    }
    public Queue<Person> getPriorityQueue() {
        return priorityQueue;
    }

}
