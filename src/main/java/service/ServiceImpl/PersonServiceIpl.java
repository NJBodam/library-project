package service.ServiceImpl;

import model.Library;
import model.Person;
import model.Book;
import service.PersonService;

public class PersonServiceIpl implements PersonService {
//    public PersonServiceIpl(String name, Role role, int priority) {
//        super(name, role, priority);
//    }
    Librarian librarian = Librarian.getInstance();


    @Override
    public String requestForBook(Person borrower, Library library, Book book) {
        String message = "";
        //add borrower to both normal queue and priority queue
        if (library.getRegisteredBookers().contains(borrower)){
            librarian.addPersonToQueue(borrower);
            librarian.addPersonToPriorityQueue(borrower);
            message = "Book requested";
            //System.out.println(borrower.getName() + " has requested for " + book.getName());
        }
        else {
            message = "User not registered";
        }
        return message;
    }


    @Override
    public void returnABook(Librarian library, Book book) {

    }
}
