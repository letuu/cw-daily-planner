package pro.sky.java.ds_3_0.daily_planner;

import pro.sky.java.ds_3_0.daily_planner.tasks.Task;

import java.time.LocalDate;
import java.util.*;

public class Schedule {

    private final Map<Integer, Task> taskMap = new HashMap<>();

    public void addTask(Task task) {
        taskMap.put(task.getId(), task);
    }

    public Collection<Task> getAllTasks() {
        return taskMap.values();
    }

    public void removeTask(int id) throws NoTaskException {
        if (!taskMap.containsKey(id)) {
            throw new NoTaskException("С таким ID задачи нет, после выбора пункта меню 'Удалить задачу' введите существующий ID");
        }
        taskMap.remove(id);
    }

    public Collection<Task> getTaskForDay(LocalDate localDate) {
        Set<Task> taskForDay = new TreeSet<>(new TaskTimeComparator());
        for (Task task : taskMap.values()) {
            if (task.appearsIn(localDate)) {
                taskForDay.add(task);
            }
        }
        return taskForDay;
    }
}
