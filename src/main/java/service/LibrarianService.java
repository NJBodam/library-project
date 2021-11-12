package service;
import model.Book;
import model.Library;
import model.Person;

import java.util.function.Consumer;
import java.util.function.Function;

public interface LibrarianService {
    // Functions performed by the library // Book a book accepts the person arg/check if it can accept a book
    String giveABook(Book book);

    String giveABookByPriority(Book book);
    void registerBooker(Person person);              // Add person to register
    void printBookers();
    void returnToLibrary(Book book, Library library);



}
