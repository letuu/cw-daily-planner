package pro.sky.java.ds_3_0.daily_planner;

import pro.sky.java.ds_3_0.daily_planner.tasks.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws NoTaskException {

        SingleTask task1 = new SingleTask("SingleTask1", "Description1", TaskCategory.PERSONAL,
                LocalDateTime.of(2022, 11, 20, 12, 45));
        SingleTask task2 = new SingleTask("SingleTask2", "Description2", TaskCategory.WORK,
                LocalDateTime.of(2022, 11, 22, 17, 5));
        DailyTask task3 = new DailyTask("DailyTask1", "Description3", TaskCategory.PERSONAL,
                LocalDateTime.of(2022, 11, 20, 17, 20));
        DailyTask task4 = new DailyTask("DailyTask2", "Description4", TaskCategory.WORK,
                LocalDateTime.of(2022, 11, 22, 22, 55));

        Schedule schedule = new Schedule();

        schedule.addTask(task1);
        schedule.addTask(task2);
        schedule.addTask(task3);
        schedule.addTask(task4);

        LocalDate dateTasks1 = LocalDate.of(2022, 11, 22);
        System.out.println();
        PrintTask.printTaskForDay(dateTasks1, schedule.getTaskForDay(dateTasks1));
        System.out.println();
        PrintTask.printForDelete(schedule.getAllTasks());
        System.out.println();

//        schedule.removeTask(2);
//        PrintTask.printForDelete(schedule.getAllTasks());

        UserInterface userInterface = new UserInterface(schedule);
        userInterface.userInput();

    }
}
