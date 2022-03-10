import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter(stepTracker);
        System.out.println("------------------------------------------------");
        System.out.println("Добро пожаловать в приложение <Счётчик калорий>!");
        System.out.println("------------------------------------------------");

        while (true) {
            printMenu();
            int command = 0;
            try {
                command = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ошибка ввода, завершение программы");
                break;
            }
            if (command == 1) {
                setCountOfSteps(scanner, stepTracker);

            } else if (command == 2) {
                statisticsForMonth(scanner, stepTracker, converter);

            } else if (command == 3) {
                changeOfGoal(scanner, stepTracker);

            } else if (command == 4) {
                System.out.println("----------------------");
                System.out.println("Вы вышли из приложения");
                System.out.println("----------------------");
                break;
            } else {
                System.out.println("Не верная команда, повторите ввод!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду :");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выход");
    }

    private static void setCountOfSteps(Scanner scanner, StepTracker stepTracker) {
        System.out.println("Введите номер месяца: " + printMonth());
        int numberMonth = scanner.nextInt();
        System.out.println("Введите номер дня:");
        int numberDay = scanner.nextInt();
        System.out.println("Введите кол-во шагов:");
        int step = scanner.nextInt();
        if (step >= 0) {
            stepTracker.saveStep(numberMonth, numberDay, step);
        } else {
            System.out.println("Введите положительное число");
        }
    }

    private static void statisticsForMonth(Scanner scanner, StepTracker stepTracker, Converter converter) {
        System.out.println("Введите номер месяца: " + printMonth());
        while (true) {
            int numberMonth = scanner.nextInt();
            if (numberMonth >= 0 && numberMonth <= 11) {
                System.out.println("Статистика по месяцу - " + stepTracker.getNameMonth(numberMonth));
                System.out.println("Количество пройденных шагов по дням: ");
                stepTracker.printStepForDay(numberMonth);
                System.out.println("Общее количество шагов за месяц: " + "\n" + stepTracker.printStepForMonth(numberMonth));
                System.out.println("Максимальное пройденное количество шагов в месяце: ");
                stepTracker.maxStep(numberMonth);
                System.out.println("Среднее количество шагов: ");
                stepTracker.printAvrStep(numberMonth);
                System.out.println("Пройденная дистанция (в км):");
                converter.convertDist(numberMonth);
                System.out.println("Количество сожжённых килокалорий:");
                converter.convertCal(numberMonth);
                System.out.println("Лучшая серия:");
                stepTracker.bestSeries(numberMonth);
                break;
            } else {
                System.out.println("Введите правильное значение");
            }
        }
    }

    private static void changeOfGoal(Scanner scanner, StepTracker stepTracker) {
        System.out.println("Текущая цель: " + stepTracker.goalOfStep);
        System.out.println("Введите новую цель:");
        int step = scanner.nextInt();
        stepTracker.changeStep(step);
    }

    private static String printMonth() {
        return ("0 - Январь, 1 - Февраль, 2 - Март, 3 - Апрель, 4 - Май, 5 - Июнь, 6 - Июль," +
                " 7 - Август, 8 - Сентябрь, 9 - Октябрь, 10 - Ноябрь, 11 - Декабрь");
    }
}

