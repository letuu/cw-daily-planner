package pro.sky.java.ds_3_0.daily_planner;

import pro.sky.java.ds_3_0.daily_planner.tasks.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class PrintTask {

    public static void printTaskForDay(LocalDate date, Collection<Task> tasks) {
        String dateStr = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        if (tasks.size() == 0) {
            System.out.println("На выбранную дату " + dateStr + " задач нет");
        } else {
            System.out.println("\nСписок задач на " + dateStr + ":");
            for (Task task : tasks) {
                System.out.println(task.getId() + " " +
                        task.getTaskCategory() + " " +
                        task.getTitle() + " " +
                        task.getTaskDataTime().toLocalTime() + "; " +
                        "Описание: " +
                        task.getDescription());
            }
        }
    }

    public static void printAllTasks(Collection<Task> tasks) {
        if (tasks.size() == 0) {
            System.out.println("В ежедневнике задач пока нет");
        } else {
            System.out.println("\nСписок всех задач ежедневника:");
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");  //вывод в формате "dd.MM.yyyy"
            for (Task task : tasks) {
                System.out.println(task.getId() + " " +
                        task.getTaskDataTime().toLocalDate() + " " +
//                        task.getTaskDataTime().toLocalDate().format(formatter) + " " +    //вывод в формате "dd.MM.yyyy"
                        task.getTaskDataTime().toLocalTime() + "; " +
                        task.getTitle() + "; " +
                        task.getTaskCategory() + "; " +
                        task.getTaskType() + "; " +
                        "Описание: " +
                        task.getDescription());
            }
        }
    }

    public static void printForDelete(Collection<Task> tasks) {
        for (Task task : tasks) {
            System.out.printf("ID: %d - %s %s, %s%n", task.getId(), task.getTitle(), task.getTaskType(), task.getTaskCategory());
        }
    }
}
