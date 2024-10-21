package Management_Exc;

import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param manager the manager to give the salary
     * @param employee the employee to receive the raise
     * @param salary the salary increase to be given
     * @throws ClassCastException when manager or employee is not a manager or employee
     * @throws IllegalArgumentException when salary is invalid
     * @throws NoSuchElementException when given manager or employee does not exist in the list of persons
     */
    public static void giveRaise(List<Person> persons, String manager, String employee, double salary)  {
        for(Person p: persons) {
            if (manager.equals(p.getName())) {
                if (!(p instanceof Manager)) {
                    throw new ClassCastException(manager + " is not a manager");
                }
                for(Person m: persons){
                    if (employee.equals(m.getName())){
                        if (!(m instanceof Employee)) {
                            throw new ClassCastException(employee + " is not an employee");
                        }
                        ((Manager)p).giveRaise((Employee)m, salary);
                        return;
                    }
                }
                throw new NoSuchElementException(employee + " does not exist");
            }
        }
        throw new NoSuchElementException(manager + " does not exist");
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param developer the developer to be assigned
     * @param manager the manager assigned to the dev
     * @throws ClassCastException when manager or developer is not a manager or employee
     * @throws NoSuchElementException when given manager or developer does not exist in the list of persons
     * @throws IllegalStateException when developer already has a manager
     */
    public static void assignPM(List<Person> persons, String developer, String manager) {
        for(Person p: persons) {
            if (developer.equals(p.getName())) {
                if (!(p instanceof Employee)) {
                    throw new ClassCastException(developer + " is not a developer");
                }
                for(Person m: persons){
                    if (manager.equals(m.getName())){
                        if (!(m instanceof Manager)) {
                            throw new ClassCastException(manager + " is not a manager");
                        }
                        ((Developer)p).setProjectManager((Manager)m);
                        return;
                    }
                }
                throw new NoSuchElementException(manager + " does not exist");
            }
        }
        throw new NoSuchElementException(developer + " does not exist");
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param customer the customer to speak to the employee
     * @param employee the employee to be spoken to
     * @return the dialogue of the customer to the employee
     * @throws IllegalArgumentException when given customer or employee is not what they are
     * @throws NoSuchElementException when given customer or employee is not in the list of persons
     */
    public static String customerSpeak(List<Person> persons, String customer, String employee) {
        for(Person p: persons) {
            if (customer.equals(p.getName())) {
                if (!(p instanceof Customer)) {
                    throw new ClassCastException(customer + " is not a customer");
                }
                for(Person m: persons){
                    if (employee.equals(m.getName())){
                        if (!(m instanceof Employee)) {
                            throw new ClassCastException(employee + " is not an employee");
                        }
                        return ((Customer)p).speak((Employee)m);

                    }
                }
                throw new NoSuchElementException(employee + " does not exist");
            }
        }
        throw new NoSuchElementException(customer + " does not exist");
    }
}
