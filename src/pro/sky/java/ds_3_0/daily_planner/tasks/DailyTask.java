package pro.sky.java.ds_3_0.daily_planner.tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {

    public DailyTask(String title, String description, TaskCategory taskCategory, LocalDateTime taskDataTime) {
        super(title, description, taskCategory, taskDataTime);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        LocalDate taskCreationDate = getTaskDataTime().toLocalDate();
        return taskCreationDate.equals(date) || taskCreationDate.isBefore(date);
    }

    @Override
    public String getTaskType() {
        return "Ежедневная";
    }
}
