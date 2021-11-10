package service.ServiceImpl;

import enums.Role;
import model.Book;
import model.Library;
import model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianTest {


    @Test
    void addBooksToLibrary() {
        Librarian librarian = new Librarian("Ikechukwu", Role.LIBRARIAN, 1);
        Library library = new Library();
        List<Book> book = (List<Book>) new Book("Obsidian Palace", "Aniks Daermon Elvira", "Elvira Prints", 16);
        librarian.addBooksToLibrary(book);
        final boolean expectedOutput = true;
        final boolean actualOutput = library.getAvailableBooks().containsKey("Obsidian Palace");
        assertEquals(expectedOutput,actualOutput);

    }

    @Test
    void giveABook() {
        Librarian librarian = new Librarian("Ikechukwu", Role.LIBRARIAN,1);
        Library library = new Library();
        library.getPersonQueue();
        Book book = new Book("Only Human", "Velasco Daermon Pheles", "Elvira Prints", 14);
        Person borrower1 = null;
        library.getPersonQueue().add(borrower1);
        final String expectedOutput = "No body on queue";
        final String actualOutput = librarian.giveABook(book);
        assertEquals(expectedOutput,actualOutput);


    }

    @Test
    void giveABookByPriority() {
    }

    @Test
    void addPersonToQueue() {
        Librarian librarian = new Librarian("Ikechukwu", Role.LIBRARIAN,1);
        Person person = new Person("sfge",Role.SENIOR_STUDENT,2);
        Library library = new Library();
        librarian.addPersonToQueue(person);
        final String expectedOutput = "Person already on queue";
        final String actualOutput = librarian.addPersonToQueue(person);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void addPersonToPriorityQueue() {
        Librarian librarian = new Librarian("Ikechukwu", Role.LIBRARIAN,1);
        Person person = new Person("sfge",Role.SENIOR_STUDENT,2);
        Library library = new Library();
        library.getPriorityQueue().add(person);
        final String expectedOutput = "Added to queue successfully";
        final String actualOutput = librarian.addPersonToPriorityQueue(person);
        assertEquals(expectedOutput,actualOutput);

    }

    @Test
    void registerBooker() {
        Librarian librarian = new Librarian("Ikechukwu", Role.LIBRARIAN,1);
        Person person = new Person("sfge",Role.SENIOR_STUDENT,2);
        Library library = new Library();
        library.getRegisteredBookers().add(person);
        final boolean expectedOutput = true;
        final boolean actualOutput = library.getRegisteredBookers().contains(person);
        assertEquals(expectedOutput,actualOutput);


    }

    @Test
    void printBookers() {

    }

    @Test
    void printVIPBookers() {
    }
}