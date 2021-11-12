package service.ServiceImpl;

import enums.Role;
import model.Book;
import model.Library;
import model.Person;
import service.LibrarianService;

import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class Librarian extends Person implements LibrarianService {

    private static Librarian librarian = null;
    private Library library = Library.getInstance();


    public Librarian(String name, Role role, int priority) {
        super(name, role, priority);
    }


    public static Librarian getInstance() {
        if(librarian == null) {
            librarian = new Librarian("Ikechukwu", Role.LIBRARIAN, 1);
        }
        return librarian;
    }


    //print that someone has booked a book
    // Provide the class name in the parenthesis
    private final static Logger LOGGER = Logger.getLogger(Librarian.class.getName());

    public void addBooksToLibrary(List<Book> books){
        library.addNewBooks(books);
    }

    @Override
    public String giveABook(Book book) {     // Book a book, add person to queue
        Person borrower = library.getPersonQueue().remove();
        if (borrower != null){
            library.addToBorrowedList(borrower, book);
            return book.getBookTitle() + "Book borrowed to " +borrower.getName();
        }
        else return "No body on queue";
    }


    @Override
    public String giveABookByPriority(Book book) {
        if (!(library.getPriorityQueue().isEmpty())){
            Person borrower = library.getPriorityQueue().remove();
            library.addToVIPBorrowersList(borrower, book);
            return book.getBookTitle() + "Book borrowed to " +borrower.getName();
        }
        else return "No body on queue";
    }


    public String addPersonToQueue(Person person) {
        String message = "";
        if(!library.getPersonQueue().contains(person)){
            library.getPersonQueue().add(person);
            message = "Added to queue successfully";
        } else{
            message = "Person already on queue";
        }
        return message;
    }

    public String addPersonToPriorityQueue(Person person) {
        String message = "";
        if(!library.getPriorityQueue().contains(person)){
            library.getPriorityQueue().add(person);
            message = "Added to queue successfully";
        } else{
            message = "Added to queue successfully";
        }

        return message;
    }

    @Override
    public void registerBooker(Person booker) {          // people who have library book in custody, sent to SET
        library.getRegisteredBookers().add(booker);
    }


    @Override
    public void printBookers() {
        // Prints everyone that has collected a book
        //Lambda expression used to print persons who have borrowed a book
        library.getBorrowedBooks().keySet().forEach(System.out::println);
    }

    public void printVIPBookers(){
        library.getVipBorrowers().keySet().forEach(System.out::println);
    }

    @Override
    public void returnToLibrary(Book book, Library library) {
//        if(library.availableBooks.containsKey(book.getName())){
//            int old = this.library.availableBooks.get(book.getName());
//            this.library.availableBooks.put(book.getName(), old + book.getQuantity());
//        }else{
//            this.library.availableBooks.put(book.getName(), book.getQuantity());
//        }
    }


}
