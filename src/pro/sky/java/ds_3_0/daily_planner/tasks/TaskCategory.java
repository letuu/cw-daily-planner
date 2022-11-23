package pro.sky.java.ds_3_0.daily_planner.tasks;

public enum TaskCategory {
    PERSONAL("Личная"),
    WORK("Рабочая");

    private final String strTaskCategory;

    TaskCategory(String strTaskCategory) {
        this.strTaskCategory = strTaskCategory;
    }

    public String getStrTaskCategory() {
        return strTaskCategory;
    }

    @Override
    public String toString() {
        return strTaskCategory;
    }
}
