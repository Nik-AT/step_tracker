import java.util.HashMap;

public class StepTracker {
    int goalOfStep = 10000; // Цель по кол-ву шагов (по умолчанию)
    HashMap<Integer, int[]> monthDayStep = new HashMap<>();

    /**
     Сохраняет кол-во шагов за определенный день
     В каждом месяце 30 дней
     */
    public void saveStep(int numberMonth, int numberDay, int step) {
        int [] stepForMonth = monthDayStep.get(numberMonth);
        if (stepForMonth == null) {  // Проверка, есть ли такой месяц в хеш-таблице
            stepForMonth = new int[30]; // Создаем новый массив
            monthDayStep.put(numberMonth, stepForMonth); // Добавляем в хеш-таблице номер месяца и массив
        }
        stepForMonth[numberDay] = step; // Вызываем метод, который добавляет в массив шаги
    }

    /**
     Выводит количество пройденных шагов по дням
     */
    public void printStepForDay (int numberMonth){
        int[] m = monthDayStep.get(numberMonth);
        if (!(m == null)) {
            for (int i = 0; i < m.length; i++)
                System.out.print((i + 1) + " день: " + m[i] + ", " );
            System.out.println("");

        }
        else System.out.println("0");
    }

    /**
     Общее количество шагов за месяц
     */
    public int printStepForMonth(int numberMonth) {
        int[] m = monthDayStep.get(numberMonth);
        if (!(m == null)) {
            int max = 0;
            for (Integer s : m)
                max += s;
            return max;
        }
        else return 0;
    }

    /**
     Среднее количество шагов за месяц
     */
    public void printAvrStep (int numberMonth) {
        int[] m = monthDayStep.get(numberMonth);
        if (!(m == null)) {
            int sum = 0;
            int day = 0;

            for (Integer s : m) {
                if (s>0)
                    day++;
                sum+=s;
            }
            double avr = (double)sum/day;
            System.out.println(avr);

        }
        else System.out.println("0");
    }

    /**
     Лучшая серия шагов
     */
    public void bestSeries (int numberMonth){
        int[] m = monthDayStep.get(numberMonth);
        if (!(m == null)) {
            int best = 0;
            int temp = 0;
            for (Integer s : m){
                if (s >= goalOfStep){
                    temp++;
                    if (temp > best)
                        best = temp;
                }
                else temp = 0;
            }
            System.out.println(best);
        }
        else System.out.println("0");
    }

    /**
     Изменение текущей цели по кол-ву шагов
     */
    public void changeStep (int step) {
        if (step >= 0) {
            goalOfStep = step;
            System.out.println("Новая цель по кол-ву шагов: " + goalOfStep + "\n");
        }
        else System.out.println("Вы ввели отрицательное число");
    }

    /**
     Переводит цифровой формат в месяц
     */
    public static String getNameMount(int month) {
        return switch (month) {
            case 0 -> "Январь";
            case 1 -> "Февраль";
            case 2 -> "Март";
            case 3 -> "Апрель";
            case 4 -> "Май";
            case 5 -> "Июнь";
            case 6 -> "Июль";
            case 7 -> "Август";
            case 8 -> "Сентябрь";
            case 9 -> "Октябрь";
            case 10 -> "Ноябрь";
            case 11 -> "Декабрь";
            default -> "";
        };
    }


}

