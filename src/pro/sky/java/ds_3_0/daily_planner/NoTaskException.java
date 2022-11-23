package pro.sky.java.ds_3_0.daily_planner;

public class NoTaskException extends Exception {
    //"С таким ID задачи нет, после выбора пункта меню 'Удалить задачу' введите существующий ID"
    public NoTaskException(String message) {
        super(message);
    }
}
