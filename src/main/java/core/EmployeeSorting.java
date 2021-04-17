package core;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
* Sort By Id (using comparable)
* Sort By Name (using comparator)
* Sort By Name & Id
* */
public class EmployeeSorting {

    public static void main(String args[]) {
        Employee e1 = new Employee(3, "Rishabh");
        Employee e2 = new Employee(2, "Rishabh");
        Employee e3 = new Employee(1, "Kiran");
        Employee e4 = new Employee(3, "Ria");
        List<Employee> employeeList = Arrays.asList(e1, e2, e3, e4);
        Collections.sort(employeeList);
        //sort by id
        System.out.println(employeeList);
        Collections.sort(employeeList, new EmployeeSortByName());
        //sort by name
        System.out.println(employeeList);

        //java 8
        List<Employee> sorted = (List<Employee>) employeeList.stream()
                .sorted(new EmployeeSortById())
                .collect(Collectors.toList());
        //sort by id
        System.out.println(sorted);

        //java 8
        List<Employee> multiSorted = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getId))
                .collect(Collectors.toList());
        //sort by name & id
        System.out.println(multiSorted);
    }

}

class EmployeeSortById implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return ((Employee) o1).getId() - ((Employee) o2).getId();
    }

}

class EmployeeSortByName implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return ((Employee) o1).getName().compareTo(((Employee) o2).getName());
    }

}

class Employee implements Comparable {

    private int id;
    private String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        return this.id - ((Employee) o).getId();
    }

    public String toString() {
        return getId() + ":" + getName();
    }

}