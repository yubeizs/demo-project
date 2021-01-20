package com.example.demoproject;


public class RunTask implements Runnable {

    private Person person;

    @Override
    public void run() {
        System.out.println(person.getAge()+person.getName());
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
