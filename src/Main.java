import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите фигуру: 1 - параллелепипед, 2 - цилиндр");
        int choice = scanner.nextInt();

        try {
            switch (choice) {
                case 1:
                    calculateParallelepiped(scanner);
                    break;
                case 2:
                    calculateCylinder(scanner);
                    break;
                default:
                    System.out.println("Некорректный выбор фигуры.");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: введите числовое значение.");
        } catch (MyException e) {
            System.out.println("Ошибка: введено отрицательное значение.");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void calculateParallelepiped(Scanner scanner) throws MyException {
        System.out.println("Введите длину параллелепипеда:");
        double length = scanner.nextDouble();
        if (length < 0) {
            throw new MyException("Отрицательная длина.");
        }

        System.out.println("Введите ширину параллелепипеда:");
        double width = scanner.nextDouble();
        if (width < 0) {
            throw new MyException("Отрицательная ширина.");
        }

        System.out.println("Введите высоту параллелепипеда:");
        double height = scanner.nextDouble();
        if (height < 0) {
            throw new MyException("Отрицательная высота.");
        }

        double surfaceArea = 2 * ((height * length) + (length * width) + (height * width));
        double volume = length * width * height;

        System.out.println("Площадь параллелепипеда: " + surfaceArea);
        System.out.println("Объем параллелепипеда: " + volume);
    }

    private static void calculateCylinder(Scanner scanner) throws MyException {
        System.out.println("Введите радиус цилиндра:");
        double radius = scanner.nextDouble();
        if (radius < 0) {
            throw new MyException("Отрицательный радиус.");
        }

        System.out.println("Введите высоту цилиндра:");
        double height = scanner.nextDouble();
        if (height < 0) {
            throw new MyException("Отрицательная высота.");
        }

        final double PI = 3.14159;

        double surfaceArea = 2 * PI * radius * (height + radius);
        double volume = PI * radius * radius * height;

        System.out.println("Площадь цилиндра: " + surfaceArea);
        System.out.println("Объем цилиндра: " + volume);
    }
}
