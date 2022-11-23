package pro.sky.java.ds_3_0.daily_planner;

import pro.sky.java.ds_3_0.daily_planner.tasks.Task;

import java.util.Comparator;

public class TaskTimeComparator implements Comparator<Task> {

    @Override
    public int compare(Task task1, Task task2) {
        return task1.getTaskDataTime().toLocalTime().compareTo(task2.getTaskDataTime().toLocalTime());
    }
}
