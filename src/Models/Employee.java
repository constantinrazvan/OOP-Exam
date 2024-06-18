package Models;

public abstract class Employee implements Comparable<Employee> {
    private String name;
    private int salary;
    private String ssn;

    public Employee(String name, int salary, String ssn) {
        this.name = name;
        this.salary = salary;
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Ssn: " + getSsn() + ", Salary: " + getSalary();
    }

    @Override
    public int compareTo(Employee other) {
        if (this.salary != other.salary) {
            return Integer.compare(this.salary, other.salary);
        } else {
            return this.name.compareTo(other.name);
        }
    }
}
