package service;
import model.Book;
import model.Library;
import model.Person;

public interface LibrarianService {
    // Functions performed by the library // Book a book accepts the person arg/check if it can accept a book
    String giveABook(Book book);
    String giveABookByPriority(Book book);
    void registerBooker(Person booker);              // Add person to register
    void printBookers();
    void returnToLibrary(Book book, Library library);


}
