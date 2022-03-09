public class Converter {
    double distance = 0.75;
    double cal = 50;
    StepTracker stepTracker;
    public Converter(StepTracker stepTracker) {
        this.stepTracker = stepTracker;


    }

    /**
     Конвертирует шаги в расстояние (км)
     */
    public void convertDist (int numberMonth){
        System.out.println((stepTracker.printStepForMonth(numberMonth) * distance)/1000);
    }

    /**
     Конвертирует шаги в потраченные килокалории
     */
    public void convertCal (int numberMonth){
        System.out.println((stepTracker.printStepForMonth(numberMonth) * cal)/1000);
    }
}

