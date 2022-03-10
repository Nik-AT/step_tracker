import java.util.HashMap;

public class StepTracker {
    int goalOfStep = 10000; // Цель по кол-ву шагов (по умолчанию)
    HashMap<Integer, int[]> monthDayStep = new HashMap<>();

    /**
     * Сохраняет кол-во шагов за определенный день
     * В каждом месяце 30 дней
     */
    public void saveStep(int numberMonth, int numberDay, int step) {
        int[] stepForMonth = monthDayStep.get(numberMonth);
        if (stepForMonth == null) {  // Проверка, есть ли такой месяц в хеш-таблице
            stepForMonth = new int[30]; // Создаем новый массив
            monthDayStep.put(numberMonth, stepForMonth); // Добавляем в хеш-таблице номер месяца и массив
        }
        stepForMonth[numberDay] = step; // Вызываем метод, который добавляет в массив шаги
    }

    /**
     * Выводит количество пройденных шагов по дням
     */
    public void printStepForDay(int numberMonth) {
        int[] stepForMonth = monthDayStep.get(numberMonth);
        if (!(stepForMonth == null)) {
            for (int i = 0; i < stepForMonth.length; i++) {
                System.out.print((i + 1) + " день: " + stepForMonth[i] + ", ");
            }
            System.out.println("");
        } else {
            System.out.println("0");
        }
    }

    /**
     * Общее количество шагов за месяц
     */
    public int printStepForMonth(int numberMonth) {
        int[] stepForMonth = monthDayStep.get(numberMonth);
        if (!(stepForMonth == null)) {
            int max = 0;
            for (Integer s : stepForMonth) {
                max += s;
            }
            return max;
        } else {
            return 0;
        }
    }

    /**
     * Максимальное кол-во шагов в месяц
     */
    public void maxStep (int numberMonth) {
        int[] stepForMonth = monthDayStep.get(numberMonth);
        if (!(stepForMonth == null)) {
            int max = 0;
            for (Integer stepDay : stepForMonth) {
                int temp = 0;
                temp += stepDay;
                if (temp > max) {
                    max = temp;
                }
            }
            System.out.println(max);
        }
        else {
            System.out.println("0");
        }
    }

    /**
     * Среднее количество шагов за месяц
     */
    public void printAvrStep(int numberMonth) {
        int[] stepForMonth = monthDayStep.get(numberMonth);
        if (!(stepForMonth == null)) {
            int sum = 0;
            int day = 0;

            for (Integer stepDay : stepForMonth) {
                if (stepDay > 0) {
                    day++;
                }
                sum += stepDay;
            }
            double average = (double) sum / day;
            System.out.println(average);
        } else {
            System.out.println("0");
        }
    }

    /**
     * Лучшая серия шагов
     */
    public void bestSeries(int numberMonth) {
        int[] stepForMonth = monthDayStep.get(numberMonth);
        if (!(stepForMonth == null)) {
            int best = 0;
            int temp = 0;
            for (Integer stepDay : stepForMonth) {
                if (stepDay >= goalOfStep) {
                    temp++;
                    if (temp > best) {
                        best = temp;
                    }
                } else {
                    temp = 0;
                }
            }
            System.out.println(best);
        } else {
            System.out.println("0");
        }
    }

    /**
     * Изменение текущей цели по кол-ву шагов
     */
    public void changeStep(int step) {
        if (step >= 0) {
            goalOfStep = step;
            System.out.println("Новая цель по кол-ву шагов: " + goalOfStep + "\n");
        } else {
            System.out.println("Вы ввели отрицательное число");
        }
    }

    /**
     * Переводит цифровой формат в месяц
     */

    public String getNameMonth(int numberOfMonth) {
        HashMap<Integer, String> month = new HashMap<>();
        month.put(0, "Январь");
        month.put(1, "Февраль");
        month.put(2, "Март");
        month.put(3, "Апрель");
        month.put(4, "Май");
        month.put(5, "Июнь");
        month.put(6, "Июль");
        month.put(7, "Август");
        month.put(8, "Сентябрь");
        month.put(9, "Октябрь");
        month.put(10, "Ноябрь");
        month.put(11, "Декабрь");

        return month.get(numberOfMonth);
    }
}

