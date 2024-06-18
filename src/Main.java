import Models.AuxPersonal;
import Models.Employee;
import Models.Teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        Employee teacher1 = new Teacher("Alice", 50000, "123-45-6789", "Mathematics");
        Employee aux1 = new AuxPersonal("Bob", 35000, "987-65-4321", "Custodian", 5);
        Employee teacher2 = new Teacher("Charlie", 45000, "555-55-5555", "History");
        Employee aux2 = new AuxPersonal("David", 40000, "111-11-1111", "Custodian", 10);
        Employee teacher3 = new Teacher("Alice", 50000, "123-45-6789", "Mathematics");

        employees.add(teacher1);
        employees.add(aux1);
        employees.add(teacher2);
        employees.add(aux2);
        employees.add(teacher3);

        Collections.sort(employees);

        for (Employee emp : employees) {
            System.out.println(emp);
        }

        if (teacher1.equals(teacher3)) {
            System.out.println("Employee 1 and Employee 4 are same");
        } else {
            System.out.println("Employee 1 and Employee 4 are different.");
        }

        ProjectInterface project = new ProjectInterface("Pana Constantin Razvan");
        project.setVisible(true);
        project.setSize(400, 300);

    }
}