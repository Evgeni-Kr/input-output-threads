package LAB10;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

 class Employee {
    private String name;
    private String position;
    private double salary;
    private static final String FILE_NAME = "employees.dat";

    public Employee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public Employee() {

    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static Employee set() {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.println("Введите ФИО");
        employee.setName(scanner.nextLine());
        System.out.println("Введите Должность");
        employee.setPosition(scanner.next());
        System.out.println("Введите зарплату");
        employee.setSalary(scanner.nextDouble());
        return employee;
    }

    public static void writeEmployeesToFile(ArrayList<Employee> employees) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_NAME)))) {
            for (Employee employee : employees) {
                dos.writeUTF(employee.name);
                dos.writeUTF(employee.position);
                dos.writeDouble(employee.salary);
            }
        }
    }

    public static void readEmployeesFromFile() throws IOException {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(FILE_NAME)))) {
            String name;
            String position;
            double salary;
            while (dis.available() > 0) {
                name = dis.readUTF();
                position = dis.readUTF();
                salary = dis.readDouble();
                System.out.println((new Employee(name, position, salary)));
            }
        }
    }

    public static void appendEmployeesToFile(Employee employees) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_NAME, true)))) {
            dos.writeUTF(employees.name);
            dos.writeUTF(employees.position);
            dos.writeDouble(employees.salary);
        }
    }

    public static void calculateSalary(String word) throws IOException {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(FILE_NAME)))) {
             String name;
            String position;
            int count = 0;
            double salary;
            double totalSalary = 0;
            while (dis.available() > 0) {
                if (dis.available() == 0) break;
                try {
                    name = dis.readUTF();
                    position = dis.readUTF();
                    salary = dis.readDouble();
                    if (position.equalsIgnoreCase(word)) {
                        count++;
                        totalSalary += salary;
                    }
                } catch (EOFException e) {
                    break;
                }
            }
            if (count > 0) {
                System.out.println(totalSalary / count);
            } else {
                System.out.println("Нет такх работников");
            }
        }
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}