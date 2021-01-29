package core.pojo;

import java.time.LocalDate;

public class Employee implements Comparable<Employee> {

    public String name;
    public Long salary;
    public LocalDate joiningDate;

    public Employee(String name, Long salary, LocalDate joiningDate) {
        this.name = name;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    @Override
    public int compareTo(Employee employee) {
        // This is in decending order.
       // return (int) ( employee.salary-this.salary );
        return employee.joiningDate.compareTo(this.joiningDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!name.equals(employee.name)) return false;
        if (!salary.equals(employee.salary)) return false;
        return joiningDate.equals(employee.joiningDate);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + salary.hashCode();
        result = 31 * result + joiningDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", joiningDate=" + joiningDate +
                '}';
    }
}
