package DailyTask;

class Employee {
    int id;
    String name;
    double basicSalary;

    Employee(int id, String name, double basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
    }


    void displaySalaryDetails() {
        System.out.println("ID : " + id);
        System.out.println("Name : " + name);
        System.out.println("Basic Salary : " + basicSalary);
    }
}

class Manager extends Employee {

    Manager(int id, String name, double basicSalary) {
        super(id, name, basicSalary);
    }

    void calculateSalary() {
        double salary = basicSalary + (basicSalary * 0.30);
        System.out.println("Manager Salary : " + salary);
    }

    @Override
    void displaySalaryDetails() {
        System.out.println("\n--- Manager Details ---");
        System.out.println("ID : " + id);
        System.out.println("Name : " + name);
        calculateSalary();
    }
}

class Developer extends Manager {

    Developer(int id, String name, double basicSalary) {
        super(id, name, basicSalary);
    }

    @Override
    void calculateSalary() {
        double salary = basicSalary + (basicSalary * 0.20);
        System.out.println("Developer Salary : " + salary);
    }

    @Override
    void displaySalaryDetails() {
        System.out.println("\n--- Developer Details ---");
        System.out.println("ID : " + id);
        System.out.println("Name : " + name);
        calculateSalary();
    }
}


class Intern extends Developer {

    Intern(int id, String name, double basicSalary) {
        super(id, name, basicSalary);
    }

    @Override
    void calculateSalary() {
        double salary = basicSalary + (basicSalary * 0.10);
        System.out.println("Intern Salary : " + salary);
    }

    @Override
    void displaySalaryDetails() {
        System.out.println("\n--- Intern Details ---");
        System.out.println("ID : " + id);
        System.out.println("Name : " + name);
        calculateSalary();
    }
}

public class MultilevelInheritanceDemo {

    public static void main(String[] args) {

        Manager m = new Manager(101, "Rahul", 50000);
        Developer d = new Developer(102, "Arun", 40000);
        Intern i = new Intern(103, "Kiran", 20000);

        m.displaySalaryDetails();
        d.displaySalaryDetails();
        i.displaySalaryDetails();
    }
}