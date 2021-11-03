package service;
import model.Library;
import model.Person;

public interface Librarian {
    // Functions performed by the library // Book a book accepts the person arg/check if it can accept a book
    void giveABook(Person person);
    void registerBooker();              // Add person to register
    void printBookers();
    void addABook(Books book, Librararian library);// Print people owing the library

    void addABook(Books book, Library library);
}
