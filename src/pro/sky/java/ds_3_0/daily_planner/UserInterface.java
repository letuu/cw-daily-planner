package pro.sky.java.ds_3_0.daily_planner;

import pro.sky.java.ds_3_0.daily_planner.tasks.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UserInterface {

    private final Schedule schedule;

    public UserInterface(Schedule schedule) {
        this.schedule = schedule;
    }

    public void userInput() throws NoTaskException {

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                try {
                    if (scanner.hasNextInt()) {
                        int menu = scanner.nextInt();
                        switch (menu) {
                            case 1:
                                inputTask(scanner);
                                break;
                            case 2:
                                removeTaskScan(scanner);
                                break;
                            case 3:
                                getTasksForDayInput(scanner);
                                break;
                            case 4:
                                PrintTask.printAllTasks(this.schedule.getAllTasks());
                                break;
                            case 0:
                                break label;
                            default:
                                System.out.println("Выберите пункт меню из списка!");
                        }
                    } else {
                        scanner.next();
                        System.out.println("Выберите пункт меню из списка!");
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Ошибка: Неправильный ввод даты, возврат в глвное меню");
                }
            }
        }
    }

    private void inputTask(Scanner scanner) {

        System.out.print("Введите название задачи: ");
        String taskName = scanner.useDelimiter("\n").next();

        System.out.print("Введите описание задачи: ");
        String taskDescription = scanner.useDelimiter("\n").next();

        TaskCategory taskCategory = TaskCategory.PERSONAL;
        label1:
        while (true) {
            printMenuTaskCategory();
            System.out.print("Выберите пункт меню с категорией задачи: ");
            if (scanner.hasNextInt()) {
                int menu = scanner.nextInt();
                switch (menu) {
                    case 1:
                        break label1;
                    case 2:
                        taskCategory = TaskCategory.WORK;
                        break label1;
                    default:
                        System.out.println("Выберите пункт меню из списка!");
                }
            } else {
                scanner.next();
                System.out.println("Выберите пункт меню из списка!");
            }
        }

//        System.out.print("Введите категорию задачи (\"Рабочая\" или \"Личная\"): ");
//        String taskCategoryInput = scanner.useDelimiter("\n").next();
//        TaskCategory taskCategory = TaskCategory.PERSONAL;
//        if (taskCategoryInput.equals("Рабочая")) {
//            taskCategory = TaskCategory.WORK;
//        }
//        if (!taskCategoryInput.equals("Личная") && !taskCategoryInput.equals("Рабочая")) {
//            System.out.print("Ввод с ошибкой категории задачи (\"Рабочая\" или \"Личная\"), возврат в главное меню");
//        //и добавить исключение в Scanner с возвратом в главное меню
//        }

        System.out.print("Формат ввода даты: \"ДД.ММ.ГГГГ\"\n");
        System.out.print("Введите дату задачи: ");
        String taskDate = scanner.next().trim();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse(taskDate, formatterDate);

        System.out.print("Формат ввода времени: \"ЧЧ:ММ\"\n");
        System.out.print("Введите время задачи: ");
        String taskTime = scanner.next().trim();
        LocalTime localTime = LocalTime.parse(taskTime);
        LocalDateTime localDateTime = localDate.atTime(localTime);


        label2:
        while (true) {
            printMenuTaskType();
            System.out.print("Выберите пункт меню с типом задачи либо выход в главное меню: ");
            if (scanner.hasNextInt()) {
                int menu = scanner.nextInt();
                switch (menu) {
                    case 1:
                        SingleTask singleTask = new SingleTask(taskName, taskDescription, taskCategory, localDateTime);
                        this.schedule.addTask(singleTask);
                        System.out.println(singleTask.getTaskType() + " задача \"" + taskName + "\" успешно добавлена в ежедневник");
                        break label2;
                    case 2:
                        DailyTask dailyTask = new DailyTask(taskName, taskDescription, taskCategory, localDateTime);
                        this.schedule.addTask(dailyTask);
                        System.out.println(dailyTask.getTaskType() + " задача \"" + taskName + "\" успешно добавлена в ежедневник");
                        break label2;
                    case 3:
                        WeeklyTask weeklyTask = new WeeklyTask(taskName, taskDescription, taskCategory, localDateTime);
                        this.schedule.addTask(weeklyTask);
                        System.out.println(weeklyTask.getTaskType() + " задача \"" + taskName + "\" успешно добавлена в ежедневник");
                        break label2;
                    case 4:
                        MonthlyTask monthlyTask = new MonthlyTask(taskName, taskDescription, taskCategory, localDateTime);
                        this.schedule.addTask(monthlyTask);
                        System.out.println(monthlyTask.getTaskType() + " задача \"" + taskName + "\" успешно добавлена в ежедневник");
                        break label2;
                    case 5:
                        AnnualTask annualTask = new AnnualTask(taskName, taskDescription, taskCategory, localDateTime);
                        this.schedule.addTask(annualTask);
                        System.out.println(annualTask.getTaskType() + " задача \"" + taskName + "\" успешно добавлена в ежедневник");
                        break label2;
                    case 0:
                        break label2;
                }
            } else {
                scanner.next();
                System.out.println("Выберите пункт меню из списка!");
            }
        }
    }

    private void removeTaskScan(Scanner scanner) throws NoTaskException {
        System.out.println("\nСписок задач, которые можно удалить:");
        PrintTask.printForDelete(this.schedule.getAllTasks());
        System.out.print("\nВведите ID задачи для удаления: ");
        int taskIdDeleted = 0;
        try {
            taskIdDeleted = Integer.parseInt(scanner.next().trim());
            this.schedule.removeTask(taskIdDeleted);
            System.out.println("\nЗадача с ID " + taskIdDeleted + " удалена.\nСписок задач после удаления:");
            PrintTask.printForDelete(this.schedule.getAllTasks());
        } catch (NumberFormatException e) {
            System.out.println("Неправильный формат ID, после выбора пункта меню 'Удалить задачу' повторите ввод ID");
        } catch (NoTaskException e) {
            System.out.println(e.getMessage());
        }
    }

    private void getTasksForDayInput(Scanner scanner) {
        System.out.print("Формат ввода даты: \"ДД.ММ.ГГГГ\"\n");
        System.out.print("Введите дату, на которую вывести задачи: ");
        String taskDate = scanner.next().trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse(taskDate, formatter);
        PrintTask.printTaskForDay(localDate, this.schedule.getTaskForDay(localDate));
    }

    private static void printMenu() {
        System.out.println("\n" +
                """
                        Главное меню:
                        1. Добавить задачу
                        2. Удалить задачу
                        3. Получить задачи на указанный день
                        4. Получить список всех задач ежедневника
                        0. Выход
                        """
        );
    }

    private static void printMenuTaskCategory() {
        System.out.println("\n" +
                """
                        Меню выбора категории задачи:
                        1. Личная
                        2. Рабочая
                        """
        );
    }

    private static void printMenuTaskType() {
        System.out.println("\n" +
                """
                        Меню выбора типа задачи:
                        1. Однократная
                        2. Ежедневная
                        3. Еженедельная
                        4. Ежемесячная
                        5. Ежегодная
                        0. Выход в главное меню
                        """
        );
    }
}
