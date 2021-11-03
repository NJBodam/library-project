package service;

import model.Library;
import model.Person;

import java.util.*;
import java.util.logging.Logger;

public class Librararian implements Librarian {
    // Instantiated it here/ Not going to change hence made final

    public Queue<Person> getPriorityQueue() {
        return priorityQueue;
    }

    // First Implementation - FIFO/LIFO on priority basis
    private Queue<Person> priorityQueue = new PriorityQueue<>(new Comparator<Person>() {
        @Override
        public int compare(Person person1, Person person2) {
            if(person1.getPriority() < person2.getPriority()) {
                return -1;  // would sort based on ascending order
            } else if(person1.getPriority() > person2.getPriority()) {
                return 1;
            } else {
                return 0;
            }
        }
    });
    // Second Implementation - FIFO
    private final static Queue<Person> personQueue = new LinkedList<>();
    //Implementation of library most likely
    private final static Set<Person> registeredBookers = new HashSet<>();

    //print that someone has booked a book
    // Provide the class name in the parenthesis
    private final static Logger LOGGER = Logger.getLogger(Librararian.class.getName());

    @Override
    public void giveABook(Person person) {     // Book a book, add person to queue
        if(person != null) {
            addPersonToQueue(person);               // Throw exceptions here and below
        }

    }

    private void addPersonToQueue(Person person) {
        if(!personQueue.contains(person)){
            personQueue.add(person);
        }
    }

    @Override
    public void registerBooker() {          // people who have library book in custody, sent to SET
        if(!personQueue.isEmpty()){           // people after booking a book are removed and sent to set
            final Person registeredBooker =
                    personQueue.remove();        // removes first person in queue
            registeredBookers.add(registeredBooker);    // person who booked a book has been added to library list of people who owe books

            // The logger formats our output to a string, the "%s" means we are expecting a string and serves as a placeholder
            LOGGER.info(String.format("Registered: %s ", registeredBooker.getName())); // the name will be stored in the %$

        }

    }

    @Override
    public void printBookers() {
        // Prints everyone that has collected a book
        registeredBookers.forEach(System.out::println);

    }

    @Override
    public void addABook(Books book, Library library) {
        library.bookMap1.put(book.getName(),book.getBookID());
    }

}
