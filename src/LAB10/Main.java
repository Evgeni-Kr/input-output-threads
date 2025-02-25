package LAB10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ivan Petrochenko", "Electrician", 1200.0));
        employees.add(new Employee("Maria Kuznetsova", "Welder", 1500.0));
        employees.add(new Employee("Dmitry Sidorov", "Painter", 1100.0));
        employees.add(new Employee("Olga Ivanova", "Mechanic", 1450.0));
        employees.add(new Employee("Boris Vasiliev", "Plumber", 1300.0));
        employees.add(new Employee("Elena Gorbunova", "Electrician", 1200.0));
        employees.add(new Employee("Alexei Petrov", "Welder", 1500.0));
        employees.add(new Employee("Tatiana Smirnova", "Painter", 1100.0));
        employees.add(new Employee("Irina Popova", "Mechanic", 1450.0));
        employees.add(new Employee("Viktor Ivanov", "Plumber", 1300.0));
        employees.add(new Employee("Anna Petrova", "Electrician", 1200.0));
        employees.add(new Employee("Sergey Kuznetsov", "Welder", 1500.0));
        employees.add(new Employee("Natalia Sidorov", "Painter", 1100.0));
        employees.add(new Employee("Ekaterina Ivanova", "Mechanic", 1450.0));
        employees.add(new Employee("Andrey Vasiliev", "Plumber", 1500.0));
        Employee.writeEmployeesToFile(employees);
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nМеню управления файлом сотрудников:");
            System.out.println("1. Вывести список рабочих");
            System.out.println("2. Добавить сотрудника");
            System.out.println("3. Определить среднюю зарплату слесарей");

            System.out.println("0. Выход");
            System.out.print("Введите ваш выбор: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Неверный формат ввода. Введите целое число: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    Employee.readEmployeesFromFile();
                    System.out.println("Файл с сотрудниками создан и заполнен.");
                    break;
                case 2:
                    Employee.appendEmployeesToFile(Employee.set());
                    break;
                case 3:
                    Employee.calculateSalary("Plumber");
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, введите число из меню.");
            }
        } while (choice != 0);
        scanner.close();
    }
}