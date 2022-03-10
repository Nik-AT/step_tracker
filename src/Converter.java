public class Converter {
    double lengthByMeters = 0.75;
    double calByStep = 50;
    StepTracker stepTracker;

    public Converter(StepTracker stepTracker) {
        this.stepTracker = stepTracker;
    }

    /**
     * Конвертирует шаги в расстояние (км)
     */
    public void convertDist(int numberMonth) {
        double distance = stepTracker.printStepForMonth(numberMonth) * lengthByMeters / 1000;
        System.out.println(distance);
    }

    /**
     * Конвертирует шаги в потраченные килокалории
     */
    public void convertCal(int numberMonth) {
        double calories = stepTracker.printStepForMonth(numberMonth) * calByStep / 1000;
        System.out.println(calories);
    }
}

