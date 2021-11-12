import enums.Role;
import model.Book;
import model.Library;
import model.Person;
import service.ServiceImpl.Librarian;
import service.ServiceImpl.PersonServiceIpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Person paul = new Person("Paul Play", Role.JUNIOR_STUDENT, 2);
        Person enoch = new Person("Enoch Oghene", Role.SENIOR_STUDENT, 3);
        Person david = new Person("David Orji", Role.TEACHER, 1);
        Person makera = new Person("Makera Apiri", Role.SENIOR_STUDENT, 3);
        PersonServiceIpl psimp = new PersonServiceIpl();

        Library myLib = Library.getInstance();
        Librarian librarian = Librarian.getInstance();

        List<Book> bookList = List.of(new Book("Obsidian Palace", "Aniks Daermon Elvira", "Elvira Prints", 16),
                new Book("Only Human", "Velasco Daermon Pheles", "Elvira Prints", 14),
                new Book("Stormbringer's Temple", "7th Division", "Elvira Prints", 3));

        //Add the list of books in bookList to the Library store
        librarian.addBooksToLibrary(bookList);
        //Register the below Persons as eligible library users
        librarian.registerBooker(enoch);
        librarian.registerBooker(david);
        librarian.registerBooker(paul);
        librarian.registerBooker(makera);


        // Initializing Book
        Book obsidian = bookList.get(1);
        Book onlyHuman = bookList.get(2);
        Book stormBringersTemple = bookList.get(0);

        psimp.requestForBook(enoch, myLib, onlyHuman);
        psimp.requestForBook(makera, myLib, obsidian);
        psimp.requestForBook(david, myLib, stormBringersTemple);
        psimp.requestForBook(paul, myLib, obsidian);

        System.out.println("Giving book with no priority ******************");
        System.out.println(librarian.giveABook(onlyHuman));
        System.out.println(librarian.giveABook(obsidian));
        System.out.println(librarian.giveABook(stormBringersTemple));
        System.out.println(librarian.giveABook(obsidian));
        System.out.println("Printing list of book borrowers: Queue ***************");
        librarian.printBookers();
        System.out.println();

        psimp.requestForBook(enoch, myLib, onlyHuman);
        psimp.requestForBook(makera, myLib, onlyHuman);
        psimp.requestForBook(david, myLib, onlyHuman);
        psimp.requestForBook(paul, myLib, onlyHuman);
        System.out.println("Giving book by priority **********************");
        System.out.println(librarian.giveABookByPriority(onlyHuman));
        System.out.println(librarian.giveABookByPriority(onlyHuman));
        System.out.println(librarian.giveABookByPriority(onlyHuman));
        System.out.println(librarian.giveABookByPriority(onlyHuman));
        System.out.println("Printing list of borrowers: Priority Queue ***************");
        librarian.printVIPBookers();



    }
}
