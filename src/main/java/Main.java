import enums.Role;
import model.Person;
import service.Books;
import service.Librarian;
import service.Librararian;

public class Main {
    public static void main(String[] args) {
        Person other5 = new Person("Enoch Oghene", Role.SENIOR_STUDENT, 3);
        Person other6 = new Person("Paul Play", Role.JUNIOR_STUDENT, 2);
        Person elder1 = new Person("David Orji", Role.TEACHER, 1);
        Person other7 = new Person("Makera Apiri", Role.SENIOR_STUDENT, 3);


        // Here we call our service implementation/ VoterRegistrationService
        // We passed the implementation of the voter's registration point implementation
        // to the voter's registration point.
        Librarian bookingServices = new Librararian();
        // Here are the people we want to book
        // See if you can add the book title to the constructor so it receives it as an argument
        // Forget preceding line, we don't need that...I think
        bookingServices.giveABook(other5);
        bookingServices.giveABook(other6);
        bookingServices.giveABook(elder1);

        bookingServices.registerBooker();
        bookingServices.registerBooker();
        bookingServices.registerBooker();

        bookingServices.printBookers();


        // Issuing Books

        Books palace = new Books("Obsidian Palace", "Aniks Daermon Elvira", "Elvira Prints", 16);
        Books human = new Books("Only Human", "Velasco Daermon Pheles", "Elvira Prints", 14);
        Books temple = new Books("Stormbringer's Temple", "7th Division", "Elvira Prints", 3);

        Books.bookMap(palace);
        Books.bookMap(human);
        Books.bookMap(temple);

       */
    }
}
