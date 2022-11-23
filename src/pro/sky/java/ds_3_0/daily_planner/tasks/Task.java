package pro.sky.java.ds_3_0.daily_planner.tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {

    public static int counter = 0;

    private String title;
    private String description;
    private final TaskCategory taskCategory;
    private final LocalDateTime taskDataTime;
    private final int id;


    public Task(String title, String description, TaskCategory taskCategory, LocalDateTime taskDataTime) {
        setTitle(title);
        setDescription(description);
        if (taskCategory == null) {
            throw new IllegalArgumentException("Необходимо указать тип задачи");
        } else {
            this.taskCategory = taskCategory;
        }
        this.taskDataTime = taskDataTime;
        this.id = counter++;
    }

    public abstract boolean appearsIn(LocalDate date);

    public abstract String getTaskType();

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskCategory getTaskCategory() {
        return taskCategory;
    }

    public LocalDateTime getTaskDataTime() {
        return taskDataTime;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Необходимо заполнить заголовок задачи");
        } else {
            this.title = title;
        }
    }

    public void setDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Необходимо заполнить описание задачи");
        } else {
            this.description = description;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && Objects.equals(description, task.description) && taskCategory == task.taskCategory && Objects.equals(taskDataTime, task.taskDataTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, taskCategory, taskDataTime, id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", taskCategory=" + taskCategory +
                ", taskDataTime=" + taskDataTime +
                ", id=" + id +
                '}';
    }
}
