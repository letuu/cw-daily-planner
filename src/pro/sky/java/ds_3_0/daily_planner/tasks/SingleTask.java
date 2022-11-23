package pro.sky.java.ds_3_0.daily_planner.tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SingleTask extends Task {

    public SingleTask(String title, String description, TaskCategory taskCategory, LocalDateTime taskDataTime) {
        super(title, description, taskCategory, taskDataTime);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return getTaskDataTime().toLocalDate().equals(date);
    }

    @Override
    public String getTaskType() {
        return "Однократная";
    }
}
