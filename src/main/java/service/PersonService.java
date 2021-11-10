package service;

import model.Book;
import model.Library;
import model.Person;
import service.ServiceImpl.Librarian;

public interface PersonService {

    String requestForBook(Person borrower, Library library, Book book);

    void returnABook(Librarian library, Book book);


}
