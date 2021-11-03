package service;

import model.Person;

public class PersonServiceIpl implements  PersonService{
    @Override
    public void requestForBook(Person borrower, Librararian library, Books book) {
        //add borrower to both normal queue and priority queue
        if(!library.getPriorityQueue().contains(borrower)){
            library.getPriorityQueue().add(borrower);
        }



    }

    @Override
    public void returnABook(Librararian library, Books book) {

    }
}
