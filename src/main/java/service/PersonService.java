package service;

import model.Person;

public interface PersonService {
    void requestForBook(Person borrower, Librararian library, Books book);
    void returnABook(Librararian library, Books book);
}
